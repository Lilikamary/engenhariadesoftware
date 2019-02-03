package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.entidades.Filme;

public class EnderecoService {
	
	private EnderecoDAO dao;
	
	public EnderecoService(){
		dao = new EnderecoDAO();
	}
	
	public void incluir(Endereco endereco){
		 dao.inserir(endereco);
	}
	
	public void excluir(Endereco endereco){
		dao.excluir(endereco);
	}
	
	public List<Endereco> listarTodos(){
		return dao.listarTodos();
	}

}
