package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.NoticiaDao;
import br.com.mjvdevschool.manganews.models.Noticia;
import br.com.mjvdevschool.manganews.services.NoticiaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaServiceImpl  implements NoticiaService {

    private final NoticiaDao noticiaDao;

    public NoticiaServiceImpl(NoticiaDao noticiaDao) {
        this.noticiaDao = noticiaDao;
    }

    @Override
    public List<Noticia> buscarTodos() {
        List<Noticia> noticias = noticiaDao.buscarTodos();

        return this.limitaPalavras(noticias);
    }

    @Override
    public List<Noticia> buscarMaisVistos() {
        int limit = 3;
        int quantidadePalavras = 20;
        List<Noticia> noticias = noticiaDao.buscarMaisVistos(limit);

        return this.limitaPalavras(noticias);
    }

    @Override
    public List<Noticia> buscarPorParametro(String parametro) {
        List<Noticia> noticias = noticiaDao.buscarPorParametro(parametro);

        return this.limitaPalavras(noticias);
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
