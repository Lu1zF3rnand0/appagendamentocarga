package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.ICargaClient;
import br.edu.infnet.appagendamentocarga.client.ICargaSoltaClient;
import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;

@Service
public class CargaSoltaService {

	@Autowired
	private ICargaSoltaClient cargaSoltaClient;
	
	@Autowired
	private ICargaClient cargaClient;

	public List<CargaSolta> obterLista() {

		return cargaSoltaClient.obterLista();

	}

	public List<CargaSolta> obterLista(Usuario usuario) {

		return cargaSoltaClient.obterPorUser(usuario.getId());

	}

	public void incluir(CargaSolta cargaSolta) {

		cargaClient.inserir(cargaSolta);
		//cargaSoltaRepository.save(cargaSolta);
	}

	public void excluir(Integer id) {

		cargaClient.excluir(id);
	}

	public CargaSolta obterPorId(Integer id) {
		
		for (CargaSolta cargaSolta : cargaSoltaClient.obterLista()) {
			if (cargaSolta.getId().equals(id)) {
				return cargaSolta;
			}
		}

		return null;
		
	}

	public Long obterQtd() {
		
		return (long) cargaSoltaClient.obterLista().size();
		//return cargaSoltaRepository.count();
	}
}