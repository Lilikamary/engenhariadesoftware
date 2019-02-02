package br.ufpe.cin.vimperial.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.ufpe.cin.vimperial.entidades.Dependente;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class DependenteDAO {
	
	private SessionFactory session;
	
	public void inserir(Dependente dependente) {
		
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(dependente);
		tx.commit();
		s.close();
	}

	public void excluir(Dependente dependente) {

			session = JPAUtil.getSessionFactory();
    		Session s = session.openSession();
    		Transaction tx = s.beginTransaction();
    		s.delete(dependente);
    		tx.commit();
    		s.close();
    }
	
	public void alterar(Dependente dependente){
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.update(dependente);
		tx.commit();
		s.close();
	}	

	@SuppressWarnings("unchecked")
	public List<Dependente> listarTodos(){
		
		List<Dependente> result = new ArrayList<Dependente>();
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		result = s.createCriteria(Dependente.class).list();
		s.close();
		return result;
		
		
	}
	
}
