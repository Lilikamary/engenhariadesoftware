package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.entidades.TelefoneCliente;

public class TelefoneService {
	
	private TelefoneDAO dao;
	
	public TelefoneService(){
		dao = new TelefoneDAO();
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
