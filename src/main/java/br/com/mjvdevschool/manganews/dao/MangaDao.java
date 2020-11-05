package br.com.mjvdevschool.manganews.dao;

import br.com.mjvdevschool.manganews.models.Manga;

import java.util.List;

public interface MangaDao {

    List<Manga> buscarTodos();

    Manga buscarPorid(Integer id);

    List<Manga> buscarTodosQueUsuarioPossui(Integer usuarioId);

    List<Manga> buscarTodosQueUsuarioNaoPossui(Integer usuarioId);

    void cadastrarMangaParaUsuario(Integer mangaId, Integer usuarioId);

}
