package br.com.mjvdevschool.manganews.rowmapper;

import br.com.mjvdevschool.manganews.models.Autor;
import br.com.mjvdevschool.manganews.models.Noticia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticiaRowMapper implements RowMapper<Noticia> {

    @Override
    public Noticia mapRow(ResultSet rs, int i) throws SQLException {
        Noticia noticia = new Noticia();

        noticia.setId(rs.getInt(1));
        noticia.setTitulo(rs.getString("titulo"));
        noticia.setCorpo(rs.getString("corpo"));
        noticia.setDataLançamento(rs.getDate("dataLancamento"));
        noticia.setVisualizacoes(rs.getInt("visualizacoes"));
        noticia.setUrlImagem(rs.getString("urlImagem"));

        Autor autor = new Autor();

        autor.setId(rs.getInt(7));
        autor.setNome(rs.getString("nome"));

        noticia.setAutor(autor);

        return noticia;
    }

}
