package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.ClienteDAO;
import br.ufpe.cin.vimperial.entidades.Cliente;

public class ClienteService {
	
	ClienteDAO dao;
	
	public void inserir(Cliente cliente){
		dao = new ClienteDAO();
		dao.inserir(cliente);
	}
	
	public void alterar(Cliente cliente){
		dao = new ClienteDAO();
		dao.alterar(cliente);
	}
	
	public void excluir(Cliente cliente){
		dao = new ClienteDAO();
		dao.excluir(cliente);
	}
	
	public List<Cliente> listarTodos(){
		dao = new ClienteDAO();
		return dao.listarTodos();
	}


}
