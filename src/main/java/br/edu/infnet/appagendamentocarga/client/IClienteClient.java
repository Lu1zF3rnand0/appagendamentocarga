package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appagendamentocarga.model.domain.Cliente;

@FeignClient(url = "localhost:8083/api/cliente", name = "clienteClient")
public interface IClienteClient {

	@GetMapping(value = "/listar")
	public List<Cliente> obterLista();
	
	@GetMapping(value = "/{id}/listarPorUser")
	public List<Cliente> obterListaPorUser(@PathVariable Integer id);
	
	@PostMapping(value = "/incluir")
	public void incluir(Cliente cliente);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	

}