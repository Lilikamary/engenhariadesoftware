package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.service.DistribuidoraService;


@ManagedBean(name="distribuidoraBean")
@RequestScoped
public class DistribuidoraBean implements Serializable{
	

	private Distribuidora distribuidora;
	private DistribuidoraService service;
	private List<Distribuidora> distribuidoras;

	@PostConstruct
	public void init(){
		
		distribuidora = new Distribuidora();
		service = new DistribuidoraService();
		distribuidoras = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(distribuidora);
		distribuidoras = service.listarTodos();
		distribuidora = new Distribuidora();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(distribuidora);
		distribuidoras = service.listarTodos();
		distribuidora = new Distribuidora();
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
	
}
