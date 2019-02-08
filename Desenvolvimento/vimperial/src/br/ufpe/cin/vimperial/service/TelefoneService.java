package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.TelefoneDAO;
import br.ufpe.cin.vimperial.entidades.Telefone;

public class TelefoneService {
	
	
	private TelefoneDAO dao;
	
	public TelefoneService(){
		dao = new TelefoneDAO();
	}
	
	public void incluir(Telefone telefone){
		 dao.inserir(telefone);
	}
	
	public void excluir(Telefone telefone){
		dao.excluir(telefone);
	}
	
	public List<Telefone> listarTodos(){
		return dao.listarTodos();
	}

}
