package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.CargaSoltaRepository;

@Service
public class CargaSoltaService {
	
	@Autowired
	private CargaSoltaRepository cargaSoltaRepository;

	public List<CargaSolta> obterLista(){

		return cargaSoltaRepository.findAll(Sort.by(Sort.Direction.ASC, "mercadoria"));
	}
	
	public List<CargaSolta> obterLista(Usuario usuario){

		return cargaSoltaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "mercadoria"));
	}

	public void incluir(CargaSolta cargaSolta) {

		cargaSoltaRepository.save(cargaSolta);
	}
	
	public void excluir(Integer id) {

		cargaSoltaRepository.deleteById(id);
	}
	
	public CargaSolta obterPorId(Integer id) {

		return cargaSoltaRepository.findById(id).orElse(null);
	}
	
	public Long obterQtd() {
		return cargaSoltaRepository.count();
	}
}