package br.ufpe.cin.vimperial.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufpe.cin.vimperial.entidades.Dependente;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

public class DependenteBean {
	
	private Dependente dependente = new Dependente();
	
	public void salvar(Dependente dependente) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(dependente);
		manager.getTransaction().commit();
		manager.close();
	}

	public void excluir(Dependente dependente) {
        try {
        	EntityManager manager = JPAUtil.getEntityManager();
            manager.getTransaction().begin();
            manager.remove(dependente);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
	
	public Dependente localizarDependente(Long codDependente) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Dependente clienteLocalizado = manager.find(Dependente.class, codDependente);
		manager.close();
		return clienteLocalizado;
		
	}
	
	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listarTodos(){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();		
		Query query = manager.createQuery("FROM dependente");
        List<Dependente> dependentes = query.getResultList();
        manager.close();
        return dependentes;
		
		
	}
	
}
