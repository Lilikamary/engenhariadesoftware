package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.TipoMidiaDAO;
import br.ufpe.cin.vimperial.DAO.TipoPagamentoDAO;
import br.ufpe.cin.vimperial.entidades.TipoMidia;
import br.ufpe.cin.vimperial.entidades.TipoPagamento;

public class TipoPagamentoService {
	
	private TipoPagamentoDAO dao;
	
	public TipoPagamentoService(){
		dao = new TipoPagamentoDAO();
	}
	
	public void incluir(TipoPagamento tipoPagamento){
		 dao.inserir(tipoPagamento);
	}
	
	public void excluir(TipoPagamento tipoPagamento){
		dao.excluir(tipoPagamento);
	}
	
	public List<TipoPagamento> listarTodos(){
		return dao.listarTodos();
	}


	
	
}
