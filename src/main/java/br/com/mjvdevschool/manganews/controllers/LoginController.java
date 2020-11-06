package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.exceptions.ResourceNotFoundException;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.LoginService;
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
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        return "autenticacao/login";
    }

    @PostMapping("/autenticar")
    public String autenticar(Usuario usuarioLoginRequest, RedirectAttributes atrAttributes) {
        List<String> mensagens = new ArrayList<>();

        if(StringUtils.isEmpty(usuarioLoginRequest.getEmail())) {
            mensagens.add("Email não informado");
        }

        if(StringUtils.isEmpty(usuarioLoginRequest.getSenha())) {
            mensagens.add("Senha não informada");
        }

        if(!mensagens.isEmpty()) {
            atrAttributes.addFlashAttribute("mensagensErroFormulario", mensagens);
            return "redirect:/login";
        }

        try {
            Usuario usuario = loginService.autenticaUsuario(usuarioLoginRequest);

            return "redirect:/usuario/" + usuario.getId() + "/noticias";
        } catch (ResourceNotFoundException e) {
            atrAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            atrAttributes.addFlashAttribute("mensagemErro", "Houve um erro ao fazer login. Tente novamente mais tarde");
            return "redirect:/login";
        }
    }
    
    @GetMapping("/logout")
	public String logout(RedirectAttributes atributos) {
    	return "redirect:/login";
	}

}
