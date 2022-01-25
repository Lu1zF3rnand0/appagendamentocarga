package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.repository.ConteinerRepository;

@Service
public class ConteinerService {
	
	@Autowired
	private ConteinerRepository conteinerRepository;

	public List<Conteiner> obterLista(){

		return (List<Conteiner>) conteinerRepository.findAll();
	}
	
//	public List<Conteiner> obterLista(Carga carga){
//
//		return (List<Conteiner>) conteinerRepository.findAll(carga.getId());
//	}

	public void incluir(Conteiner conteiner) {

		conteinerRepository.save(conteiner);
	}
	
	public void excluir(Integer id) {

		conteinerRepository.deleteById(id);
	}
	
	public Conteiner obterPorId(Integer id) {

		return conteinerRepository.findById(id).orElse(null);
	}
}