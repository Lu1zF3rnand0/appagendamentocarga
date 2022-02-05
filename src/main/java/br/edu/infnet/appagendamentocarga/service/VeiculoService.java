package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;
import br.edu.infnet.appagendamentocarga.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Veiculo> obterLista(){

		return (List<Veiculo>) veiculoRepository.findAll(Sort.by(Sort.Direction.ASC, "chassi"));
	}
	
	public List<Veiculo> obterLista(Usuario usuario){

		return (List<Veiculo>) veiculoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "chassi"));
	}

	public void incluir(Veiculo veiculo) {

		veiculoRepository.save(veiculo);
	}
	
	public void excluir(Integer id) {

		veiculoRepository.deleteById(id);
	}
	
	public Veiculo obterPorId(Integer id) {

		return veiculoRepository.findById(id).orElse(null);
	}
	
	public Long obterQtd() {
		return veiculoRepository.count();
	}
}