package br.ufpe.cin.vimperial.entidades;


public class Endereco {
	

	private Long codEndereco;
	
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String cep;

	
	public Long getCodEndereco() {
		return codEndereco;
	}
	
	public void setCodEndereco(Long codEndereco) {
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
