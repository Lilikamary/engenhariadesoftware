package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.service.DistribuidoraService;
import br.ufpe.cin.vimperial.service.EnderecoService;
import br.ufpe.cin.vimperial.service.TelefoneService;


@ManagedBean(name="distribuidoraBean")
@SessionScoped
public class DistribuidoraBean implements Serializable{
	

	private Distribuidora distribuidora;
	private DistribuidoraService service;
	private List<Distribuidora> distribuidoras;
	
	private List<Telefone> telefones;
	private TelefoneService telefoneService;
	
	private List<Endereco> enderecos;
	private EnderecoService enderecoService;

	@PostConstruct
	public void init(){
		
		distribuidora = new Distribuidora();
		service = new DistribuidoraService();
		distribuidoras = service.listarTodos();
		
		telefoneService = new TelefoneService();
		enderecoService = new EnderecoService();
		
		telefones = telefoneService.listarTodos();
		enderecos = enderecoService.listarTodos();
	}


	
	public String salvar(){
		service.incluir(distribuidora);
		distribuidoras = service.listarTodos();
		distribuidora = new Distribuidora();
		telefones = telefoneService.listarTodos();
		enderecos = enderecoService.listarTodos();

		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(distribuidora);
		distribuidoras = service.listarTodos();
		distribuidora = new Distribuidora();
		telefones = telefoneService.listarTodos();
		enderecos = enderecoService.listarTodos();

		return "ok";
	}
	
	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	public List<Distribuidora> getDistribuidoras() {
		return distribuidoras;
	}

	public void setDistribuidoras(List<Distribuidora> distribuidoras) {
		this.distribuidoras = distribuidoras;
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
