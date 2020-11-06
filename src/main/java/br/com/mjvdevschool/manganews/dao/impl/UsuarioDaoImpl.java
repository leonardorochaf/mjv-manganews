package br.com.mjvdevschool.manganews.dao.impl;

import br.com.mjvdevschool.manganews.dao.UsuarioDao;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.rowmapper.UsuarioRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

    private final NamedParameterJdbcTemplate template;

    public UsuarioDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT u.id, u.nome, u.email, u.senha, p.id, p.nome " +
                    "FROM usuario u JOIN perfil p ON u.perfil_id = p.id WHERE u.id = :id");

            MapSqlParameterSource params = new MapSqlParameterSource();

            params.addValue("id", id);

            return Optional.ofNullable(template.queryForObject(sql.toString(), params, new UsuarioRowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Usuario> buscarPorEmailESenha(String email, String senha) {
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT u.id, u.nome, u.email, u.senha, p.id, p.nome FROM usuario u " +
                    "JOIN perfil p ON u.perfil_id = p.id " +
                    "WHERE u.email = :email AND u.senha = :senha");

            MapSqlParameterSource params = new MapSqlParameterSource();

            params.addValue("email", email);
            params.addValue("senha", senha);

            return Optional.ofNullable(template.queryForObject(sql.toString(), params, new UsuarioRowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT u.id, u.nome, u.email, u.senha, p.id, p.nome FROM usuario u " +
                    "JOIN perfil p ON u.perfil_id = p.id " +
                    "WHERE u.email = :email");

            MapSqlParameterSource params = new MapSqlParameterSource();

            params.addValue("email", email);

            return Optional.ofNullable(template.queryForObject(sql.toString(), params, new UsuarioRowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, email, senha, perfil_id) VALUES(:nome, :email, :senha, :perfil_id)";

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("nome", usuario.getNome());
        params.addValue("email", usuario.getEmail());
        params.addValue("senha", usuario.getSenha());
        params.addValue("perfil_id", usuario.getPerfil().getId());

        template.update(sql, params);
    }

}
