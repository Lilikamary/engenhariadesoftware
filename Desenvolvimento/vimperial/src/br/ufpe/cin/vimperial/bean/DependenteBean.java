package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Dependente;
import br.ufpe.cin.vimperial.service.ClienteService;
import br.ufpe.cin.vimperial.service.DependenteService;


@ManagedBean(name="dependenteBean")
@SessionScoped
public class DependenteBean implements Serializable{
	

	private Dependente dependente;
	private DependenteService service;
	private List<Dependente> dependentes;
	
	private List<Cliente> clientes;
	private ClienteService clienteService;

	@PostConstruct
	public void init(){
		
		dependente = new Dependente();
		service = new DependenteService();
		dependentes = service.listarTodos();
		clienteService = new ClienteService();
		clientes = clienteService.listarTodos();
	}


	
	public String salvar(){
		service.incluir(dependente);
		dependentes = service.listarTodos();
		dependente = new Dependente();
		clientes = clienteService.listarTodos();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(dependente);
		dependentes = service.listarTodos();
		dependente = new Dependente();
		clientes = clienteService.listarTodos();
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



	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
