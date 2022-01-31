package br.edu.infnet.appagendamentocarga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appagendamentocarga.service.EnderecoService;

@Controller
public class EnderecoControler {

	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping(value = "/cep")
	public String bucarCep(Model model, @RequestParam String cep) {
		
		model.addAttribute("endereco", enderecoService.obterPorCep(cep));
		
		return "usuario/cadastro";
	}
	
}
