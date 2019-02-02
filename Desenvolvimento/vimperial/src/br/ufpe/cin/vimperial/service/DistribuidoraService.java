package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.DistribuidoraDAO;
import br.ufpe.cin.vimperial.entidades.Distribuidora;

public class DistribuidoraService {
	
	DistribuidoraDAO dao;
	
	public void inserir(Distribuidora distribuidora){
		dao = new DistribuidoraDAO();
		dao.inserir(distribuidora);
	}
	
	public void alterar(Distribuidora distribuidora){
		dao = new DistribuidoraDAO();
		dao.alterar(distribuidora);
	}
	
	public void excluir(Distribuidora distribuidora){
		dao = new DistribuidoraDAO();
		dao.excluir(distribuidora);
	}
	
	public List<Distribuidora> listarTodos(){
		dao = new DistribuidoraDAO();
		return dao.listarTodos();
	}


}
