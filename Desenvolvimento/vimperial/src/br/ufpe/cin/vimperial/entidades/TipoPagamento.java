package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;

import br.ufpe.cin.vimperial.converter.BaseEntity;

public class TipoPagamento implements BaseEntity, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codTipoPagamento;
	private String tipoPagamento;
	
	public Long getCodTipoPagamento() {
		return codTipoPagamento;
	}
	public void setCodTipoPagamento(Long codTipoPagamento) {
		this.codTipoPagamento = codTipoPagamento;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	@Override
	public Long getId() {
		return new Long(codTipoPagamento);
	}
	
	

}
