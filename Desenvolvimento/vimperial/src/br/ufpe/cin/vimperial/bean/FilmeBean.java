package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.entidades.TipoMidia;
import br.ufpe.cin.vimperial.service.ClienteService;
import br.ufpe.cin.vimperial.service.DistribuidoraService;
import br.ufpe.cin.vimperial.service.FilmeService;
import br.ufpe.cin.vimperial.service.TipoMidiaService;


@ManagedBean(name="filmeBean")
@SessionScoped
public class FilmeBean implements Serializable{
	

	private Filme filme;
	private FilmeService service;
	private List<Filme> filmes;
	
	private List<Distribuidora> distribuidoras;
	private DistribuidoraService distribuidoraService;
	
	private List<TipoMidia> tipoMidias;
	private TipoMidiaService tipoMidiaService;

	@PostConstruct
	public void init(){
		
		filme = new Filme();
		service = new FilmeService();
		filmes = service.listarTodos();
		
		distribuidoraService = new DistribuidoraService();
		distribuidoras = distribuidoraService.listarTodos();
		
		tipoMidiaService = new TipoMidiaService();
		tipoMidias = tipoMidiaService.listarTodos();

	}


	
	public String salvar(){
		service.incluir(filme);
		filmes = service.listarTodos();
		filme = new Filme();
		tipoMidias = tipoMidiaService.listarTodos();
		distribuidoras = distribuidoraService.listarTodos();

		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(filme);
		filmes = service.listarTodos();
		filme = new Filme();
		tipoMidias = tipoMidiaService.listarTodos();
		distribuidoras = distribuidoraService.listarTodos();

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

	public List<Distribuidora> getDistribuidoras() {
		return distribuidoras;
	}

	public void setDistribuidoras(List<Distribuidora> distribuidoras) {
		this.distribuidoras = distribuidoras;
	}

	public List<TipoMidia> getTipoMidias() {
		return tipoMidias;
	}

	public void setTipoMidias(List<TipoMidia> tipoMidias) {
		this.tipoMidias = tipoMidias;
	}
	
	
	
	
}
