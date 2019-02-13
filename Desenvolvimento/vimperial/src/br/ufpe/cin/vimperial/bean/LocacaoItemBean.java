package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.service.ClienteService;
import br.ufpe.cin.vimperial.service.FilmeService;
import br.ufpe.cin.vimperial.service.TelefoneService;


@ManagedBean(name="telefoneBean")
@SessionScoped
public class LocacaoItemBean implements Serializable{
	

	private Telefone telefone;
	private TelefoneService service;
	private List<Telefone> telefones;
	
	private FilmeService filmeService;
	private List<Filme> filmes;
	


	@PostConstruct
	public void init(){
		
		telefone = new Telefone();
		service = new TelefoneService();
		telefones = service.listarTodos();
		
		filmeService = new FilmeService();
		filmes = filmeService.listarTodos();

	}


	
	public String salvar(){
		service.incluir(telefone);
		telefones = service.listarTodos();
		telefone = new Telefone();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(telefone);
		telefones = service.listarTodos();
		telefone = new Telefone();
		return "ok";
	}
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}
