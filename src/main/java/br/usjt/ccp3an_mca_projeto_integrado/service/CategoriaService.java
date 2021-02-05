package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ccp3an_mca_projeto_integrado.model.Categoria;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.ICategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {
	
	@Autowired
	ICategoriaRepository categoriaRepo;
	
	public List<Categoria> carregarCategorias(){
		return categoriaRepo.findAll();
	}
	
	public void inserirCategoria(Categoria categoria) {
		categoriaRepo.save(categoria);
	}

	@Override
	public void removerCategoria(Categoria categoria) {
		categoriaRepo.delete(categoria);
	}
}
