package br.edu.infnet.appagendamentocarga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.ICargaClient;
import br.edu.infnet.appagendamentocarga.client.IConteinerClient;
import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.ConteinerRepository;

@Service
public class ConteinerService {

	@Autowired
	private ConteinerRepository conteinerRepository;

	@Autowired
	private IConteinerClient conteinerClient;
	
	@Autowired
	private ICargaClient cargaClient;

	public List<Conteiner> obterLista() {

		return conteinerClient.obterLista();
		//return conteinerRepository.findAll(Sort.by(Sort.Direction.ASC, "numero"));
	}

	public List<Conteiner> obterLista(Usuario usuario) {

		List<Conteiner> listaConteiner = new ArrayList<>();

		for (Conteiner conteiner : conteinerClient.obterLista()) {
			if (conteiner.getUsuario().getId().equals(usuario.getId())) {
				listaConteiner.add(conteiner);
			}
		}
		return listaConteiner;

		// return conteinerClient.obterLista(usuario.getId());
		// return conteinerRepository.findAll(usuario.getId(),
		// Sort.by(Sort.Direction.ASC, "numero"));
	}

	public void incluir(Conteiner conteiner) {

		cargaClient.inserir(conteiner);
		//conteinerRepository.save(conteiner);
	}

	public void excluir(Integer id) {

		cargaClient.excluir(id);
		//conteinerRepository.deleteById(id);
	}

	public Conteiner obterPorId(Integer id) {

		for (Conteiner conteiner : conteinerClient.obterLista()) {
			if (conteiner.getId().equals(id)) {
				return conteiner;
			}
		}
		
		return null;
		//return conteinerRepository.findById(id).orElse(null);
	}

	public Long obterQtd() {
		
		return (long) conteinerClient.obterLista().size();
		//return conteinerRepository.count();
	}
}