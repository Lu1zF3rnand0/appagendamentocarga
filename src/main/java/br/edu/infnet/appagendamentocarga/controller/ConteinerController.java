package br.edu.infnet.appagendamentocarga.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.service.ConteinerService;

@Controller
public class ConteinerController {

	List<Conteiner> conteineres = new ArrayList<Conteiner>();

	@Autowired
	private ConteinerService conteinerService;

	@GetMapping(value = "/conteiner")
	public String telaCadatro() {

		return "conteiner/cadastro";
	}

	@GetMapping(value = "/conteineres")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", conteinerService.obterLista(usuario));
		return "conteiner/lista";
	}

	@PostMapping(value = "/conteiner/incluir")
	public String incluir(Model model, Conteiner conteiner, @SessionAttribute("user") Usuario usuario) {

		conteiner.setUsuario(usuario);

		conteinerService.incluir(conteiner);
		model.addAttribute("mensagem", "O conteiner " + conteiner.getNumero() + " foi cadastrado com sucesso!!!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/conteiner/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Conteiner conteiner = conteinerService.obterPorId(id);

		try {
			conteinerService.excluir(id);
			model.addAttribute("mensagem", "O conteiner " + conteiner.getNumero() + " foi removido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossivel remover o conteiner " + conteiner.getNumero() + ", ele está associado à algum agendamento!!!");
		}

		return telaLista(model, usuario);
	}
}
