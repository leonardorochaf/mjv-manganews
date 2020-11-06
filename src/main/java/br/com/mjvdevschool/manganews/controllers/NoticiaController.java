package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.exceptions.ResourceNotFoundException;
import br.com.mjvdevschool.manganews.models.Noticia;
import br.com.mjvdevschool.manganews.services.NoticiaService;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario/{id}")
public class NoticiaController {

    private final NoticiaService noticiaService;

    private final UsuarioService usuarioService;

    public NoticiaController(NoticiaService noticiaService, UsuarioService usuarioService) {
        this.noticiaService = noticiaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/noticias")
    public String listar(@PathVariable Integer id, ModelMap model, RedirectAttributes atrAttributes) {
        try{
            model.put("usuarioLogado", usuarioService.buscarPorId(id));
        } catch (ResourceNotFoundException e) {
            atrAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/login";
        }
        model.put("noticiasCompletas", noticiaService.buscarTodos());
        model.put("noticiasMaisVistas", noticiaService.buscarMaisVistos());
        return "home";
    }

    @GetMapping("/noticias/busca")
    public String buscar(@RequestParam String parametro, ModelMap model) {
        model.put("noticiasResultado", noticiaService.buscarPorParametro(parametro));
        return "noticia/resultadoBusca";
    }

    @PostMapping("/noticias/cadastrar")
    public String novaNoticia(Noticia noticia, @PathVariable Integer id, RedirectAttributes atrAttributes) {
        try {
            noticiaService.cadastrar(noticia, id);
            atrAttributes.addFlashAttribute("mensagemSucesso", "Noticia cadastrado com sucesso");
            return "redirect:/usuario/" + id + "/noticias";
        } catch (Exception e) {
            atrAttributes.addFlashAttribute("mensagemErro", "Houve um erro. Por favor faça login novamente");
            return "redirect:/login";
        }
    }

}
