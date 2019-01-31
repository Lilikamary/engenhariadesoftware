package br.ufpe.cin.vimperial.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;


import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

public class DistribuidoraBean {
	
	private Distribuidora distribuidora = new Distribuidora();
	
	public void salvar(Distribuidora distribuidora) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(distribuidora);
		manager.getTransaction().commit();
		manager.close();
	}

	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	
	
}
