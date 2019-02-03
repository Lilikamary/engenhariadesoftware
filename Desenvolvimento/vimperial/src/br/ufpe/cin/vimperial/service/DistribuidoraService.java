package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.FilmeDAO;
import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.entidades.Filme;

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
