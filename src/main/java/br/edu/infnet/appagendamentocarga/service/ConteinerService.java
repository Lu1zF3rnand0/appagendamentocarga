package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.ICargaClient;
import br.edu.infnet.appagendamentocarga.client.IConteinerClient;
import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;

@Service
public class ConteinerService {

	@Autowired
	private IConteinerClient conteinerClient;

	@Autowired
	private ICargaClient cargaClient;

	public List<Conteiner> obterLista() {

		return conteinerClient.obterLista();
	}

	public List<Conteiner> obterLista(Usuario usuario) {

		return conteinerClient.obterPorUser(usuario.getId());
	}

	public void incluir(Conteiner conteiner) {

		cargaClient.inserir(conteiner);
	}

	public void excluir(Integer id) {

		cargaClient.excluir(id);
	}

	public Conteiner obterPorId(Integer id) {

		return (Conteiner) cargaClient.obterPorId(id);

	}

	public Long obterQtd() {

		return (long) conteinerClient.obterLista().size();
	}
}