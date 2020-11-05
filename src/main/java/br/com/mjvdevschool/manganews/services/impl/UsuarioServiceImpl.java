package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioDao.buscarPorId(id);
    }
}
