package br.ufpe.cin.vimperial.service;

import java.util.List;


import br.ufpe.cin.vimperial.DAO.TipoMidiaDAO;
import br.ufpe.cin.vimperial.entidades.TipoMidia;

public class TipoMidiaService {
	
	private TipoMidiaDAO dao;
	
	public TipoMidiaService(){
		dao = new TipoMidiaDAO();
	}
	
	public void incluir(TipoMidia tipoMidia){
		 dao.inserir(tipoMidia);
	}
	
	public void excluir(TipoMidia tipoMidia){
		dao.excluir(tipoMidia);
	}
	
	public List<TipoMidia> listarTodos(){
		return dao.listarTodos();
	}



}
