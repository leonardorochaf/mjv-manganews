package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.exceptions.BusinessException;
import br.com.mjvdevschool.manganews.models.Perfil;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.LoginService;
import br.com.mjvdevschool.manganews.utils.PerfilEnum;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final UsuarioDao usuarioDao;

    public LoginServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario autenticaUsuario(Usuario usuario) {
        Usuario usuarioAutenticado = usuarioDao.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());

        return usuarioAutenticado;
    }

}
