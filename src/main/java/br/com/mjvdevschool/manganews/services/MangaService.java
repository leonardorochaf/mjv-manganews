package br.com.mjvdevschool.manganews.services;

import br.com.mjvdevschool.manganews.models.Manga;

import java.util.List;

public interface MangaService {

    List<Manga> buscarTodosQueUsuarioPossui(Integer usuarioId);

    List<Manga> buscarTodosQueUsuarioNaoPossui(Integer usuarioId);

    void cadastrarMangaParaUsuario(Integer usuarioId, Manga manga);

}
