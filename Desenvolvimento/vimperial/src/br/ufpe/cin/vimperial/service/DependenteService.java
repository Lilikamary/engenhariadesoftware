package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.DependenteDAO;
import br.ufpe.cin.vimperial.entidades.Dependente;

public class DependenteService {
	
	DependenteDAO dao;
	
	public void inserir(Dependente dependente){
		dao = new DependenteDAO();
		dao.inserir(dependente);
	}
	
	public void alterar(Dependente dependente){
		dao = new DependenteDAO();
		dao.alterar(dependente);
	}
	
	public void excluir(Dependente dependente){
		dao = new DependenteDAO();
		dao.excluir(dependente);
	}
	
	public List<Dependente> listarTodos(){
		dao = new DependenteDAO();
		return dao.listarTodos();
	}


}
