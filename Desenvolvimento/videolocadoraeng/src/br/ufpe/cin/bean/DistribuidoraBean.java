package br.ufpe.cin.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

@Named
@RequestScoped
@URLMapping(id = "manterDistribuidora", pattern = "/cadastrar", 
viewId = "/resources/pages/distribuidora/manterDistribuidora.xhtml")

public class DistribuidoraBean {
	private String input;
	private String output;

	public DistribuidoraBean() {
	}

	public void submit() {
		output="Hello World! You have typed: " + input;
	}
	
	public String getInput() {
		return input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getOutput() {
		return output;
	}
}
