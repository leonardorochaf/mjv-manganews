package br.com.mjvdevschool.manganews.dao;

import br.com.mjvdevschool.manganews.models.Noticia;

import java.util.List;

public interface NoticiaDao {

    List<Noticia> buscarTodos();

    List<Noticia> buscarMaisVistos(int limit);

    List<Noticia> buscarPorNomeAutorOuTitulo(String parametro);

    void salvar(Noticia noticia, Integer usuarioId);

}
