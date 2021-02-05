package br.usjt.ccp3an_mca_projeto_integrado.controller;

import br.usjt.ccp3an_mca_projeto_integrado.model.Usuario;
import br.usjt.ccp3an_mca_projeto_integrado.service.CadastroService;
import br.usjt.ccp3an_mca_projeto_integrado.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private CadastroService cadastroService;

    @GetMapping(value = {"/cadastro"})
    public ModelAndView login () {
        ModelAndView mv = new ModelAndView ("cadastro");
        mv.addObject(new Usuario());
        return mv;
    }

    @PostMapping("/fazerCadastro")
    public String fazerCadastro(Usuario usuario, Model model){
        if(cadastroService.verificaLogin(usuario)) {
            model.addAttribute("erroCadastro", "erroCadastro");
            return "cadastro";
        } else {
            cadastroService.salvar(usuario);
        }
        return "login";
    }
}
