package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.NoticiaDao;
import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.exceptions.ResourceNotFoundException;
import br.com.mjvdevschool.manganews.models.Noticia;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.NoticiaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServiceImpl  implements NoticiaService {

    private final NoticiaDao noticiaDao;

    private final UsuarioDao usuarioDao;

    public NoticiaServiceImpl(NoticiaDao noticiaDao, UsuarioDao usuarioDao) {
        this.noticiaDao = noticiaDao;
        this.usuarioDao = usuarioDao;
    }

    @Override
    public List<Noticia> buscarTodos() {
        List<Noticia> noticias = noticiaDao.buscarTodos();

        return this.limitaPalavras(noticias);
    }

    @Override
    public List<Noticia> buscarMaisVistos() {
        int limit = 3;
        List<Noticia> noticias = noticiaDao.buscarMaisVistos(limit);

        return this.limitaPalavras(noticias);
    }

    @Override
    public List<Noticia> buscarPorParametro(String parametro) {
        List<Noticia> noticias = noticiaDao.buscarPorNomeAutorOuTitulo(parametro);

        return this.limitaPalavras(noticias);
    }

    @Override
    public void cadastrar(Noticia noticia, Integer usuarioId) {
        Optional<Usuario> usuarioPorId = usuarioDao.buscarPorId(usuarioId);

        if(usuarioPorId.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum usuario encontrado com o id" + usuarioId);
        }

        noticia.setDataLançamento(new Date());
        noticia.setVisualizacoes(0);
        if(noticia.getUrlImagem().isBlank()) {
            noticia.setUrlImagem("https://www.thermaxglobal.com/wp-content/uploads/2020/05/image-not-found.jpg");
        }

        noticiaDao.salvar(noticia, usuarioId);
    }

    private List<Noticia> limitaPalavras(List<Noticia> noticias) {
        int quantidadePalavras = 20;
        for(Noticia n : noticias) {
            String texto[] = n.getCorpo().split(" ");
            String textoResumido = "";
            for(int i = 0; i < quantidadePalavras; i++) {
                textoResumido += texto[i] + " ";
            }
            n.setCorpo(textoResumido + "...");
        }
        return noticias;
    }
}
