package br.usjt.ccp3an_mca_projeto_integrado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ccp3an_mca_projeto_integrado.model.ExtensaoArquivo;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.IExtensaoArquivoRepository;

@Service
public class ExtensaoArquivoService implements IExtensaoArquivoService {

	@Autowired
	IExtensaoArquivoRepository extensaoArquivoRepo;
	
	@Override
	public ExtensaoArquivo carregarPorDescricao(String descricao) {
		
		ExtensaoArquivo extensaoArquivo = extensaoArquivoRepo.findByDescricao(descricao);
		
		if(extensaoArquivo == null)
		{
			ExtensaoArquivo nova = new ExtensaoArquivo();
			nova.setDescricao(descricao);
			
			extensaoArquivo = extensaoArquivoRepo.save(nova);
		}
				
		return extensaoArquivo;
	}

}
