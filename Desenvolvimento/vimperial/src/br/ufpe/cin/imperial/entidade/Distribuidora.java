package br.ufpe.cin.imperial.entidade;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="distribuidora")
public class Distribuidora implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codDistribuidora;
	
	private String  razaoSocial;
	private String responsavel;
	private String telefone;
	
	
	@ManyToOne
	private EndDistribuidora endereco;
	
	
	public Long getCodDistribuidora() {
		return codDistribuidora;
	}
	public void setCodDistribuidora(Long codDistribuidora) {
		this.codDistribuidora = codDistribuidora;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public EndDistribuidora getEndereco() {
		return endereco;
	}
	public void setEndereco(EndDistribuidora endereco) {
		this.endereco = endereco;
	}

}
