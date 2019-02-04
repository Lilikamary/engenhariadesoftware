package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.service.ClienteService;


@ManagedBean(name="clienteBean")
@ViewScoped
public class ClienteBean implements Serializable{
	

	private Cliente cliente;
	private ClienteService service;
	private List<Cliente> clientes;

	@PostConstruct
	public void init(){
		
		cliente = new Cliente();
		service = new ClienteService();
		clientes = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(cliente);
		clientes = service.listarTodos();
		cliente = new Cliente();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(cliente);
		clientes = service.listarTodos();
		cliente = new Cliente();
		return "ok";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
