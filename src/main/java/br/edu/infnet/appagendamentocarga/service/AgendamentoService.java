package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.model.domain.Agendamento;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public List<Agendamento> obterLista(){
		
		return (List<Agendamento>) agendamentoRepository.findAll(Sort.by(Sort.Direction.ASC, "transportador"));
	}
	
	public List<Agendamento> obterLista(Usuario usuario){
		
		return (List<Agendamento>) agendamentoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public void incluir(Agendamento agendamento) {
		agendamentoRepository.save(agendamento);
		
	}
	
	public void excluir(Integer id) {
		agendamentoRepository.deleteById(id);
	}
	
	public Agendamento obterPorId(Integer id) {
		return agendamentoRepository.findById(id).orElse(null);
	}
}

