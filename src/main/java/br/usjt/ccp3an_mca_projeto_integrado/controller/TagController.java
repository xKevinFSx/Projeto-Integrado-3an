package br.usjt.ccp3an_mca_projeto_integrado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.ccp3an_mca_projeto_integrado.model.Categoria;
import br.usjt.ccp3an_mca_projeto_integrado.service.ICategoriaService;
import br.usjt.ccp3an_mca_projeto_integrado.service.ITagService;
import br.usjt.ccp3an_mca_projeto_integrado.model.Tag;

@Controller
public class TagController {

	@Autowired
	ITagService tagService;
	
	@Autowired
    ICategoriaService categoriaService;
	
	@GetMapping("/tag")
	public ModelAndView Tag() {
		
		ModelAndView mv = new ModelAndView("tag");
		
		List<Categoria> categorias = categoriaService.carregarCategorias();
		mv.addObject("categorias", categorias);

		List<Tag> tags = tagService.carregarTag();
		mv.addObject("tags", tags);
		
		return mv;
	}
	
	@PostMapping("/inserirTag")
	public ModelAndView inserirCategoria(@RequestParam("nome") String nomeTag) {
		
		Tag tag = new Tag();
		tag.setNomeTag(nomeTag);
		
		tagService.inserirTag(tag);
		
		return Tag();
	}

	@PostMapping("/removerTag")
	public ModelAndView removerTag(@RequestParam("id") Long id) {

		Tag tag = new Tag();
		tag.setId(id);

		tagService.removerTag(tag);

		return Tag();
	}
}
