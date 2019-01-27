package br.ufpe.cin.imperial.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="filme")
public class Filme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codFilme;
	
	private String tituloOriginal;
	private String tituloPortugues;
	private String direcao;
	private String genero;
	private String paisProducao;
	private Integer ano;
	private String duracao;
	private String sinopse;
	
	@ManyToOne
	private Distribuidora distribuidora;
	

	public Long getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(Long codFilme) {
		this.codFilme = codFilme;
	}

	
	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
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
	
}
