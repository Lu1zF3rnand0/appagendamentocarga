package br.edu.infnet.appagendamentocarga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;

@Repository
public interface ConteinerRepository extends CrudRepository<Conteiner, Integer> {

}
