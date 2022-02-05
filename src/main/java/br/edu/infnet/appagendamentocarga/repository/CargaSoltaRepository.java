package br.edu.infnet.appagendamentocarga.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;

@Repository
public interface CargaSoltaRepository extends CrudRepository<CargaSolta, Integer> {

	@Query("from CargaSolta c where c.usuario.id = :userid")
	List<CargaSolta> findAll(Integer userid, Sort by);
	
	List<CargaSolta> findAll(Sort by);

}
