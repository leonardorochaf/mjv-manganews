package br.com.mjvdevschool.manganews.services;

import br.com.mjvdevschool.manganews.models.Manga;

import java.util.List;

public interface MangaService {

    List<Manga> buscarTodosQueUsuarioPossui();

}
