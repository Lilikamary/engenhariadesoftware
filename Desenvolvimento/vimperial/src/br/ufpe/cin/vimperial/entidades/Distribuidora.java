package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;

import br.ufpe.cin.vimperial.converter.BaseEntity;

public class Distribuidora implements BaseEntity, Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long codDistribuidora;
	
	private String razaoSocial;
	private String responsavel;
	private Telefone telefone;
	
	private Endereco endereco;

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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public Long getId() {
		return new Long(codDistribuidora);
	}

}
