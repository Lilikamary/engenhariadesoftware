package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.DependenteDAO;
import br.ufpe.cin.vimperial.entidades.Dependente;

public class DependenteService {
	
	private DependenteDAO dao;
	
	public DependenteService(){
		dao = new DependenteDAO();
	}
	
	public void incluir(Dependente dependente){
		 dao.inserir(dependente);
	}
	
	public void excluir(Dependente dependente){
		dao.excluir(dependente);
	}
	
	public List<Dependente> listarTodos(){
		return dao.listarTodos();
	}

}
