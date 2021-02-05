package br.usjt.ccp3an_mca_projeto_integrado.model.repository;

import br.usjt.ccp3an_mca_projeto_integrado.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findOneByLoginAndSenha (String login, String senha);

    @Query(value = "SELECT u FROM Usuario u WHERE u.login = ?1")
    Usuario findByLoginQuery(String login);

    boolean existsByLogin(String login);
}