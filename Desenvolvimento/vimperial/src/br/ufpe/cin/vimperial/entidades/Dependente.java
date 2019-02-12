package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;

import br.ufpe.cin.vimperial.converter.BaseEntity;

public class Dependente implements BaseEntity, Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long codDependente;
	
	private String nome;
	private String tipoDependente;
	private String email;
	
	private Cliente cliente;
	

	public Long getCodDependente() {
		return codDependente;
	}

	public void setCodDependente(Long codDependente) {
		this.codDependente = codDependente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoDependente() {
		return tipoDependente;
	}

	public void setTipoDependente(String tipoDependente) {
		this.tipoDependente = tipoDependente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Long getId() {
		return new Long(codDependente);
	}

	
	
}
