package br.ufpe.cin.vimperial.entidades;

public class LocacaoItem {
	
	private Long codLocacaoItem;
	private Locacao locacao;
	private Filme filme;
	private float valorLocacao;
	private float valorMulta;
	private float valorTotal;
	
	
	
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

}
