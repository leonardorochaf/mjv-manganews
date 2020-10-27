package br.com.mjvdevschool.manganews.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {

    private Integer id;
    private String titulo;
    private String corpo;
    private Date dataLançamento;
    private Integer visualizacoes;
    private String urlImagem;
    private Autor autor;

}
