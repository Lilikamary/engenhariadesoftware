package br.ufpe.cin.vimperial.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

public class TelefoneBean {
	
	private Telefone telefone = new Telefone();
	
	public void salvar(Telefone telefone) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(telefone);
		manager.getTransaction().commit();
		manager.close();
	}

	public void excluir(Telefone telefone) {
        try {
        	EntityManager manager = JPAUtil.getEntityManager();
            manager.getTransaction().begin();
            manager.remove(telefone);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
	
	public Telefone localizarTelefone(Long codTelefone) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Telefone telefoneLocalizado = manager.find(Telefone.class, codTelefone);
		manager.close();
		return telefoneLocalizado;
		
	}
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@SuppressWarnings("unchecked")
	public List<Telefone> listarTodos(){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();		
		Query query = manager.createQuery("FROM telefone");
        List<Telefone> telefones = query.getResultList();
        manager.close();
        return telefones;
		
		
	}
	
}
