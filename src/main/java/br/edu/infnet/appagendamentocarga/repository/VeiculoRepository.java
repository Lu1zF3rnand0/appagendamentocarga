package br.edu.infnet.appagendamentocarga.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {

	@Query("from Veiculo v where v.usuario.id = :userid")
	List<Veiculo> findAll(Integer userid, Sort by);
	
	List<Veiculo> findAll(Sort by);

}
