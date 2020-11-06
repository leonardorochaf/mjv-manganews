package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.exceptions.ResourceNotFoundException;
import br.com.mjvdevschool.manganews.models.Manga;
import br.com.mjvdevschool.manganews.services.MangaService;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario/{id}")
public class MangaController {

    private final MangaService mangaService;

    private final UsuarioService usuarioService;

    public MangaController(MangaService mangaService, UsuarioService usuarioService) {
        this.mangaService = mangaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/meusmangas")
    public String listarTodosPorUsuario(@PathVariable Integer id, ModelMap model, RedirectAttributes atrAttributes) {
        try{
            model.put("usuarioLogado", usuarioService.buscarPorId(id));
        } catch (ResourceNotFoundException e) {
            atrAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/login";
        }
        model.put("mangasPossui", mangaService.buscarTodosQueUsuarioPossui(id));
        return "manga/listaMangas";
    }

    @PostMapping("/meusmangas/cadastrar")
    public String cadastrarMangaParaUsuario(@PathVariable Integer usuarioId, Manga manga, ModelMap model) {
        try {
            mangaService.cadastrarMangaParaUsuario(usuarioId, manga);
        } catch (ResourceNotFoundException e) {
            model.put("mensagemErro", "Houve um erro ao adquirir o mangá. Tente novamente mais tarde");
            return "redirect:/usuario" + usuarioId + "/meusmangas";
        }
        return "redirect:/usuario" + usuarioId + "/meusmangas";
    }

}
