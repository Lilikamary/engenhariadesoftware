package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;

import br.ufpe.cin.vimperial.converter.BaseEntity;

public class TipoMidia implements BaseEntity, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codMidia;
	private String tipoMidia;
	
	public Long getCodMidia() {
		return codMidia;
	}
	public void setCodMidia(Long codMidia) {
		this.codMidia = codMidia;
	}
	public String getTipoMidia() {
		return tipoMidia;
	}
	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	@Override
	public Long getId() {
		return new Long(codMidia);
	}
	
	

}
