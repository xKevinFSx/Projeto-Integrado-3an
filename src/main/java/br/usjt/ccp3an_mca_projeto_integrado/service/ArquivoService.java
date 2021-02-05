package br.usjt.ccp3an_mca_projeto_integrado.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.ccp3an_mca_projeto_integrado.model.Arquivo;
import br.usjt.ccp3an_mca_projeto_integrado.model.TipoDeArquivo;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.IArquivoRepository;

@Service
public class ArquivoService implements IArquivoService{

	@Autowired
	IArquivoRepository arquivoRepo;
	
	@Autowired
	IExtensaoArquivoService extensaoArquivoService;
	
	@Autowired
	ITipoDeArquivoService tipoDeArquivoService;
	
	public Arquivo guardar(MultipartFile multipartFile) throws IllegalStateException, IOException {
		
		String nomeOriginal = multipartFile.getOriginalFilename();
		String caminhoArquivo = "/home/ghostavo/workspace/projeto_integrado/projeto/src/main/resources/static/fileServer/";
		
		multipartFile.transferTo(new File(caminhoArquivo+nomeOriginal));
		
		String extensao = extrairExtensao(nomeOriginal);
		
		Arquivo arquivo = new Arquivo();
		arquivo.setCaminho("/fileServer/");
		arquivo.setExtensao(extensaoArquivoService.carregarPorDescricao(extensao));
		arquivo.setNome(extrairNome(nomeOriginal, extensao));
		
		return arquivo;
	}
	
	public File pegar(Arquivo arquivo){
		
		if(arquivo.getCaminho() == null || arquivo.getCaminho() == null)
			arquivo = carregarArquivoId(arquivo.getId());
		
		File file =  new File(montarCaminhoArquivo(arquivo));
		
		return file;
	}
	
	public void inserir(Arquivo arquivo) {
		arquivoRepo.save(arquivo);
	}
	
	public Map<TipoDeArquivo, List<Arquivo>> carregarArquivosPorTipoDeArquivo(){
		Map<TipoDeArquivo, List<Arquivo>> arquivosPorTipoDeArquivo = new HashMap<TipoDeArquivo,List<Arquivo>>();
		List<TipoDeArquivo> listaTipoDeArquivo = tipoDeArquivoService.carregarTodos();
		
		for(TipoDeArquivo item:listaTipoDeArquivo) {
			arquivosPorTipoDeArquivo.put(item, arquivoRepo.carregarArquivosPorTipoDeArquivo(item.getId()));
		}
		
		return arquivosPorTipoDeArquivo;
	}
	
	private String extrairExtensao(String nomeOriginal) {
		
		String extensao = ""; 
		Boolean capturar = false;
		
		for(char l : nomeOriginal.toCharArray()){
			
			if(capturar) {
				extensao += l;
			}
			
			if(l == '.'){
				extensao = "";
				capturar = true;
			}
		}
		
		return extensao;
	}
	
	private String extrairNome(String nomeOriginal, String extensao) {
		return nomeOriginal.replace("."+extensao, "");
	}

	public Arquivo carregarArquivoId(Long id) {
		
		return arquivoRepo.findById(id).get();
	}

	public Arquivo encapsularArquivoStreaming(String nome, String link) {
		Arquivo arquivo = new Arquivo();
		arquivo.setNome(nome);
		arquivo.setCaminho(link);
		arquivo.setExtensao(extensaoArquivoService.carregarPorDescricao("Streaming"));
		
		return arquivo;
	}
	
	private String montarCaminhoArquivo(Arquivo arquivo) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(arquivo.getCaminho());
		sb.append(arquivo.getNome());
		sb.append(".");
		sb.append(arquivo.getExtensao().getDescricao());
		
		return sb.toString();
	}
}
