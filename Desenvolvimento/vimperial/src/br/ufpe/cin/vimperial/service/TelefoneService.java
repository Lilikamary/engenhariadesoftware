package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.TelefoneDAO;
import br.ufpe.cin.vimperial.entidades.Telefone;

public class TelefoneService {
	
	TelefoneDAO dao;
	
	public void inserir(Telefone telefone){
		dao = new TelefoneDAO();
		dao.inserir(telefone);
	}
	
	public void alterar(Telefone telefone){
		dao = new TelefoneDAO();
		dao.alterar(telefone);
	}
	
	public void excluir(Telefone telefone){
		dao = new TelefoneDAO();
		dao.excluir(telefone);
	}
	
	public List<Telefone> listarTodos(){
		dao = new TelefoneDAO();
		return dao.listarTodos();
	}


}
