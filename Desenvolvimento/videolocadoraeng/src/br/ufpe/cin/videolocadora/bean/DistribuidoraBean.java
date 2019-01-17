package br.ufpe.cin.videolocadora.bean;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import br.ufpe.cin.videolocadora.jpa.Distribuidora;

@Named
@RequestScoped
@URLMapping(id = "manterDistribuidora", pattern = "/cadastrar", 
viewId = "/resources/pages/distribuidora/manterDistribuidora.xhtml")

public class DistribuidoraBean {
	
	private Distribuidora distribuidora;

	public DistribuidoraBean() {
		distribuidora = new Distribuidora();
	}

	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}
	
	

}
