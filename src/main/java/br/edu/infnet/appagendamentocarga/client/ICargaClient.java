package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appagendamentocarga.model.domain.Carga;

@FeignClient(url = "localhost:8082/api/carga", name = "cargaClient")
public interface ICargaClient {

	@GetMapping(value = "/listar")
	public List<Carga> obterLista();
	
	@PostMapping(value = "/incluir")
	public void inserir(Carga carga);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
}
