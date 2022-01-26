package br.edu.infnet.appagendamentocarga.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.edu.infnet.appagendamentocarga.exceptions.PortoInvalidoException;

@Entity
@Table(name = "TCarga")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Carga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String navio;
	private String documento;
	private String porto;

	protected static int cont = 0;

	public Carga(String navio, String documento, String porto) throws PortoInvalidoException {
		this.navio = navio;
		this.documento = documento;
		this.porto = porto;

		if (porto.length() != 5) {
			throw new PortoInvalidoException("Código do porto inválido!");
		}
	}

	public Carga() {
		this.id = cont++;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(";");
		sb.append(this.navio);
		sb.append(";");
		sb.append(this.documento);
		sb.append(";");
		sb.append(this.porto);
		return sb.toString();
	}

	public abstract String retornaNavio();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNavio() {
		return navio;
	}

	public void setNavio(String navio) {
		this.navio = navio;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPorto() {
		return porto;
	}

	public void setPorto(String porto) {
		this.porto = porto;
	}

	

}
