package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.ICargaClient;
import br.edu.infnet.appagendamentocarga.client.IVeiculoClient;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;

@Service
public class VeiculoService {

	@Autowired
	private IVeiculoClient veiculoClient;

	@Autowired
	private ICargaClient cargaClient;

	public List<Veiculo> obterLista() {

		return veiculoClient.obterLista();
	}

	public List<Veiculo> obterLista(Usuario usuario) {

		return veiculoClient.obterPorUser(usuario.getId());

	}

	public void incluir(Veiculo veiculo) {

		cargaClient.inserir(veiculo);
		
	}

	public void excluir(Integer id) {

		cargaClient.excluir(id);
	}

	public Veiculo obterPorId(Integer id) {
		
		return (Veiculo) cargaClient.obterPorId(id);
		
	}

	public Long obterQtd() {
		
		return (long) veiculoClient.obterLista().size();
	}
}