package br.edu.infnet.appagendamentocarga.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Agendamento {
	
	private Integer id;
	
	private LocalDateTime data;
	private String tipo;
	private String transportador;
	private Cliente cliente;
	private List<Carga> cargas;
	private Usuario usuario;
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format("%s, %s, %s, %s, %d",
				this.data.format(formato), this.tipo, this.transportador, this.cliente.getNome(),  this.cargas.size());	
	}
	
	
	public Agendamento() {
		this.data = LocalDateTime.now();
	}
	
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTransportador() {
		return transportador;
	}


	public void setTransportador(String transportador) {
		this.transportador = transportador;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
