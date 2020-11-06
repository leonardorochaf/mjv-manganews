package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.exceptions.BusinessException;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "autenticacao/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Usuario usuario, RedirectAttributes atrAttributes) {
        List<String> mensagens = new ArrayList<>();

        if(StringUtils.isEmpty(usuario.getNome())) {
            mensagens.add("Nome não informado");
        }

        if(StringUtils.isEmpty(usuario.getEmail())) {
            mensagens.add("Email não informado");
        }

        if(StringUtils.isEmpty(usuario.getSenha())) {
            mensagens.add("Senha não informada");
        }

        if(!mensagens.isEmpty()) {
            atrAttributes.addFlashAttribute("mensagensErroFormulario", mensagens);
            return "redirect:/cadastro";
        }

        try {
            usuarioService.cadastrar(usuario);
            atrAttributes.addFlashAttribute("mensagemSucesso", "Cadastro efetudado com sucesso");
            return "redirect:/login";
        } catch (BusinessException e) {
            atrAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/cadastro";
        }
        catch (Exception e) {
            atrAttributes.addFlashAttribute("mensagemErro", "Houve um erro ao tentar cadastrar. Tente novamente");
            return "redirect:/cadastro";
        }
    }
}
