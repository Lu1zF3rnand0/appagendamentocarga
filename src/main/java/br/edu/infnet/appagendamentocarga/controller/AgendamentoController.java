package br.edu.infnet.appagendamentocarga.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appagendamentocarga.model.domain.Agendamento;
import br.edu.infnet.appagendamentocarga.model.domain.Carga;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.service.AgendamentoService;
import br.edu.infnet.appagendamentocarga.service.CargaService;
import br.edu.infnet.appagendamentocarga.service.ClienteService;

@Controller
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CargaService cargaService;
	
	@GetMapping(value = "/agendamento")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("clientes",clienteService.obterLista(usuario));
		
		model.addAttribute("cargas",cargaService.obterLista(usuario));

		return "agendamento/cadastro";
	}
	
	@GetMapping(value = "/agendamentos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", agendamentoService.obterLista(usuario));
		
		return "agendamento/lista";
	}

	@PostMapping(value = "/agendamento/incluir")
	public String incluir(Model model, Agendamento agendamento, @RequestParam String[] cargasId, @SessionAttribute("user") Usuario usuario) {
						
		List<Carga> cargas = new ArrayList<Carga>();
		
		for (String id : cargasId) {
			cargas.add(cargaService.obterPorId(Integer.valueOf(id)));
		}
		
		agendamento.setCargas(cargas);
		
		agendamento.setUsuario(usuario);
		
		agendamentoService.incluir(agendamento);
		
		model.addAttribute("mensagem", "O agendamento numero "+agendamento.getId()+" foi cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/agendamento/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Agendamento agendamento = agendamentoService.obterPorId(id);		
		agendamentoService.excluir(id);

		model.addAttribute("mensagem", "O agendament onumero "+agendamento.getId()+" foi removido com sucesso!!!");
		
		return telaLista(model, usuario);
	}
}
