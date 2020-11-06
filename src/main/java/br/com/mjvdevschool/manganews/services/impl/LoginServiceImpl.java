package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.exceptions.ResourceNotFoundException;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UsuarioDao usuarioDao;

    public LoginServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario autenticaUsuario(Usuario usuario) {
        Optional<Usuario> usuarioAutenticado = usuarioDao.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());

        if(usuarioAutenticado.isEmpty()) {
            throw new ResourceNotFoundException("Email ou senha invalidos");
        }

        return usuarioAutenticado.get();
    }

}
