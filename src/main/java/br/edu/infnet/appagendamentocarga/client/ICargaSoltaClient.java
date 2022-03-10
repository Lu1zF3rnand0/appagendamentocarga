package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;

@FeignClient(url = "localhost:8082/api/carga", name = "cargaSoltaClient")
public interface ICargaSoltaClient {

	@GetMapping(value = "/cargaSolta/listar")
	public List<CargaSolta> obterLista();
}
