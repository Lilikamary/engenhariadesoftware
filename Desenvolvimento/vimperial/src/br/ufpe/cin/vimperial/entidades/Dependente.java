package br.ufpe.cin.vimperial.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="dependente")
@SequenceGenerator(name = "seq_dependente",
sequenceName = "dependente_seq", initialValue = 1, 
allocationSize = 1)
public class Dependente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dependente")
	private Long codDependente;
	
	private String nome;
	private String tipoDependente;
	private String email;
	
	@ManyToOne
	private Cliente cliente;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
