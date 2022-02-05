package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.ConteinerRepository;

@Service
public class ConteinerService {
	
	@Autowired
	private ConteinerRepository conteinerRepository;

	public List<Conteiner> obterLista(){

		return conteinerRepository.findAll(Sort.by(Sort.Direction.ASC, "numero"));
	}
	
	public List<Conteiner> obterLista(Usuario usuario){

		return conteinerRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "numero"));
	}

	public void incluir(Conteiner conteiner) {

		conteinerRepository.save(conteiner);
	}
	
	public void excluir(Integer id) {

		conteinerRepository.deleteById(id);
	}
	
	public Conteiner obterPorId(Integer id) {

		return conteinerRepository.findById(id).orElse(null);
	}
	
	public Long obterQtd() {
		return conteinerRepository.count();
	}
}