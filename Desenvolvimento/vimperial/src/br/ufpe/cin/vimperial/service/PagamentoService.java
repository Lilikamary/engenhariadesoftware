package br.ufpe.cin.vimperial.service;

import java.util.List;

import br.ufpe.cin.vimperial.DAO.PagamentoDAO;
import br.ufpe.cin.vimperial.DAO.TipoMidiaDAO;
import br.ufpe.cin.vimperial.entidades.Pagamento;
import br.ufpe.cin.vimperial.entidades.TipoMidia;

public class PagamentoService {
	
	private PagamentoDAO dao;
	
	public PagamentoService(){
		dao = new PagamentoDAO();
	}
	
	public void incluir(Pagamento pagamento){
		 dao.inserir(pagamento);
	}
	
	public void excluir(Pagamento pagamento){
		dao.excluir(pagamento);
	}
	
	public List<Pagamento> listarTodos(){
		return dao.listarTodos();
	}



}
