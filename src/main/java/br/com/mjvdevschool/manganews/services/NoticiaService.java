package br.com.mjvdevschool.manganews.services;

import br.com.mjvdevschool.manganews.models.Noticia;

import java.util.List;

public interface NoticiaService {

    List<Noticia> buscarTodos();

    List<Noticia> buscarMaisVistos();

    List<Noticia> buscarPorParametro(String parametro);

    void cadastrar(Noticia noticia, Integer usuarioId);

}
