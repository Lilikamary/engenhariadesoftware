package br.ufpe.cin.videolocadora.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.ufpe.cin.videolocadora.jpa.Usuario;

@Named
@RequestScoped
public class UsuarioBean {

	private Usuario usuario;
	
	public UsuarioBean() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
