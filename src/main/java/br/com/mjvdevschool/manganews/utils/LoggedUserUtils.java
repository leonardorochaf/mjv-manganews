package br.com.mjvdevschool.manganews.utils;

import br.com.mjvdevschool.manganews.models.Usuario;

public class LoggedUserUtils {

    private static Usuario usuario;

    public void salvarUsuarioLogado(Usuario usuario) {
        LoggedUserUtils.usuario = usuario;
    }

    public Usuario recuperarUsuarioLogado() {
        return LoggedUserUtils.usuario;
    }

    public Boolean verificarUsuarioLogado() {
        return LoggedUserUtils.usuario == null;
    }

}
