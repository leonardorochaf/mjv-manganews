package br.com.mjvdevschool.manganews.dao;

import br.com.mjvdevschool.manganews.models.Usuario;

import java.util.Optional;

public interface UsuarioDao {

    Optional<Usuario> buscarPorId(Integer id);

    Optional<Usuario> buscarPorEmailESenha(String email, String senha);

    Optional<Usuario> buscarPorEmail(String email);

    void salvar(Usuario usuario);

}
