package br.usjt.ccp3an_mca_projeto_integrado.service;

import br.usjt.ccp3an_mca_projeto_integrado.model.ExtensaoArquivo;

public interface IExtensaoArquivoService {
	public ExtensaoArquivo carregarPorDescricao(String descricao);
}
