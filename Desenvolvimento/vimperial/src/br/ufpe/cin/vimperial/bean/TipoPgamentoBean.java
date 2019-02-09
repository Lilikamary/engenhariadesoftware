package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import br.ufpe.cin.vimperial.entidades.TipoPagamento;
import br.ufpe.cin.vimperial.service.TipoPagamentoService;


@ManagedBean(name="tipoPagamentoBean")
@SessionScoped
public class TipoPgamentoBean implements Serializable{
	

	private TipoPagamento tipoPagamento;
	private TipoPagamentoService service;
	private List<TipoPagamento> tipoPagamentos;

	@PostConstruct
	public void init(){
		
		tipoPagamento = new TipoPagamento();
		service = new TipoPagamentoService();
		tipoPagamentos = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(tipoPagamento);
		tipoPagamentos = service.listarTodos();
		tipoPagamento = new TipoPagamento();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(tipoPagamento);
		tipoPagamentos = service.listarTodos();
		tipoPagamento = new TipoPagamento();
		return "ok";
	}
	
	public TipoPagamento getTipoPgamento() {
		return tipoPagamento;
	}

	public void setTipoPgamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public List<TipoPagamento> getTipoPgamentos() {
		return tipoPagamentos;
	}

	public void setTipoPgamentos(List<TipoPagamento> tipoPagamentos) {
		this.tipoPagamentos = tipoPagamentos;
	}
	
}
