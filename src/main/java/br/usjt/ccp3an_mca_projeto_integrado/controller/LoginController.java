package br.usjt.ccp3an_mca_projeto_integrado.controller;

import br.usjt.ccp3an_mca_projeto_integrado.model.Usuario;
import br.usjt.ccp3an_mca_projeto_integrado.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping (value = {"/login", "/fazerLogin"})
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView ("login");
        mv.addObject(new Usuario());
        return mv;
    }

    @PostMapping({"/login", "/fazerLogin"})
    public String fazerLogin(HttpServletRequest request, HttpSession session, Usuario usuario, Model model) {
        session.invalidate();
        if (loginService.logar(usuario)) {
            switch (loginService.verificarPermissao(usuario)) {
                case "administrador":
                    request.getSession().setAttribute("administrador", usuario);
                    return "redirect:/categoria";
                case "usuario":
                    request.getSession().setAttribute("usuario", usuario);
                    return "redirect:/home/busca";
                case "estagiario":
                    request.getSession().setAttribute("estagiario", usuario);
                    return "redirect:/conteudo/criar";
            }
        } else {
            model.addAttribute("erroLogin", "erroLogin");
        }
        return "login";
    }
}