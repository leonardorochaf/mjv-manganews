package br.com.mjvdevschool.manganews.dao.impl;

import br.com.mjvdevschool.manganews.dao.MangaDao;
import br.com.mjvdevschool.manganews.models.Manga;
import br.com.mjvdevschool.manganews.rowmapper.MangaRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MangaDaoImpl implements MangaDao {

    private final NamedParameterJdbcTemplate template;

    public MangaDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Manga> buscarTodos() {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM manga");

        return template.query(sql.toString(), new MangaRowMapper());
    }

    @Override
    public List<Manga> buscarTodosQueUsuarioPossui(Integer usuarioId) {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT m.* FROM manga m JOIN usuario_manga um ON m.id = um.manga_id " +
                "JOIN usuario u ON u.id = um.usuario_id " +
                "WHERE u.id = :usuarioId");

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("usuarioId", usuarioId);

        return template.query(sql.toString(), params, new MangaRowMapper());
    }
}
