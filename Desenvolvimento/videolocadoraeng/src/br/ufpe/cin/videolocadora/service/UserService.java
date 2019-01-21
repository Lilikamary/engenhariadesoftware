package br.ufpe.cin.videolocadora.service;

import javax.ejb.Stateless;

import br.com.tds.model.User;

@Stateless
public class UserService {

	public User obterUsuarioPorLogin(String login){
		return new User();	
	}
}
