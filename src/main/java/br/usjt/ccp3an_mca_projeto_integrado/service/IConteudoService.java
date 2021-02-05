package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.util.List;

import br.usjt.ccp3an_mca_projeto_integrado.model.Arquivo;
import br.usjt.ccp3an_mca_projeto_integrado.model.Conteudo;

public interface IConteudoService {
	public void inserir(Conteudo conteudo);
	public Conteudo encapsular(String titulo, String descricao, Long arquivoId, String html, Long categoriaId,
								List<Long> listaTagsId, Boolean tipoAcesso);
	public String gerarHtml(String html, Arquivo arquivo, String descricao);
	public List<Conteudo> buscaPorDescricao(String descricao);
	public List<Conteudo> buscaPorCategoria(String categoria);
	public List<Conteudo> findAll();
    public void darLike(Long id);
    public void darDislike(Long id);
}
