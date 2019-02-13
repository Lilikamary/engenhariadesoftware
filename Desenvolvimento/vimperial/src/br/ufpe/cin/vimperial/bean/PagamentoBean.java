package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.ufpe.cin.vimperial.entidades.Locacao;
import br.ufpe.cin.vimperial.entidades.Pagamento;
import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.entidades.TipoPagamento;
import br.ufpe.cin.vimperial.service.LocacaoService;
import br.ufpe.cin.vimperial.service.PagamentoService;
import br.ufpe.cin.vimperial.service.TelefoneService;
import br.ufpe.cin.vimperial.service.TipoPagamentoService;


@ManagedBean(name="pagamentoBean")
@SessionScoped
public class PagamentoBean implements Serializable{
	

	private Pagamento pagamento;
	private PagamentoService service;
	private List<Pagamento> pagamentos;
	
	private LocacaoService locacaoService;
	private List<Locacao> locacoes;
	 
	private TipoPagamentoService tipoPagamentoService;
	private List<TipoPagamento> tipoPagamentos;

	
	
	@PostConstruct
	public void init(){
		
		pagamento = new Pagamento();
		service = new PagamentoService();
		pagamentos = service.listarTodos();
		
		locacaoService = new LocacaoService();
		locacoes = locacaoService.listarTodos();
		
		tipoPagamentoService = new TipoPagamentoService();
		tipoPagamentos = tipoPagamentoService.listarTodos();

		
	}


	
	public String salvar(){
		service.incluir(pagamento);
		pagamentos = service.listarTodos();
		pagamento = new Pagamento();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(pagamento);
		pagamentos = service.listarTodos();
		pagamento = new Pagamento();
		return "ok";
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}



	public List<Locacao> getLocacoes() {
		return locacoes;
	}



	public void setLocacaos(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}



	public List<TipoPagamento> getTipoPagamentos() {
		return tipoPagamentos;
	}



	public void setTipoPagamentos(List<TipoPagamento> tipoPagamentos) {
		this.tipoPagamentos = tipoPagamentos;
	}
	
	
}
