package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.services.NoticiaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class NoticiaController {

    private final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public String listar(ModelMap model) {
        model.put("noticiasCompletas", noticiaService.buscarTodos());
        model.put("noticiasMaisVistas", noticiaService.buscarMaisVistos());
        return "home";
    }

    @GetMapping("/busca")
    public String buscar(@RequestParam String parametro, ModelMap model) {
        model.put("noticiasResultado", noticiaService.buscarPorParametro(parametro));
        return "resultadoBusca";
    }

}
