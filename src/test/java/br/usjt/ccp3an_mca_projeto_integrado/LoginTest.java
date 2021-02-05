package br.usjt.ccp3an_mca_projeto_integrado;

import br.usjt.ccp3an_mca_projeto_integrado.model.Usuario;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void findByLoginAndSenhaQuery() {
//        Usuario admin = usuarioRepository.findByLoginQuery("admin");
//        Usuario estagiario = usuarioRepository.findByLoginQuery("estagiario");
//        System.out.println(admin.getPermissao() + "  " + estagiario.getPermissao());
    }
}
