 package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.IClienteClient;
import br.edu.infnet.appagendamentocarga.model.domain.Cliente;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private IClienteClient clienteClient;

	public List<Cliente> obterLista(){

		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public List<Cliente> obterLista(Usuario usuario){

		return clienteClient.obterListaPorUser(usuario.getId());	
		//return clienteRepository.findAll(id);
	}

	public void incluir(Cliente cliente) {

		clienteClient.incluir(cliente);
		//clienteRepository.save(cliente);
	}
	
	public void excluir(Integer id) {

		clienteClient.excluir(id);
		//clienteRepository.deleteById(id);
	}
	
	public Cliente obterPorId(Integer id) {

		for (Cliente cliente : clienteClient.obterLista()) {
			if (cliente.getId().equals(id)) {
				return cliente;
			}
		}
		
		return null;
		//return clienteRepository.findById(id).orElse(null);
	}
	
	public Long obterQtd() {
		return (long) clienteClient.obterLista().size();
	}
}