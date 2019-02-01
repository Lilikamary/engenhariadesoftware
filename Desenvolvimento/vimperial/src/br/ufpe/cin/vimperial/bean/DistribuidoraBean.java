package br.ufpe.cin.vimperial.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;


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

	
	public void excluir(Distribuidora distribuidora) {
        try {
        	EntityManager manager = JPAUtil.getEntityManager();
            manager.getTransaction().begin();
            manager.remove(distribuidora);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
	
	public Distribuidora localizarDistribuidora(Long codDistribuidora) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Distribuidora distribuidoraLocalizado = manager.find(Distribuidora.class, codDistribuidora);
		manager.close();
		return distribuidoraLocalizado;
		
	}
	
	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	@SuppressWarnings("unchecked")
	public List<Distribuidora> listarTodos(){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();		
		Query query = manager.createQuery("FROM distribuidora");
        List<Distribuidora> distribuidoras = query.getResultList();
        manager.close();
        return distribuidoras;
		
		
	}
	
	
}
