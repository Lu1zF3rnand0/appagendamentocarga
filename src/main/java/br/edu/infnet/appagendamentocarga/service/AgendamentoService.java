package br.edu.infnet.appagendamentocarga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.IAgendamentoClient;
import br.edu.infnet.appagendamentocarga.model.domain.Agendamento;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;

@Service
public class AgendamentoService {

	@Autowired
	private IAgendamentoClient agendamentoClient;

	public List<Agendamento> obterLista() {

		return agendamentoClient.obterLista();
	}

	public List<Agendamento> obterLista(Usuario usuario) {
		
		//return agendamentoClient.obterLista().stream().filter(item ->item.getId().equals(usuario.getId())).collect(Collectors.toList());
		
		List<Agendamento> listaAgendamento = new ArrayList<>();

		for (Agendamento agendamento : agendamentoClient.obterLista()) {
			if (agendamento.getUsuario().getId().equals(usuario.getId())) {
				listaAgendamento.add(agendamento);
			}
		}

		return listaAgendamento;

		// return agendamentoRepository.findAll(usuario.getId(),
		// Sort.by(Sort.Direction.ASC, "data"));
	}

	public void incluir(Agendamento agendamento) {
		
		agendamentoClient.incluir(agendamento);
		//agendamentoRepository.save(agendamento);

	}

	public void excluir(Integer id) {
		
		agendamentoClient.excluir(id);
		//agendamentoRepository.deleteById(id);
	}

	public Agendamento obterPorId(Integer id) {
		
		for (Agendamento agendamento : agendamentoClient.obterLista()) {
			if (agendamento.getId().equals(id)) {
				return agendamento;
			}
		}
		
		return null;
		//return agendamentoRepository.findById(id).orElse(null);
	}

	public Long obterQtd() {
		return (long) agendamentoClient.obterLista().size();
		//return agendamentoRepository.count();
	}
}
