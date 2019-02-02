package br.ufpe.cin.vimperial.bean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.service.FilmeService;


@ManagedBean
@ViewScoped
public class FilmeBean {
	
	/**
	 * 
	 */
	private Filme filme;
	private FilmeService service;
	private List<Filme> filmes;

	@PostConstruct
	public void init(){
		service = new FilmeService();
		filme = new Filme();
		filmes = service.listarTodos();
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
	
	public void salvar(){
		this.service.inserir(filme);
		this.init();
		FacesContext context = 
				FacesContext.getCurrentInstance();
        
        context.addMessage(null,
        		new FacesMessage("Sucesso",  
        				"Cadastro com sucesso!" ) );

	}
	
	
	public void atualizar(){
		this.service.alterar(filme);;
		this.init();
		FacesContext context = 
				FacesContext.getCurrentInstance();
        
        context.addMessage(null,
        		new FacesMessage("Sucesso",  
        				"Alterado com sucesso!" ) );

	}
	
	
	public void excluir(){
		this.service.excluir(filme);
		this.init();
		FacesContext context = 
				FacesContext.getCurrentInstance();
        
        context.addMessage(null,
        		new FacesMessage("Sucesso",  
        				"Excluído com sucesso!" ) );

	}	
	
	
}
