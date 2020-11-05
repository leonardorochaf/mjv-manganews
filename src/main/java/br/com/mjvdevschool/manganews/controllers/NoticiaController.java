package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.NoticiaService;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class NoticiaController {

    private final NoticiaService noticiaService;

    private final UsuarioService usuarioService;

    public NoticiaController(NoticiaService noticiaService, UsuarioService usuarioService) {
        this.noticiaService = noticiaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}/noticias")
    public String listar(@PathVariable Integer id, ModelMap model) {
        model.put("usuarioLogado",  usuarioService.buscarPorId(id));
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
