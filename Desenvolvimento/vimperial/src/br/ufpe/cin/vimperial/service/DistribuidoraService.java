package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.DistribuidoraDAO;
import br.ufpe.cin.vimperial.entidades.Distribuidora;

public class DistribuidoraService {
	
	private DistribuidoraDAO dao;
	
	public DistribuidoraService(){
		dao = new DistribuidoraDAO();
	}
	
	public void incluir(Distribuidora distribuidora){
		 dao.inserir(distribuidora);
	}
	
	public void excluir(Distribuidora distribuidora){
		dao.excluir(distribuidora);
	}
	
	public List<Distribuidora> listarTodos(){
		return dao.listarTodos();
	}

}
