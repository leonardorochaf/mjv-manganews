package br.com.mjvdevschool.manganews.dao.impl;

import br.com.mjvdevschool.manganews.dao.NoticiaDao;
import br.com.mjvdevschool.manganews.models.Noticia;
import br.com.mjvdevschool.manganews.rowmapper.NoticiaRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticiaDaoImpl implements NoticiaDao {

    private final NamedParameterJdbcTemplate template;

    public NoticiaDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Noticia> buscarTodos() {
        String sql = "SELECT n.id, n.titulo, n.corpo, n.dataLancamento, n.visualizacoes, n.urlImagem, a.id, a.nome " +
                "FROM noticia AS n JOIN usuario AS a ON n.user_id = a.id " +
                "ORDER BY dataLancamento DESC";

        return template.query(sql, new NoticiaRowMapper());
    }

    @Override
    public List<Noticia> buscarMaisVistos(int limit) {
        String sql = "SELECT n.id, n.titulo, n.corpo, n.dataLancamento, n.visualizacoes, n.urlImagem, a.id, a.nome " +
                "FROM noticia AS n JOIN usuario AS a ON n.user_id = a.id " +
                "ORDER BY visualizacoes DESC LIMIT :limit";

        MapSqlParameterSource param = new MapSqlParameterSource();

        param.addValue("limit", limit);

        return template.query(sql, param, new NoticiaRowMapper());
    }

    @Override
    public List<Noticia> buscarPorParametro(String parametro) {
        String sql = "SELECT n.id, n.titulo, n.corpo, n.dataLancamento, n.visualizacoes, n.urlImagem, a.id, a.nome " +
                "FROM noticia AS n JOIN usuario AS a ON n.user_id = a.id " +
                "WHERE n.titulo LIKE :parametro OR a.nome LIKE :parametro ORDER BY dataLancamento DESC";

        MapSqlParameterSource param = new MapSqlParameterSource();

        param.addValue("parametro", "%" + parametro + "%");

        return template.query(sql, param, new NoticiaRowMapper());
    }

}
