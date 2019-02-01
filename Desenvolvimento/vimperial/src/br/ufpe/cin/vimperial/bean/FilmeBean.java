package br.ufpe.cin.vimperial.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@ViewScoped

public class FilmeBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Filme filme = new Filme();


	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public void salvar(Filme filme) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void excluir(Filme filme) {
        try {
        	EntityManager manager = JPAUtil.getEntityManager();
            manager.getTransaction().begin();
            manager.remove(filme);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
	
	public Filme localizarFilme(Long codFilme) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Filme filmeLocalizado = manager.find(Filme.class, codFilme);
		manager.close();
		return filmeLocalizado;
		
	}

	@SuppressWarnings("unchecked")
	public List<Filme> listarTodos(){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();		
		Query query = manager.createQuery("FROM filme");
        List<Filme> filmes = query.getResultList();
        manager.close();
        return filmes;
	}

	
}
