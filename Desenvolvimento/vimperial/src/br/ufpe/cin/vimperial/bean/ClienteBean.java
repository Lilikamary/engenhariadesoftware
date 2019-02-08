package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.service.ClienteService;
import br.ufpe.cin.vimperial.service.EnderecoService;
import br.ufpe.cin.vimperial.service.TelefoneService;


@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean implements Serializable{
	
	
	private Cliente cliente;
	private ClienteService service;
	private List<Cliente> clientes;
	
	private List<Telefone> telefones;
	private TelefoneService telefoneService;
	
	private List<Endereco> enderecos;
	private EnderecoService enderecoService;
	
	@PostConstruct
	public void init(){
		
		cliente = new Cliente();
		service = new ClienteService();
		clientes = service.listarTodos();
		
		telefoneService = new TelefoneService();
		enderecoService = new EnderecoService();
		
		telefones = telefoneService.listarTodos();
		enderecos = enderecoService.listarTodos();
	}
	

	public String salvar(){
		
		service.incluir(cliente);
		clientes = service.listarTodos();
		cliente = new Cliente();
		telefones = telefoneService.listarTodos();
		enderecos = enderecoService.listarTodos();
		
		return "ok";
	}
	
	
	public String excluir(){
		this.service.excluir(cliente);
		clientes = service.listarTodos();
		telefones = telefoneService.listarTodos();
		enderecos = enderecoService.listarTodos();
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



	public List<Telefone> getTelefones() {
		return telefones;
	}



	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}



	public List<Endereco> getEnderecos() {
		return enderecos;
	}



	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
