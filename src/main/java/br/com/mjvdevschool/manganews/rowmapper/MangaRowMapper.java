package br.com.mjvdevschool.manganews.rowmapper;

import br.com.mjvdevschool.manganews.models.Manga;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MangaRowMapper implements RowMapper<Manga> {

    @Override
    public Manga mapRow(ResultSet rs, int i) throws SQLException {
        Manga manga = new Manga();

        manga.setId(rs.getInt("id"));
        manga.setNome(rs.getString("nome"));

        return manga;
    }
}
