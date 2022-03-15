package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;

@FeignClient(url = "localhost:8082/api/carga", name = "veiculoClient")
public interface IVeiculoClient {

	@GetMapping(value = "/veiculo/listar")
	public List<Veiculo> obterLista();
	
	@GetMapping(value = "/veiculo/{id}/listarPorUser")
	public List<Veiculo> obterPorUser(@PathVariable Integer id); 
}
