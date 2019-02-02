package br.ufpe.cin.vimperial.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class DistribuidoraDAO {
	
	private SessionFactory session;
	
	public void inserir(Distribuidora distribuidora) {
		
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(distribuidora);
		tx.commit();
		s.close();
	}

	public void excluir(Distribuidora distribuidora) {

			session = JPAUtil.getSessionFactory();
    		Session s = session.openSession();
    		Transaction tx = s.beginTransaction();
    		s.delete(distribuidora);
    		tx.commit();
    		s.close();
    }
	
	public void alterar(Distribuidora distribuidora){
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.update(distribuidora);
		tx.commit();
		s.close();
	}	

	@SuppressWarnings("unchecked")
	public List<Distribuidora> listarTodos(){
		
		List<Distribuidora> result = new ArrayList<Distribuidora>();
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		result = s.createCriteria(Distribuidora.class).list();
		s.close();
		return result;
		
		
	}
	
}
