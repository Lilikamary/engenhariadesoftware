package br.ufpe.cin.vimperial.entidades;


public class Dependente {
	
	private Long codDependente;
	
	private String nome;
	private String tipoDependente;
	private String email;
	

	public Long getCodDependente() {
		return codDependente;
	}

	public void setCodDependente(Long codDependente) {
		this.codDependente = codDependente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoDependente() {
		return tipoDependente;
	}

	public void setTipoDependente(String tipoDependente) {
		this.tipoDependente = tipoDependente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
