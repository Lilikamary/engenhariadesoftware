package br.ufpe.cin.vimperial.entidades;

public class Filme {

	
	private Long codFilme;
	private String tituloOriginal;
	private String tituloPortugues;
	private String direcao;
	private String genero;
	private String paisProducao;
	private String ano;
	private String duracao;
	private String sinopse;
	
	private Distribuidora distribuidora;
	

	
	public Long getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(Long codFilme) {
		this.codFilme = codFilme;
	}
	
	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public String getTituloPortugues() {
		return tituloPortugues;
	}

	public void setTituloPortugues(String tituloPortugues) {
		this.tituloPortugues = tituloPortugues;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPaisProducao() {
		return paisProducao;
	}

	public void setPaisProducao(String paisProducao) {
		this.paisProducao = paisProducao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}
	
	
	
}
