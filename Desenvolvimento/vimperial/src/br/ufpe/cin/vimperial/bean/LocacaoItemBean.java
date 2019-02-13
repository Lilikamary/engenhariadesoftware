package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.entidades.LocacaoItem;
import br.ufpe.cin.vimperial.service.FilmeService;
import br.ufpe.cin.vimperial.service.LocacaoItemService;



@ManagedBean(name="locacaoItemBean")
@SessionScoped
public class LocacaoItemBean implements Serializable{
	

	private LocacaoItem locacaoItem;
	private LocacaoItemService service;
	private List<LocacaoItem> locacaoItens;
	
	private FilmeService filmeService;
	private List<Filme> filmes;
	


	@PostConstruct
	public void init(){
		
		locacaoItem = new LocacaoItem();
		service = new LocacaoItemService();
		locacaoItens = service.listarTodos();
		
		filmeService = new FilmeService();
		filmes = filmeService.listarTodos();

	}


	
	public String salvar(){
		service.incluir(locacaoItem);
		locacaoItens = service.listarTodos();
		locacaoItem = new LocacaoItem();
		filmes = filmeService.listarTodos();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(locacaoItem);
		locacaoItens = service.listarTodos();
		locacaoItem = new LocacaoItem();
		filmes = filmeService.listarTodos();
		return "ok";
	}
	
	public LocacaoItem getLocacaoItem() {
		return locacaoItem;
	}

	public void setLocacaoItem(LocacaoItem locacaoItem) {
		this.locacaoItem = locacaoItem;
	}

	public List<LocacaoItem> getLocacaoItens() {
		return locacaoItens;
	}

	public void setLocacaoItens(List<LocacaoItem> locacaoItens) {
		this.locacaoItens = locacaoItens;
	}



	public List<Filme> getFilmes() {
		return filmes;
	}



	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	
	
}
