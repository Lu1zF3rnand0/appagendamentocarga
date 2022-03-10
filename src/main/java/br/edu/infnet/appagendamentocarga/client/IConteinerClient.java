package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;

@FeignClient(url = "localhost:8082/api/carga", name = "conteinerClient")
public interface IConteinerClient {

	@GetMapping(value = "/conteiner/listar")
	public List<Conteiner> obterLista();
	
	@GetMapping(value = "/conteiner/{id}/listar")
	public List<Conteiner> obterLista(@PathVariable Integer id);
		
}
