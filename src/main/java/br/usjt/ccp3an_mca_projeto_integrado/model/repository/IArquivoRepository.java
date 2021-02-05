package br.usjt.ccp3an_mca_projeto_integrado.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.usjt.ccp3an_mca_projeto_integrado.model.Arquivo;

public interface IArquivoRepository extends JpaRepository<Arquivo, Long>{

	@Query("SELECT a FROM Arquivo a JOIN a.extensao e JOIN e.tipoDeArquivo t WHERE t.id = :tipoDeArquivoID")
	public List<Arquivo> carregarArquivosPorTipoDeArquivo(@Param ("tipoDeArquivoID") Long tipoDeArquivoID);
	
	public Optional<Arquivo> findById(Long id);
}
