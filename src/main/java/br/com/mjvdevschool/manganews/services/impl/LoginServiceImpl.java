package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.exceptions.BusinessException;
import br.com.mjvdevschool.manganews.models.Perfil;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.LoginService;
import br.com.mjvdevschool.manganews.utils.LoggedUserUtils;
import br.com.mjvdevschool.manganews.utils.PerfilEnum;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private static Usuario usuario;

    private final UsuarioDao usuarioDao;

    public LoginServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario autenticaUsuario(Usuario usuario) {
        Usuario usuarioAutenticado = usuarioDao.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());

        this.salvarUsuarioLogado(usuarioAutenticado);

        return usuarioAutenticado;
    }

    @Override
    public void cadastraUsuario(Usuario usuario) {
        try {
            Usuario usurioPorEmail = usuarioDao.buscarPorEmail(usuario.getEmail());

            throw new BusinessException("Email já cadastrado");
        } catch (EmptyResultDataAccessException e) {
            Perfil perfil = new Perfil(2, PerfilEnum.CLIENTE.name());

            usuario.setPerfil(perfil);

            usuarioDao.salvar(usuario);
        }
    }

    public void salvarUsuarioLogado(Usuario usuario) {
        LoginServiceImpl.usuario = usuario;
    }

    public Usuario recuperarUsuarioLogado() {
        return LoginServiceImpl.usuario;
    }

    public Boolean verificarUsuarioLogado() {
        return LoginServiceImpl.usuario == null;
    }

}
