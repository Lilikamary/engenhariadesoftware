package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufpe.cin.vimperial.entidades.Dependente;
import br.ufpe.cin.vimperial.service.DependenteService;


@ManagedBean(name="dependenteBean")
@RequestScoped
public class DependenteBean implements Serializable{
	

	private Dependente dependente;
	private DependenteService service;
	private List<Dependente> dependentes;

	@PostConstruct
	public void init(){
		
		dependente = new Dependente();
		service = new DependenteService();
		dependentes = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(dependente);
		dependentes = service.listarTodos();
		dependente = new Dependente();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(dependente);
		dependentes = service.listarTodos();
		dependente = new Dependente();
		return "ok";
	}
	
	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
}
