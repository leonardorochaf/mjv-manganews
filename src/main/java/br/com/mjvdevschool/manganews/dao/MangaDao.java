package br.com.mjvdevschool.manganews.dao;

import br.com.mjvdevschool.manganews.models.Manga;

import java.util.List;
import java.util.Optional;

public interface MangaDao {

    List<Manga> buscarTodos();

    Optional<Manga> buscarPorid(Integer id);

    List<Manga> buscarTodosQueUsuarioPossui(Integer usuarioId);

    List<Manga> buscarTodosQueUsuarioNaoPossui(Integer usuarioId);

    void cadastrarMangaParaUsuario(Integer mangaId, Integer usuarioId);

}
