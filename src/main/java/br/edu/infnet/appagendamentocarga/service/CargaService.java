package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.model.domain.Carga;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.CargaRepository;

@Service
public class CargaService {
	
	@Autowired
	private CargaRepository cargaRepository;
	
	public List<Carga> obterLista(Usuario usuario){

		return cargaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "documento"));
	}

	public void excluir(Integer id) {

		cargaRepository.deleteById(id);
	}
	
	public Carga obterPorId(Integer id) {

		return cargaRepository.findById(id).orElse(null);
	}

	public Long obterQtd() {
		return cargaRepository.count();
	}
	
}
