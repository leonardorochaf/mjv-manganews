package br.com.mjvdevschool.manganews.rowmapper;

import br.com.mjvdevschool.manganews.models.Perfil;
import br.com.mjvdevschool.manganews.models.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int i) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(rs.getInt(1));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setSenha(rs.getString("senha"));

        Perfil perfil = new Perfil();

        perfil.setId(rs.getInt(5));
        perfil.setNome(rs.getString(6));

        usuario.setPerfil(perfil);

        return usuario;
    }
}
