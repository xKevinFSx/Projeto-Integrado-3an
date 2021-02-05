package br.usjt.ccp3an_mca_projeto_integrado.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.ccp3an_mca_projeto_integrado.model.Conteudo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IConteudoRepository extends JpaRepository<Conteudo, Long>{

    @Query("SELECT c FROM Conteudo c WHERE descricao LIKE %?1%")
    public List<Conteudo> buscaPorDescricao(String frase);

    @Query("SELECT c FROM Conteudo c INNER JOIN c.categoria ca WHERE ca.descricao = ?1")
    public List<Conteudo> buscaPorCategoria(String categoria);

//    @Query("SELECT descricao, data FROM conteudo WHERE data IN (SELECT MAX(data) FROM conteudo)")
//    public Conteudo buscaPorMaisRecente();

    @Modifying
    @Query("UPDATE Conteudo c SET c.feedbackLike = c.feedbackLike + 1 WHERE c.id = ?1")
    public void darLike(Long id);

    @Modifying
    @Query("UPDATE Conteudo c SET c.feedbackDislike = c.feedbackDislike + 1 WHERE c.id = ?1")
    public void darDislike(Long id);
}
