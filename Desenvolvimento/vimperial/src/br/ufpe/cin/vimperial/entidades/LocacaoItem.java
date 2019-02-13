package br.ufpe.cin.vimperial.entidades;

import java.util.Calendar;
import java.util.Date;

public class LocacaoItem {
	
	private Long codLocacaoItem;
	private Locacao locacao;
	private Filme filme;
	private float valorLocacao;
	private float valorMulta;
	private float valorTotal;
	private Date dataLocacaoItem;
	private Date dataDevolucaoItem;
	
	
	
	public Long getCodLocacaoItem() {
		return codLocacaoItem;
	}
	public void setCodLocacaoItem(Long codLocacaoItem) {
		this.codLocacaoItem = codLocacaoItem;
	}
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public float getValorLocacao() {
		return valorLocacao;
	}
	public void setValorLocacao(float valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	public float getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(float valorMulta) {
		this.valorMulta = valorMulta;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataLocacaoItem() {
		return dataLocacaoItem;
	}
	public void setDataLocacaoItem(Date dataLocacaoItem) {
		this.dataLocacaoItem = new Date();
	}
	
	
	public Date getDataDevolucaoItem() {
		return dataDevolucaoItem;
	}
	
	public void setDataLocacaoItemBanco(Date dataLocacaoItem) {
		this.dataLocacaoItem = dataLocacaoItem;
	}
	
	public void setDataDevolucaoItemBanco(Date dataDevolucaoItem) {
		this.dataDevolucaoItem = dataDevolucaoItem;
	}
	
	public void setDataDevolucaoItem(int dias) {
		this.dataDevolucaoItem = somarData(dias, dataLocacaoItem);	
		
	}
	
	 public static Date somarData (int dias,Date data) {
	       Calendar calendar = Calendar.getInstance();
	       calendar.setTime(data);
	       calendar.add(Calendar.DATE, dias);
	       return calendar.getTime();
	    };

}
