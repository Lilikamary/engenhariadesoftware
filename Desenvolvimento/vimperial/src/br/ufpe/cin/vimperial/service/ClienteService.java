package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.FilmeDAO;
import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Filme;

public class ClienteService {
	
	private ClienteDAO dao;
	
	public ClienteService(){
		dao = new ClienteDAO();
	}
	
	public void incluir(Cliente cliente){
		 dao.inserir(cliente);
	}
	
	public void excluir(Cliente cliente){
		dao.excluir(cliente);
	}
	
	public List<Cliente> listarTodos(){
		return dao.listarTodos();
	}

}
