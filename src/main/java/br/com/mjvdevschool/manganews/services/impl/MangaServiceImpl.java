package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.MangaDao;
import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.models.Manga;
import br.com.mjvdevschool.manganews.services.MangaService;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    private final MangaDao mangaDao;

    private final UsuarioDao usuarioDao;

    public MangaServiceImpl(MangaDao mangaDao, UsuarioDao usuarioDao) {
        this.mangaDao = mangaDao;
        this.usuarioDao = usuarioDao;
    }

    @Override
    public List<Manga> buscarTodosQueUsuarioPossui(Integer usuarioId) {
        return mangaDao.buscarTodosQueUsuarioPossui(usuarioId);
    }

    @Override
    public List<Manga> buscarTodosQueUsuarioNaoPossui(Integer usuarioId) {
        return mangaDao.buscarTodosQueUsuarioNaoPossui(usuarioId);
    }

    @Override
    public void cadastrarMangaParaUsuario(Integer usuarioId, Manga manga) {
            usuarioDao.buscarPorId(usuarioId);
            mangaDao.buscarPorid(manga.getId());

            mangaDao.cadastrarMangaParaUsuario(usuarioId, manga.getId());
    }
}
