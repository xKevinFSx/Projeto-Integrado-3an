package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.util.List;

import br.usjt.ccp3an_mca_projeto_integrado.model.Categoria;

public interface ICategoriaService {
	public List<Categoria> carregarCategorias();
	public void inserirCategoria(Categoria categoria);
	public void removerCategoria(Categoria categoria);
}
