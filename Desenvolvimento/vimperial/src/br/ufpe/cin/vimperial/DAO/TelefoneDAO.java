package br.ufpe.cin.vimperial.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class TelefoneDAO {
	
	private SessionFactory session;
	
	public void inserir(Telefone telefone) {
		
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(telefone);
		tx.commit();
		s.close();
	}

	public void excluir(Telefone telefone) {

			session = JPAUtil.getSessionFactory();
    		Session s = session.openSession();
    		Transaction tx = s.beginTransaction();
    		s.delete(telefone);
    		tx.commit();
    		s.close();
    }
	
	public void alterar(Telefone telefone){
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.update(telefone);
		tx.commit();
		s.close();
	}	

	@SuppressWarnings("unchecked")
	public List<Telefone> listarTodos(){
		
		List<Telefone> result = new ArrayList<Telefone>();
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		result = s.createCriteria(Telefone.class).list();
		s.close();
		return result;
		
		
	}
	
}
