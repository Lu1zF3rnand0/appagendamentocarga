package br.edu.infnet.appagendamentocarga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appagendamentocarga.model.domain.Carga;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.service.CargaService;

@Controller
public class CargaController {

	@Autowired
	private CargaService cargaService;

	@GetMapping(value = "/cargas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", cargaService.obterLista(usuario));
		return "carga/lista";
	}

	@GetMapping(value = "/carga/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Carga carga = cargaService.obterPorId(id);

		System.out.println(carga.getId());
		try {
			cargaService.excluir(id);
			model.addAttribute("mensagem", "A carga " + carga.getDocumento() + " foi removido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossivel remover o carga " + carga.getDocumento() + ", ela está associada à algum agendamento!!!");
		}

		return telaLista(model, usuario);
	}
}
