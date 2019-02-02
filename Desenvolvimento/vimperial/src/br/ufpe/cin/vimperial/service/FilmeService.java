package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.FilmeDAO;
import br.ufpe.cin.vimperial.entidades.Filme;

public class FilmeService {
	
	FilmeDAO dao;
	
	public void inserir(Filme filme){
		dao = new FilmeDAO();
		dao.inserir(filme);
	}
	
	public void alterar(Filme filme){
		dao = new FilmeDAO();
		dao.alterar(filme);
	}
	
	public void excluir(Filme filme){
		dao = new FilmeDAO();
		dao.excluir(filme);
	}
	
	public List<Filme> listarTodos(){
		dao = new FilmeDAO();
		return dao.listarTodos();
	}

}
