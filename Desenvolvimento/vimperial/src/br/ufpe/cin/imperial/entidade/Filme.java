package br.ufpe.cin.imperial.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filme")
public class Filme {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codFilme;
	
	private String nome;
	private String distribuidora;

	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	public Long getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(Long codFilme) {
		this.codFilme = codFilme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
