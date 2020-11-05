package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.exceptions.BusinessException;
import br.com.mjvdevschool.manganews.models.Perfil;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import br.com.mjvdevschool.manganews.utils.PerfilEnum;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Override
    public void cadastrar(Usuario usuario) {
        try {
            usuarioDao.buscarPorEmail(usuario.getEmail());

            throw new BusinessException("Email já cadastrado");
        } catch (EmptyResultDataAccessException e) {
            Perfil perfil = new Perfil(2, PerfilEnum.CLIENTE.name());

            usuario.setPerfil(perfil);

            usuarioDao.salvar(usuario);
        }
    }
}
