package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.models.Manga;
import br.com.mjvdevschool.manganews.services.MangaService;
import br.com.mjvdevschool.manganews.utils.LoggedUserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class MangaController {

    private final MangaService mangaService;

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("/{id}/meusmangas")
    public String listarTodosPorUsuario(@PathVariable Integer id, ModelMap model) {
        model.put("mangasPossui", mangaService.buscarTodosQueUsuarioPossui(id));
        return "listaMangas";
    }

    @PostMapping("/{id}/meusmangas/cadastrar")
    public String cadastrarMangaParaUsuario(@PathVariable Integer usuarioId, Manga manga) {
        mangaService.cadastrarMangaParaUsuario(usuarioId, manga);
        return "redirect:/cliente" + usuarioId + "/meusmangas";
    }
}
