package br.ufpe.cin.imperial.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.ocpsoft.pretty.faces.annotation.URLMapping;


import br.ufpe.cin.imperial.entidade.EndDistribuidora;
import br.ufpe.cin.imperial.entidade.Filme;
import br.ufpe.cin.imperial.util.JPAUtil;

@ManagedBean
@RequestScoped
@URLMapping(id = "manterEndDistribuidora", pattern = "/cadastrar", 
viewId = "/resources/pages/distribuidoras/manterEndDistribuidora.xhtml")
public class EndDistribuidoraBean {

	private EndDistribuidora endDistribuidora = new EndDistribuidora();
	
	public void salvar(EndDistribuidora endDistribuidora) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(endDistribuidora);
		manager.getTransaction().commit();
		manager.close();
	}

	public EndDistribuidora getEndDistribuidora() {
		return endDistribuidora;
	}

	public void setEndDistribuidora(EndDistribuidora endDistribuidora) {
		this.endDistribuidora = endDistribuidora;
	}
	
	
	
}
