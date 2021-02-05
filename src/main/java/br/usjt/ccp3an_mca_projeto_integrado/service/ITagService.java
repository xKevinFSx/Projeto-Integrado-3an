package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.util.List;

import br.usjt.ccp3an_mca_projeto_integrado.model.Tag;

public interface ITagService {
	public List<Tag> carregarTag();
	public void inserirTag(Tag tag);
	public void removerTag(Tag tag);
}
