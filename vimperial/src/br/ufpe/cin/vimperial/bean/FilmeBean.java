package br.ufpe.cin.vimperial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

public class FilmeBean {
	
	private Filme filme = new Filme();
	private List<Filme> filmes = new ArrayList<>();
	
	
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
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
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

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	
	
}
