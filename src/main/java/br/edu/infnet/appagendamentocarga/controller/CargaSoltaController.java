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

import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.service.CargaSoltaService;

@Controller
public class CargaSoltaController {

	List<CargaSolta> cargas = new ArrayList<CargaSolta>();
			
	@Autowired
	private CargaSoltaService cargaSoltaService;

	@GetMapping(value = "/cargaSolta")
	public String telaCadatro() {

		return "cargaSolta/cadastro";
	}

	@GetMapping(value = "/cargasSolta")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		
		model.addAttribute("lista", cargaSoltaService.obterLista(usuario));
		return "cargaSolta/lista";
	}

	@PostMapping(value = "/cargaSolta/incluir")
	public String incluir(Model model, CargaSolta cargaSolta, @SessionAttribute("user") Usuario usuario) {

		cargaSolta.setUsuario(usuario);

		cargaSoltaService.incluir(cargaSolta);
		model.addAttribute("mensagem", "A carga " + cargaSolta.getMercadoria() + " foi cadastrado com sucesso!!!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/cargaSolta/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		CargaSolta cargaSolta = cargaSoltaService.obterPorId(id);

		try {
			cargaSoltaService.excluir(id);
			model.addAttribute("mensagem", "A carga " + cargaSolta.getMercadoria() + " foi removida com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Impossivel remover a carga " + cargaSolta.getMercadoria() + ", ela está associado à algum agendamento!!!");
		}

		return telaLista(model, usuario);
	}
}
