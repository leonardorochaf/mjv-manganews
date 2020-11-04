package br.com.mjvdevschool.manganews.services;

import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.utils.LoggedUserUtils;

public interface LoginService {

    Usuario autenticaUsuario(Usuario usuario);

    void cadastraUsuario(Usuario usuario);

    void salvarUsuarioLogado(Usuario usuario);

    Usuario recuperarUsuarioLogado();

    Boolean verificarUsuarioLogado();

}
