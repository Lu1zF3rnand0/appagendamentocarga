package br.edu.infnet.appagendamentocarga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.ICargaClient;
import br.edu.infnet.appagendamentocarga.client.ICargaSoltaClient;
import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.CargaSoltaRepository;

@Service
public class CargaSoltaService {

	@Autowired
	private CargaSoltaRepository cargaSoltaRepository;

	@Autowired
	private ICargaSoltaClient cargaSoltaClient;
	
	@Autowired
	private ICargaClient cargaClient;

	public List<CargaSolta> obterLista() {

		return cargaSoltaClient.obterLista();
		//return cargaSoltaRepository.findAll(Sort.by(Sort.Direction.ASC, "mercadoria"));
	}

	public List<CargaSolta> obterLista(Usuario usuario) {

		List<CargaSolta> listaCargasSolta = new ArrayList<>();

		for (CargaSolta cargaSolta : cargaSoltaClient.obterLista()) {
			if (cargaSolta.getUsuario().getId().equals(usuario.getId())) {
				listaCargasSolta.add(cargaSolta);
			}
		}

		return listaCargasSolta;

		// return cargaSoltaRepository.findAll(usuario.getId(),
		// Sort.by(Sort.Direction.ASC, "mercadoria"));
	}

	public void incluir(CargaSolta cargaSolta) {

		cargaClient.inserir(cargaSolta);
		//cargaSoltaRepository.save(cargaSolta);
	}

	public void excluir(Integer id) {

		cargaClient.excluir(id);
		//cargaSoltaRepository.deleteById(id);
	}

	public CargaSolta obterPorId(Integer id) {
		
		for (CargaSolta cargaSolta : cargaSoltaClient.obterLista()) {
			if (cargaSolta.getId().equals(id)) {
				return cargaSolta;
			}
		}

		return null;
		//return cargaSoltaRepository.findById(id).orElse(null);
	}

	public Long obterQtd() {
		
		return (long) cargaSoltaClient.obterLista().size();
		//return cargaSoltaRepository.count();
	}
}