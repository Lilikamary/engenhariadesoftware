package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;
import java.util.Date;

import br.ufpe.cin.vimperial.converter.BaseEntity;

public class Locacao implements BaseEntity, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codLocacao;
	private Cliente cliente;
	
	private Date dataLocacao;
	private Date dataDevolucao;
	
	private Long multa;

	
	public Long getCodLocacao() {
		return codLocacao;
	}

	public void setCodLocacao(Long codLocacao) {
		this.codLocacao = codLocacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Long getMulta() {
		return multa;
	}

	public void setMulta(Long multa) {
		this.multa = multa;
	}

	@Override
	public Long getId() {
		return new Long (codLocacao);
	}
	
	
	

}
