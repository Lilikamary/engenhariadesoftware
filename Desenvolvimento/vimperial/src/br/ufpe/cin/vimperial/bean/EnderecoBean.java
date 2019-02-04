package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.service.EnderecoService;


@ManagedBean(name="enderecoBean")
@ViewScoped
public class EnderecoBean implements Serializable{
	

	private Endereco endereco;
	private EnderecoService service;
	private List<Endereco> enderecos;

	@PostConstruct
	public void init(){
		
		endereco = new Endereco();
		service = new EnderecoService();
		enderecos = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(endereco);
		enderecos = service.listarTodos();
		endereco = new Endereco();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(endereco);
		enderecos = service.listarTodos();
		endereco = new Endereco();
		return "ok";
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
