package br.edu.infnet.appagendamentocarga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.ICargaClient;
import br.edu.infnet.appagendamentocarga.client.IVeiculoClient;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;
import br.edu.infnet.appagendamentocarga.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private IVeiculoClient veiculoClient;

	@Autowired
	private ICargaClient cargaClient;

	public List<Veiculo> obterLista() {

		return veiculoClient.obterLista();
		// return veiculoRepository.findAll(Sort.by(Sort.Direction.ASC, "chassi"));
	}

	public List<Veiculo> obterLista(Usuario usuario) {

		List<Veiculo> listaVeiculos = new ArrayList<>();

		for (Veiculo veiculo : veiculoClient.obterLista()) {
			if (veiculo.getUsuario().getId().equals(usuario.getId())) {
				listaVeiculos.add(veiculo);
			}
		}

		return listaVeiculos;

		// return (List<Veiculo>) veiculoRepository.findAll(usuario.getId(),
		// Sort.by(Sort.Direction.ASC, "chassi"));
	}

	public void incluir(Veiculo veiculo) {

		cargaClient.inserir(veiculo);
		// veiculoRepository.save(veiculo);
	}

	public void excluir(Integer id) {

		cargaClient.excluir(id);
		// veiculoRepository.deleteById(id);
	}

	public Veiculo obterPorId(Integer id) {
		
		for (Veiculo veiculo : veiculoClient.obterLista()) {
			if (veiculo.getId().equals(id)) {
				return veiculo;
			}
		}

		return null;
		//return veiculoRepository.findById(id).orElse(null);
	}

	public Long obterQtd() {
		
		return (long) veiculoClient.obterLista().size();
		//return veiculoRepository.count();
	}
}