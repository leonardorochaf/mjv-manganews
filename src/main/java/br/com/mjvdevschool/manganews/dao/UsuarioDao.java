package br.com.mjvdevschool.manganews.dao;

import br.com.mjvdevschool.manganews.models.Usuario;

public interface UsuarioDao {

    Usuario buscarPorEmailESenha(String email, String senha);

    Usuario buscarPorEmail(String email);

    void salvar(Usuario usuario);

}
