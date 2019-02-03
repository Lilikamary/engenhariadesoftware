package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.TelefoneClienteDAO;
import br.ufpe.cin.vimperial.entidades.TelefoneCliente;

public class TelefoneClienteService {
	
	private TelefoneClienteDAO dao;
	
	public TelefoneClienteService(){
		dao = new TelefoneClienteDAO();
	}
	
	public void incluir(TelefoneCliente telefone){
		 dao.inserir(telefone);
	}
	
	public void excluir(TelefoneCliente telefone){
		dao.excluir(telefone);
	}
	
	public List<TelefoneCliente> listarTodos(){
		return dao.listarTodos();
	}

}
