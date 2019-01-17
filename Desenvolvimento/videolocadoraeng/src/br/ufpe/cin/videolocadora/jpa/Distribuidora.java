package br.ufpe.cin.videolocadora.jpa;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Distribuidora
 *
 */
@Entity
@Table(name="distribuidora")
public class Distribuidora implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long codDistribuidora;
	
	private String cnpj;
	private String responsável;
	private String telefone;
	private String razaoSocial;
	

	public Distribuidora() {
		super();
	}   
	
	public Long getCodDistribuidora() {
		return this.codDistribuidora;
	}

	public void setCodDistribuidora(Long codDistribuidora) {
		this.codDistribuidora = codDistribuidora;
	}   
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}   
	public String getResponsável() {
		return this.responsável;
	}

	public void setResponsável(String responsável) {
		this.responsável = responsável;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}   
	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
   
}
