package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;



public class Telefone implements Serializable{


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

	
	
}
