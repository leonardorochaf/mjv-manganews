package br.com.mjvdevschool.manganews.dao;

import br.com.mjvdevschool.manganews.models.Manga;

import java.util.List;

public interface MangaDao {

    List<Manga> buscarTodos();

    List<Manga> buscarTodosQueUsuarioPossui(Integer usuarioId);

}
