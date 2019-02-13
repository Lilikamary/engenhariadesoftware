package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.LocacaoItemDAO;
import br.ufpe.cin.vimperial.DAO.TipoMidiaDAO;
import br.ufpe.cin.vimperial.entidades.LocacaoItem;
import br.ufpe.cin.vimperial.entidades.TipoMidia;

public class LocacaoItemService {
	
	private LocacaoItemDAO dao;
	
	public LocacaoItemService(){
		dao = new LocacaoItemDAO();
	}
	
	public void incluir(LocacaoItem locacaoItem){
		 dao.inserir(locacaoItem);
	}
	
	public void excluir(LocacaoItem locacaoItem){
		dao.excluir(locacaoItem);
	}
	
	public List<LocacaoItem> listarTodos(){
		return dao.listarTodos();
	}



}
