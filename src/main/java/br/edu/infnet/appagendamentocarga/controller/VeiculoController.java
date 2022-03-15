package br.edu.infnet.appagendamentocarga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;
import br.edu.infnet.appagendamentocarga.service.CargaService;
import br.edu.infnet.appagendamentocarga.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private CargaService cargaService;

	@GetMapping(value = "/veiculo")
	public String telaCadatro() {

		return "veiculo/cadastro";
	}

	@GetMapping(value = "/veiculos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", veiculoService.obterLista(usuario));
		return "veiculo/lista";
	}

	@PostMapping(value = "/veiculo/incluir")
	public String incluir(Model model, Veiculo veiculo, @SessionAttribute("user") Usuario usuario) {

		veiculo.setUsuario(usuario);

		veiculoService.incluir(veiculo);
		model.addAttribute("mensagem", "O veiculo " + veiculo.getChassi() + " foi cadastrado com sucesso!!!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/veiculo/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Veiculo veiculo = veiculoService.obterPorId(id);

		try {
			veiculoService.excluir(id);
			model.addAttribute("mensagem", "O veiculo " + veiculo.getChassi() + " foi removido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Impossivel remover o veiculo " + veiculo.getChassi() + ", ele está associado à algum agendamento!!!");
		}

		return telaLista(model, usuario);
	}
}
