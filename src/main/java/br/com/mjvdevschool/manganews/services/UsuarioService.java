package br.com.mjvdevschool.manganews.services;

import br.com.mjvdevschool.manganews.models.Usuario;

public interface UsuarioService {

    Usuario buscarPorId(Integer id);

    void cadastrar(Usuario usuario);

}
