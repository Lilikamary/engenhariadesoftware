package br.ufpe.cin.videolocadora.service;

import javax.ejb.Stateless;

import br.ufpe.cin.videolocadora.jpa.Usuario;

@Stateless
public class UsuarioService {

	public Usuario obterUsuarioPorLogin(String login){
		return new Usuario();	
	}
}
