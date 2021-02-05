package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.util.List;

import br.usjt.ccp3an_mca_projeto_integrado.model.TipoDeArquivo;

public interface ITipoDeArquivoService {
	public TipoDeArquivo carregar(Long id);
	public List<TipoDeArquivo> carregarTodos();
}
