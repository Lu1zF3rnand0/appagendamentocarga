package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.ICargaClient;
import br.edu.infnet.appagendamentocarga.model.domain.Carga;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;

@Service
public class CargaService {

	@Autowired
	private ICargaClient cargaClient;

	public List<Carga> obterLista(Usuario usuario) {

		return cargaClient.obterPorUser(usuario.getId());
	}

	public void excluir(Integer id) {

		cargaClient.excluir(id);
	}

	public Carga obterPorId(Integer id) {

		return cargaClient.obterPorId(id);
	}

	public Long obterQtd() {
		return (long) cargaClient.obterLista().size();
	}

}
