package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ccp3an_mca_projeto_integrado.model.Tag;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.ITagRepository;

@Service
public class TagService implements ITagService{

	@Autowired
	ITagRepository tagRepo;
	
	public List<Tag> carregarTag() {
		return tagRepo.findAll();
	}

	@Override
	public void inserirTag(Tag tag) {
		tagRepo.save(tag);
	}

	@Override
	public void removerTag(Tag tag) {
		tagRepo.delete(tag);
	}

}
