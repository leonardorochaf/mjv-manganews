package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.services.MangaService;
import br.com.mjvdevschool.manganews.utils.LoggedUserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class MangaController {

    private final MangaService mangaService;

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("/meusmangas")
    public String listarTodosPorUsuario(ModelMap model) {

        LoggedUserUtils loggedUserUtils = new LoggedUserUtils();

        if(loggedUserUtils.verificarUsuarioLogado()) {

        }


        model.put("mangas", mangaService.buscarTodosQueUsuarioPossui());
        return "listaMangas";
    }
}
