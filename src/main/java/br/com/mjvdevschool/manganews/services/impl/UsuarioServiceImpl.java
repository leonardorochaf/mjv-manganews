package br.com.mjvdevschool.manganews.services.impl;

import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.exceptions.BusinessException;
import br.com.mjvdevschool.manganews.exceptions.ResourceNotFoundException;
import br.com.mjvdevschool.manganews.models.Perfil;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import br.com.mjvdevschool.manganews.utils.PerfilEnum;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> usuarioPorId = usuarioDao.buscarPorId(id);

        if(usuarioPorId.isEmpty()) {
            throw new ResourceNotFoundException("Usuario não encontrado com id informado");
        }

        return usuarioPorId.get();
    }

    @Override
    public void cadastrar(Usuario usuario) {
        Optional<Usuario> usuarioPorEmail = usuarioDao.buscarPorEmail(usuario.getEmail());

        if(usuarioPorEmail.isPresent()) {
            throw new BusinessException("Email já cadastrado");
        }

        Perfil perfil = new Perfil(2, PerfilEnum.CLIENTE.name());

        usuario.setPerfil(perfil);
        usuarioDao.salvar(usuario);
    }

}
