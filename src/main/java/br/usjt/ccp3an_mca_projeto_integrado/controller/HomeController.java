package br.usjt.ccp3an_mca_projeto_integrado.controller;

import br.usjt.ccp3an_mca_projeto_integrado.model.Categoria;
import br.usjt.ccp3an_mca_projeto_integrado.model.Conteudo;
import br.usjt.ccp3an_mca_projeto_integrado.service.ICategoriaService;
import br.usjt.ccp3an_mca_projeto_integrado.service.IConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IConteudoService conteudoService;

    @Autowired
    ICategoriaService categoriaService;

    @GetMapping({"/home", "/"})
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView ("index");
        List<Categoria> categorias = categoriaService.carregarCategorias();
        mv.addObject(new Conteudo());
        List<Conteudo> conteudos = conteudoService.findAll();
        mv.addObject("conteudos", conteudos);
        mv.addObject(new Conteudo());
        mv.addObject("categorias", categorias);
        return mv;
    }

    @PostMapping("index")
    public String criar(@RequestParam("lang") String lang) {

        return "index";
    }

    @GetMapping("index")
    public String criar() {

        return "index";
    }
    
    @GetMapping("/home/busca_categoria/{categoria}")
	public ModelAndView buscaPorCategoria(@PathVariable String categoria) {
		
    	ModelAndView mv = new ModelAndView("index");
		
		List<Categoria> categorias = categoriaService.carregarCategorias();
		mv.addObject("categorias", categorias);
		
		mv.addObject(new Conteudo());
		List<Conteudo> conteudos = conteudoService.buscaPorCategoria(categoria);
		mv.addObject("conteudos", conteudos);
		
		return mv;
	}
    
    @GetMapping("/home/busca")
	public ModelAndView buscarConteudo(String descricao) {
		ModelAndView mv = new ModelAndView("index");

		List<Categoria> categorias = categoriaService.carregarCategorias();
		mv.addObject("categorias", categorias);
		
		mv.addObject(new Conteudo());
		List<Conteudo> conteudos = conteudoService.findAll();
		mv.addObject("conteudos", conteudos);
		return mv;
	}

}