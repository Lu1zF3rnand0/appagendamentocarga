package br.edu.infnet.appagendamentocarga.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appagendamentocarga.model.domain.Agendamento;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Integer> {

	@Query("from Agendamento a where a.usuario.id = :userid")
	List<Agendamento> findAll(Integer userid, Sort by);
	
	List<Agendamento> findAll(Sort by);

	
}
