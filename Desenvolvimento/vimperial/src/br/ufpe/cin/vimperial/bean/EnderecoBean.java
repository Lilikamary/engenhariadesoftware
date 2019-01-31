package br.ufpe.cin.vimperial.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

public class EnderecoBean {

	private Endereco endereco = new Endereco();
	
	public void salvar(Endereco endereco) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(endereco);
		manager.getTransaction().commit();
		manager.close();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listarTodos(){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();		
		Query query = manager.createQuery("FROM endereco");
        List<Endereco> enderecos = query.getResultList();
        manager.close();
        return enderecos;
		
		
	}
	
	
}
