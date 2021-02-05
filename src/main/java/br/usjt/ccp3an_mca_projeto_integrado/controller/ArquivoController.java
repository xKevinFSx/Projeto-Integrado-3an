package br.usjt.ccp3an_mca_projeto_integrado.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.usjt.ccp3an_mca_projeto_integrado.model.Arquivo;
import br.usjt.ccp3an_mca_projeto_integrado.service.IArquivoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("arquivo")
public class ArquivoController {

	@Autowired
	IArquivoService arquivoService;
	
	@GetMapping("upload")
    public String upload(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("estagiario") == null && session.getAttribute("administrador") == null) {
			return "redirect:/login";
		} else if (session.getAttribute("usuario") != null) {
			return "redirect:/login";
		}
		return "arquivo/upload";
    }
	
	@PostMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException{

		Arquivo arquivo = arquivoService.guardar(file);
		
		arquivoService.inserir(arquivo);
		
        return "arquivo/upload";
    }
	
	@PostMapping("registrar")
	public String registrar(@RequestParam("nome") String nome, @RequestParam("link") String link) {
		
		Arquivo arquivo = arquivoService.encapsularArquivoStreaming(nome, link);
		
		arquivoService.inserir(arquivo);
		
		return "arquivo/upload";
	}
}
