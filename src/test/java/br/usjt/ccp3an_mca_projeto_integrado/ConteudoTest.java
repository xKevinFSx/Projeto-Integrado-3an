package br.usjt.ccp3an_mca_projeto_integrado;

import br.usjt.ccp3an_mca_projeto_integrado.model.Conteudo;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.IConteudoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConteudoTest {

    @Autowired
    public IConteudoRepository conteudoRepo;

    // teste para buscar conteúdo que tenha palabra ou frase expecífica
    @Test
    public void buscaPorDescricao() {
        List<Conteudo> conteudos = conteudoRepo.buscaPorDescricao("teste 1");
        for (Conteudo conteudo : conteudos) {
            System.out.println("Data: [" + conteudo.getData() + "]");
            System.out.println("Descriao: [" + conteudo.getDescricao() + "]\n");
        }
    }

    // teste listar por categoria
    @Test
    public void buscaPorCategoria() {
        List<Conteudo> conteudos = conteudoRepo.buscaPorCategoria("esportes");
        for (Conteudo conteudo : conteudos) {
            System.out.println("ID: [" + conteudo.getId() + "]");
            System.out.println("Data: [" + conteudo.getData() + "]");
            System.out.println("Descriao: [" + conteudo.getDescricao() + "]");
            System.out.println("Titulo: [" + conteudo.getTitulo() + "]");
            System.out.println("HTML: [" + conteudo.getHtml() + "]\n");
        }
    }
}