package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.EnderecoDAO;
import br.ufpe.cin.vimperial.entidades.Endereco;

public class EnderecoService {
	
	EnderecoDAO dao;
	
	public void inserir(Endereco endereco){
		dao = new EnderecoDAO();
		dao.inserir(endereco);
	}
	
	public void alterar(Endereco endereco){
		dao = new EnderecoDAO();
		dao.alterar(endereco);
	}
	
	public void excluir(Endereco endereco){
		dao = new EnderecoDAO();
		dao.excluir(endereco);
	}
	
	public List<Endereco> listarTodos(){
		dao = new EnderecoDAO();
		return dao.listarTodos();
	}


}
