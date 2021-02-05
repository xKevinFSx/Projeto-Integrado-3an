package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ccp3an_mca_projeto_integrado.model.Arquivo;
import br.usjt.ccp3an_mca_projeto_integrado.model.Categoria;
import br.usjt.ccp3an_mca_projeto_integrado.model.Conteudo;
import br.usjt.ccp3an_mca_projeto_integrado.model.Tag;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.IConteudoRepository;

@Service
public class ConteudoService implements IConteudoService{

	@Autowired
	IConteudoRepository conteudoRepo; 
	
	public void inserir(Conteudo conteudo) {
		conteudoRepo.save(conteudo);
	}

	public Conteudo encapsular(String titulo, String descricao, Long arquivoId, String html, Long categoriaId,
			List<Long> listaTagsId, Boolean tipoAcesso) {
		
		Arquivo arquivo = new Arquivo();
		arquivo.setId(arquivoId);
		
		Categoria categoria = new Categoria();
		categoria.setId(categoriaId);
		
		List<Tag> listaTags = new ArrayList<Tag>();
		for(Long item:listaTagsId)
		{
			Tag tag = new Tag();
			tag.setId(item);
			listaTags.add(tag);
		}
		
		Conteudo conteudo = new Conteudo();
		conteudo.setTitulo(titulo);
		conteudo.setDescricao(descricao);
		conteudo.setArquivo(arquivo);
		conteudo.setHtml(html);
		conteudo.setCategoria(categoria);
		conteudo.setTags(listaTags);
		conteudo.setIsPublico(tipoAcesso);
		conteudo.setData(LocalDateTime.now());
		
		return conteudo;
	}

	public String gerarHtml(String html, Arquivo arquivo, String descricao) {
		
		if(html.contains("##arquivo##")) {
			html = html.replace("##arquivo##", gerarTagArquivo(arquivo));
		}
		
		if(html.contains("##descricao##")) {
			html = html.replace("##descricao##", descricao);
		}
		
		return html;
	}
	
	private String gerarTagArquivo(Arquivo arquivo) {
		StringBuilder tagHtml = new StringBuilder();
		String tipoArquivo = arquivo.getExtensao().getTipoDeArquivo().getDescricao();
		String caminhoComArquivo = gerarCaminhoComArquivo(arquivo);
		
		if(tipoArquivo.toLowerCase().equals("imagem")) {
			tagHtml.append("<img src='");
			tagHtml.append(caminhoComArquivo);
			tagHtml.append("' >");  
		}else if(tipoArquivo.toLowerCase().equals("video")){
			tagHtml.append("<video controls> <source src='");
			tagHtml.append(caminhoComArquivo);
			tagHtml.append("' ></video>");
		}else if(tipoArquivo.toLowerCase().equals("audio")){
			tagHtml.append("<audio controls> <source src='");
			tagHtml.append(caminhoComArquivo);
			tagHtml.append("' ></audio>");
		}else if(tipoArquivo.toLowerCase().equals("texto")){
			tagHtml.append("<a href='");
			tagHtml.append(caminhoComArquivo);
			tagHtml.append("' >");
			tagHtml.append(arquivo.getNome());
			tagHtml.append("</a>");
		}else if(tipoArquivo.toLowerCase().equals("streaming")){
			tagHtml.append("<iframe height=\"315\" src='");
			tagHtml.append(arquivo.getCaminho());
			tagHtml.append("' >");
			tagHtml.append("</iframe> ");
		}
		
		return tagHtml.toString();
	}
	
	private String gerarCaminhoComArquivo(Arquivo arquivo) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(arquivo.getCaminho());
		sb.append(arquivo.getNome());
		sb.append(".");
		sb.append(arquivo.getExtensao().getDescricao());
		
		return sb.toString();
	}

	public List<Conteudo> buscaPorDescricao(String descricao) {
		return conteudoRepo.buscaPorDescricao(descricao);
	}

	public List<Conteudo> buscaPorCategoria(String categoria) {
		return conteudoRepo.buscaPorCategoria(categoria);
	}

	public List<Conteudo> findAll() {
		return conteudoRepo.findAll();
	}

	@Override
	public void darLike(Long id) {
		conteudoRepo.darLike(id);
	}

	@Override
	public void darDislike(Long id) {
		conteudoRepo.darDislike(id);
	}
}
