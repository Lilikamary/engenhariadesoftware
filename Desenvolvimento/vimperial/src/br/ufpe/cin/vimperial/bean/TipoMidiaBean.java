package br.ufpe.cin.vimperial.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.ufpe.cin.vimperial.entidades.TipoMidia;
import br.ufpe.cin.vimperial.service.TipoMidiaService;


@ManagedBean(name="tipoMidiaBean")
@SessionScoped
public class TipoMidiaBean implements Serializable{
	

	private TipoMidia tipoMidia;
	private TipoMidiaService service;
	private List<TipoMidia> tipoMidias;

	@PostConstruct
	public void init(){
		
		tipoMidia = new TipoMidia();
		service = new TipoMidiaService();
		tipoMidias = service.listarTodos();
	}


	
	public String salvar(){
		service.incluir(tipoMidia);
		tipoMidias = service.listarTodos();
		tipoMidia = new TipoMidia();
		return "ok";

	}
	
	
	public String excluir(){
		this.service.excluir(tipoMidia);
		tipoMidias = service.listarTodos();
		tipoMidia = new TipoMidia();
		return "ok";
	}
	
	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoMidia tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public List<TipoMidia> getTipoMidias() {
		return tipoMidias;
	}

	public void setTipoMidias(List<TipoMidia> tipoMidias) {
		this.tipoMidias = tipoMidias;
	}
	
}
