package br.com.mjvdevschool.manganews.controllers;

import br.com.mjvdevschool.manganews.exceptions.BusinessException;
import br.com.mjvdevschool.manganews.models.Usuario;
import br.com.mjvdevschool.manganews.services.LoginService;
import br.com.mjvdevschool.manganews.utils.PerfilEnum;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return "login";
    }

    @PostMapping("/autenticar")
    public String autenticar(Usuario usuarioLoginRequest, RedirectAttributes atrAttributes) {
        try {
            Usuario usuario = loginService.autenticaUsuario(usuarioLoginRequest);

            return "redirect:/cliente/" + usuario.getId() + "/noticias";
        } catch (EmptyResultDataAccessException e) {
            atrAttributes.addFlashAttribute("mensagemErro", "Email ou senha invalidos");
            return "redirect:/login";
        } catch (Exception e) {
            atrAttributes.addFlashAttribute("mensagemErro", "Houve um erro ao fazer login. Tente novamente");
            return "redirect:/login";
        }
    }
    
    @GetMapping("/logout")
	public String logout(RedirectAttributes atributos) {
    	return "login";
	}

}
