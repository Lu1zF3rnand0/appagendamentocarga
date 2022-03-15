package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.IClienteClient;
import br.edu.infnet.appagendamentocarga.model.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private IClienteClient clienteClient;


	public List<Cliente> obterLista() {

		return clienteClient.obterLista();
	}
	
	public Cliente obterListaPorId(Integer id) {

		return clienteClient.obterListaPorid(id);
	}
	
	public List<Cliente> obterListaPorUser(Integer id) {

		return clienteClient.obterListaPorUser(id);
	}

	public void incluir(Cliente cliente) {

		clienteClient.incluir(cliente);
	}

	public void excluir(Integer id) {

		clienteClient.excluir(id);
	}

	public Long obterQtd() {
		return (long) clienteClient.obterLista().size();
	}
}