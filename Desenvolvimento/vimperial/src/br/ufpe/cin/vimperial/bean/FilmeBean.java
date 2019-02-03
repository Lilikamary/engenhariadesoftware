package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.service.FilmeService;


@ManagedBean(name="filmeBean")
@RequestScoped
public class FilmeBean implements Serializable{
	

	private Filme filme;
	private FilmeService service;
	private List<Filme> filmes;

	@PostConstruct
	public void init(){
		
		filme = new Filme();
		service = new FilmeService();
		filmes = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(filme);
		filmes = service.listarTodos();
		filme = new Filme();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(filme);
		filmes = service.listarTodos();
		filme = new Filme();
		return "ok";
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
}
