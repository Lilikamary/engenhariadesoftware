package br.ufpe.cin.vimperial.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class ClienteDAO {
	
	private SessionFactory session;
	
	public void inserir(Cliente cliente) {
		
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(cliente);
		tx.commit();
		s.close();
	}

	public void excluir(Cliente cliente) {

			session = JPAUtil.getSessionFactory();
    		Session s = session.openSession();
    		Transaction tx = s.beginTransaction();
    		s.delete(cliente);
    		tx.commit();
    		s.close();
    }
	
	public void alterar(Cliente cliente){
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.update(cliente);
		tx.commit();
		s.close();
	}	

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos(){
		
		List<Cliente> result = new ArrayList<Cliente>();
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		result = s.createCriteria(Cliente.class).list();
		s.close();
		return result;
		
		
	}
	
}
