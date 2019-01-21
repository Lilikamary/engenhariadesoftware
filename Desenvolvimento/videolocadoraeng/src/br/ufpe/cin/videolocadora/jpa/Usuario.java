package br.ufpe.cin.videolocadora.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufpe.cin.videolocadora.dominios.DominioTipoUsuario;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long codUsuario;
	
	private String nome;
	private String login;
	private String senha;
	private DominioTipoUsuario tipoUsuario;
	
		
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Long getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public DominioTipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(DominioTipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	} 
}
