package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.ufpe.cin.vimperial.entidades.TelefoneCliente;
import br.ufpe.cin.vimperial.service.TelefoneClienteService;


@ManagedBean(name="telefoneClienteBean")
@ViewScoped
public class TelefoneClienteBean implements Serializable{
	

	private TelefoneCliente telefoneCliente;
	private TelefoneClienteService service;
	private List<TelefoneCliente> telefoneClientes;

	@PostConstruct
	public void init(){
		
		telefoneCliente = new TelefoneCliente();
		service = new TelefoneClienteService();
		telefoneClientes = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(telefoneCliente);
		telefoneClientes = service.listarTodos();
		telefoneCliente = new TelefoneCliente();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(telefoneCliente);
		telefoneClientes = service.listarTodos();
		telefoneCliente = new TelefoneCliente();
		return "ok";
	}
	
	public TelefoneCliente getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(TelefoneCliente telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public List<TelefoneCliente> getTelefoneClientes() {
		return telefoneClientes;
	}

	public void setTelefoneClientes(List<TelefoneCliente> telefoneClientes) {
		this.telefoneClientes = telefoneClientes;
	}
	
}
