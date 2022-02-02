package br.edu.infnet.appagendamentocarga.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;

@Repository
public interface ConteinerRepository extends CrudRepository<Conteiner, Integer> {

	@Query("from Conteiner c where c.usuario.id = :userid")
	List<Conteiner> findAll(Integer userid, Sort by);
	
	List<Conteiner> findAll(Sort by);

}
