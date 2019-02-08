package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.FilmeDAO;
import br.ufpe.cin.vimperial.entidades.Filme;

public class FilmeService {
	
	
	private FilmeDAO dao;
	
	public FilmeService(){
		dao = new FilmeDAO();
	}
	
	public void incluir(Filme filme){
		 dao.inserir(filme);
	}
	
	public void excluir(Filme filme){
		dao.excluir(filme);
	}
	
	public List<Filme> listarTodos(){
		return dao.listarTodos();
	}

}
