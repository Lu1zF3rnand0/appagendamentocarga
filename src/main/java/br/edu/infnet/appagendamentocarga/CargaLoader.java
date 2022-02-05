 package br.edu.infnet.appagendamentocarga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;
import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;
import br.edu.infnet.appagendamentocarga.service.CargaSoltaService;
import br.edu.infnet.appagendamentocarga.service.ConteinerService;
import br.edu.infnet.appagendamentocarga.service.VeiculoService;

@Component
@Order(3)
public class CargaLoader implements ApplicationRunner {


	@Autowired
	private ConteinerService conteinerService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private CargaSoltaService cargaSoltaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		Conteiner conteiner = new Conteiner("MSC Conteiner", "21/102030-1", "BRRIO");
		conteiner.setNumero("MSCU456789");
		conteiner.setStatus("Cheio");
		conteiner.setTamanho(40);
		conteiner.setUsuario(usuario);
				
		conteinerService.incluir(conteiner);
		
		Veiculo veiculo = new Veiculo("MSC Veiculo", "21/202040-5", "USGLO");
		veiculo.setModelo("2008 SPORT 1.6");
		veiculo.setMontadora("Peugeot");
		veiculo.setChassi("936CM5GYANB541361");
		veiculo.setUsuario(usuario);
				
		veiculoService.incluir(veiculo);
		
		CargaSolta cargaSolta = new CargaSolta("MSC Carga Solta", "21/002233-6", "JPTOT");
		cargaSolta.setImo(false);
		cargaSolta.setOog(true);
		cargaSolta.setMercadoria("Caixas de Madeira");
		cargaSolta.setUsuario(usuario);
				
		cargaSoltaService.incluir(cargaSolta);
				
	
	}
}