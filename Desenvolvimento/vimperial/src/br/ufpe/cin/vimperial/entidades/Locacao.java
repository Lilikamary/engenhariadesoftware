package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;
import java.util.Calendar;
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
		this.dataLocacao = new Date();
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(int dias) {
		this.dataDevolucao = somarData(dias, dataLocacao);
	}

	public void setDataDevolucaoBanco(Date dataDevolucao) {
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
	
	 public static Date somarData (int dias,Date data) {
	       Calendar calendar = Calendar.getInstance();
	       calendar.setTime(data);
	       calendar.add(Calendar.DATE, dias);
	       return calendar.getTime();
	    }
	

}
