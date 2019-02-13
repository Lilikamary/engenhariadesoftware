package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.LocacaoDAO;
import br.ufpe.cin.vimperial.entidades.Locacao;

public class LocacaoService {
	
	private LocacaoDAO dao;
	
	public LocacaoService(){
		dao = new LocacaoDAO();
	}
	
	public void incluir(Locacao locacao){
		 dao.inserir(locacao);
	}
	
	public void excluir(Locacao locacao){
		dao.excluir(locacao);
	}
	
	public List<Locacao> listarTodos(){
		return dao.listarTodos();
	}



}
