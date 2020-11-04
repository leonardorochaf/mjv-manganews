package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.MangaDao;
import br.com.mjvdevschool.manganews.models.Manga;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.LoginService;
import br.com.mjvdevschool.manganews.services.MangaService;
import br.com.mjvdevschool.manganews.utils.LoggedUserUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    private final MangaDao mangaDao;

    private final LoginService loginService;

    public MangaServiceImpl(MangaDao mangaDao, LoginService loginService) {
        this.mangaDao = mangaDao;
        this.loginService = loginService;
    }

    @Override
    public List<Manga> buscarTodosQueUsuarioPossui() {
        Usuario usuarioLogado = loginService.recuperarUsuarioLogado();

        return mangaDao.buscarTodosQueUsuarioPossui(usuarioLogado.getId());
    }
}
