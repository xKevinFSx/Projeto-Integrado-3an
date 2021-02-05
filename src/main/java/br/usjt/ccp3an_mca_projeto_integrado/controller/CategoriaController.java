package br.usjt.ccp3an_mca_projeto_integrado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.ccp3an_mca_projeto_integrado.service.ICategoriaService;
import br.usjt.ccp3an_mca_projeto_integrado.model.Categoria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CategoriaController {

	@Autowired
    ICategoriaService categoriaService;
	
	@GetMapping("/categoria")
	public ModelAndView Categoria(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if(session.getAttribute("administrador") == null) {
			return new ModelAndView ("redirect:/login");
		} else if (session.getAttribute("usuario") != null || session.getAttribute("estagiario") != null) {
			return new ModelAndView ("redirect:/login");
		}

		ModelAndView mv = new ModelAndView("categoria");
		
		List<Categoria> categorias = categoriaService.carregarCategorias();
		mv.addObject("categorias", categorias);
		
		return mv;
	}
	
	@PostMapping("/inserirCategoria")
	public ModelAndView inserirCategoria(@RequestParam("nome") String nomeCategoria, HttpServletRequest request) {
		
		Categoria categoria = new Categoria();
		categoria.setDescricao(nomeCategoria);
		
		categoriaService.inserirCategoria(categoria);
		
		return Categoria(request);
	}

	@PostMapping("/removerCategoria")
	public ModelAndView removerCategoria(@RequestParam("id") Long id, HttpServletRequest request) {

		Categoria categoria = new Categoria();
		categoria.setId(id);

		categoriaService.removerCategoria(categoria);

		return Categoria(request);
	}
}
