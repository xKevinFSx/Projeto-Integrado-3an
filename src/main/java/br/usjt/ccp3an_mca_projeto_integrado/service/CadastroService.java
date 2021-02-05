package br.usjt.ccp3an_mca_projeto_integrado.service;

import br.usjt.ccp3an_mca_projeto_integrado.model.Usuario;
import br.usjt.ccp3an_mca_projeto_integrado.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    private final UsuarioRepository usuarioRepo;

    public CadastroService (UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public void salvar(Usuario usuario) {
        usuario.setSenha(usuario.getSenha());
        usuario.setLogin(usuario.getLogin());
        usuarioRepo.save(usuario);
    }

    public boolean verificaLogin(Usuario usuario) {
        return usuarioRepo.existsByLogin(usuario.getLogin());
    }
}
