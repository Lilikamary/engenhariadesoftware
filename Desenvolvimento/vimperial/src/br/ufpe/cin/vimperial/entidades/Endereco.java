package br.ufpe.cin.vimperial.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
@SequenceGenerator(name = "seq_endereco",
sequenceName = "endereco_seq", initialValue = 1, 
allocationSize = 1)
public class Endereco {
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_endereco")
	private Long codEndereco;
	
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String cep;

	
	public Long getCodEndereco() {
		return codEndereco;
	}
	public void setCodEnderecoa(Long codEndereco) {
		this.codEndereco = codEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}
