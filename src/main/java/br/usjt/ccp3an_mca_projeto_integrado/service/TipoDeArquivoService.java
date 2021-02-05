package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ccp3an_mca_projeto_integrado.model.TipoDeArquivo;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.ITipoDeArquivoRepository;

@Service
public class TipoDeArquivoService implements ITipoDeArquivoService {

	@Autowired
	ITipoDeArquivoRepository tipoDeArquivoRepo;
	
	@Override
	public TipoDeArquivo carregar(Long id) {
		
		for(TipoDeArquivo tipoArquivo : tipoDeArquivoRepo.findAll()){
			if(tipoArquivo.getId() == id)
				return tipoArquivo;
		}
		
		return null;
	}

	@Override
	public List<TipoDeArquivo> carregarTodos() {
		return tipoDeArquivoRepo.findAll();
	}

}
