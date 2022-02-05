package br.edu.infnet.appagendamentocarga;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appagendamentocarga.model.domain.Agendamento;
import br.edu.infnet.appagendamentocarga.model.domain.Carga;
import br.edu.infnet.appagendamentocarga.model.domain.CargaSolta;
import br.edu.infnet.appagendamentocarga.model.domain.Cliente;
import br.edu.infnet.appagendamentocarga.model.domain.Conteiner;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.model.domain.Veiculo;
import br.edu.infnet.appagendamentocarga.service.AgendamentoService;

@Component
@Order(4)
public class AgendamentoLoader implements ApplicationRunner {

	@Autowired
	private AgendamentoService agendamentoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		
		Conteiner conteiner = new Conteiner();
		conteiner.setId(1);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(2);
		
		CargaSolta cargaSolta = new CargaSolta();
		cargaSolta.setId(3);
		
		List<Carga> cargas = new ArrayList<Carga>();
		cargas.add(conteiner);
		cargas.add(veiculo);
		cargas.add(cargaSolta);
		
		
		Agendamento agendamento = new Agendamento();
		agendamento.setTipo("Exportação");
		agendamento.setTransportador("Tranziran");
		agendamento.setUsuario(usuario);
		agendamento.setCargas(cargas);
		agendamento.setCliente(cliente);
		
		agendamentoService.incluir(agendamento);
		
		
		
		
//		private String tipo;
//		private String transportador;
//		
//		@OneToOne(cascade = CascadeType.DETACH) 
//		@JoinColumn(name = "idCliente")
//		private Cliente cliente;
//		
//		@ManyToMany(cascade = CascadeType.DETACH)
//		private List<Carga> cargas;
//		
//		@ManyToOne
//		@JoinColumn(name = "idUsuario")
//		private Usuario usuario;
//		
	}
}