package br.ufpe.cin.videolocadora.bean;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;


import com.ocpsoft.pretty.faces.annotation.URLMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "manterDistribuidora", pattern = "/cadastrar", 
viewId = "/resources/pages/distribuidora/manterDistribuidora.xhtml")

public class DistribuidoraBean {

	public DistribuidoraBean() {
	}

}
