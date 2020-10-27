package br.com.mjvdevschool.manganews.dao;

import br.com.mjvdevschool.manganews.models.Noticia;

import java.util.List;

public interface NoticiaDao {

    List<Noticia> buscarTodos();

    List<Noticia> buscarMaisVistos(int limit);

    List<Noticia> buscarPorParametro(String parametro);

}
