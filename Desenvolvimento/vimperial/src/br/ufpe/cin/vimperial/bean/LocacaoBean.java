package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Locacao;
import br.ufpe.cin.vimperial.service.ClienteService;
import br.ufpe.cin.vimperial.service.LocacaoService;


@ManagedBean(name="locacaoBean")
@SessionScoped
public class LocacaoBean implements Serializable{
	

	private Locacao locacao;
	private LocacaoService service;
	private List<Locacao> locacoes;
	
	private ClienteService clienteService;
	private List<Cliente> clientes;

	@PostConstruct
	public void init(){
		
		locacao = new Locacao();
		service = new LocacaoService();
		locacoes = service.listarTodos();
		
		clienteService = new ClienteService();
		clientes = clienteService.listarTodos();
	}


	
	public String salvar(){
		service.incluir(locacao);
		locacoes = service.listarTodos();
		locacao = new Locacao();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(locacao);
		locacoes = service.listarTodos();
		locacao = new Locacao();
		return "ok";
	}
	
	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
}
