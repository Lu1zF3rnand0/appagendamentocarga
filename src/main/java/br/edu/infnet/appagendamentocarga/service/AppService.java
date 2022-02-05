package br.edu.infnet.appagendamentocarga.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CargaService cargaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ConteinerService conteinerService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private CargaSoltaService cargaSoltaService;
	
	@Autowired
	private AgendamentoService agendamentoService;

	@SuppressWarnings("rawtypes")
	public Map qtds () {
		
		Map<String, Long> mapa = new HashMap<>();
		mapa.put("Usuários", usuarioService.obterQtd());
		mapa.put("Clientes", clienteService.obterQtd());
		mapa.put("Cargas", cargaService.obterQtd());
		mapa.put("Conteineres", conteinerService.obterQtd());
		mapa.put("Veiculos", veiculoService.obterQtd());
		mapa.put("CargasSolta", cargaSoltaService.obterQtd());
		mapa.put("Agendamentos",agendamentoService.obterQtd());

		return mapa;
		
	}
	
	
}
