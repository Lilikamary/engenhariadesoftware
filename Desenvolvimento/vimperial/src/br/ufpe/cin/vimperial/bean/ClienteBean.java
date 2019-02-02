package br.ufpe.cin.vimperial.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.util.JPAUtil;

@ManagedBean
@RequestScoped

public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	
	public void salvar(Cliente cliente) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
		manager.close();
	}

	public void excluir(Cliente cliente) {
        try {
        	EntityManager manager = JPAUtil.getEntityManager();
            manager.getTransaction().begin();
            manager.remove(cliente);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
	
	public Cliente localizarCliente(Long codCliente) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Cliente clienteLocalizado = manager.find(Cliente.class, codCliente);
		manager.close();
		return clienteLocalizado;
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos(){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();		
		Query query = manager.createQuery("FROM cliente");
        List<Cliente> clientes = query.getResultList();
        manager.close();
        return clientes;
		
		
	}
	
}
