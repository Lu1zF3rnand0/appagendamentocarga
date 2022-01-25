 package br.edu.infnet.appagendamentocarga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.service.ConteinerService;

@Component
@Order(3)
public class ProdutoLoader implements ApplicationRunner {


	@Autowired
	private ConteinerService conteinerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Conteiner conteiner = new Conteiner("MSC TESTE", "333333", "BRRIO");
		conteiner.setNumero("MSCU456789");
		conteiner.setStatus("Cheio");
		conteiner.setTamanho(40);
				
		conteinerService.incluir(conteiner);
		
		Conteiner conteiner2 = new Conteiner("MSC FOI", "444444", "USRIO");
		conteiner2.setNumero("HPLU123456");
		conteiner2.setStatus("Vazio");
		conteiner2.setTamanho(40);
				
		conteinerService.incluir(conteiner2);
		
		
		for (Conteiner c : conteinerService.obterLista()) {
			System.out.println(c.getId() + " Conteiner " + c.getNumero());
			
		}
		
		conteinerService.excluir(1);
		
		for (Conteiner c : conteinerService.obterLista()) {
			System.out.println(c.getId() + " Conteiner " + c.getNumero());
			
		}
		
		Conteiner c3 = conteinerService.obterPorId(2);
		System.out.println(c3.getId() + " Conteiner " + c3.getNumero());
	
	}
}