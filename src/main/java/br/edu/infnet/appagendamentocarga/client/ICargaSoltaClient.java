package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;

@FeignClient(url = "localhost:8082/api/carga", name = "cargaSoltaClient")
public interface ICargaSoltaClient {

	@GetMapping(value = "/cargaSolta/listar")
	public List<CargaSolta> obterLista();
	
	@GetMapping(value = "/cargaSolta/{id}/listarPorUser")
	public List<CargaSolta> obterPorUser(@PathVariable Integer id);
}
