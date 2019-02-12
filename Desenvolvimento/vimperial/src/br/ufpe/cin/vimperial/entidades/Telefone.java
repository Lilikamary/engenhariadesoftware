package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;

import br.ufpe.cin.vimperial.converter.BaseEntity;

public class Telefone implements BaseEntity, Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long codTelefone;
	
	private String telefone;
	
	
	public Long getCodTelefone() {
		return codTelefone;
	}

	public void setCodTelefone(Long codTelefone) {
		this.codTelefone = codTelefone;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public Long getId() {
		return new Long(codTelefone);
	}
	
	
	
}
