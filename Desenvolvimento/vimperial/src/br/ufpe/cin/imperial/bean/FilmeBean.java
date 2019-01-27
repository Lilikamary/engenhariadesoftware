package br.ufpe.cin.imperial.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import br.ufpe.cin.imperial.entidade.Filme;
import br.ufpe.cin.imperial.util.JPAUtil;

@ManagedBean
@RequestScoped
@URLMapping(id = "manterFilme", pattern = "/cadastrar", 
viewId = "/resources/pages/filmes/manterFilme.xhtml")
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
