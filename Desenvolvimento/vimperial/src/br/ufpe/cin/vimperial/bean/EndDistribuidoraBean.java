package br.ufpe.cin.vimperial.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.ufpe.cin.vimperial.entidades.EndDistribuidora;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

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
