package br.ufpe.cin.vimperial.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="distribuidora")
@SequenceGenerator(name = "seq_distribuidora",
sequenceName = "distribuidora_seq", initialValue = 1, 
allocationSize = 1)

public class Distribuidora {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_distribuidora")
	private Long codDistribuidora;
	
	private String razaoSocial;
	private String responsavel;
	private String telefone;
	
	@ManyToOne
	private Endereco endereco;

	public Long getCodDistribuidora() {
		return codDistribuidora;
	}

	public void setCodDistribuidora(Long codDistribuidora) {
		this.codDistribuidora = codDistribuidora;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
