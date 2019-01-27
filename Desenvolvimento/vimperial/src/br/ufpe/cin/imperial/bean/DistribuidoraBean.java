package br.ufpe.cin.imperial.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import br.ufpe.cin.imperial.entidade.Distribuidora;
import br.ufpe.cin.imperial.util.JPAUtil;

@ManagedBean
@RequestScoped
@URLMapping(id = "manterDistribuidora", pattern = "/cadastrar", 
viewId = "/resources/pages/distribuidoras/manterDistribuidora.xhtml")
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
