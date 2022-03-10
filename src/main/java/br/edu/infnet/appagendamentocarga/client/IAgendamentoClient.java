package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appagendamentocarga.model.domain.Agendamento;

@FeignClient(url = "localhost:8081/api/agendamento", name = "agendamentoClient")
public interface IAgendamentoClient {
	
	@GetMapping(value = "/listar")
	public List<Agendamento> obterLista();
	
	@PostMapping(value = "/incluir")
	public void incluir (Agendamento agendamento);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
}
