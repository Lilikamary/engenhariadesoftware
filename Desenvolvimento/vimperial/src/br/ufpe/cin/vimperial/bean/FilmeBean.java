package br.ufpe.cin.vimperial.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;


import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

public class FilmeBean {
	
	private Filme filme = new Filme();
	
	public void salvar(Filme filme) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();
		manager.close();
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
