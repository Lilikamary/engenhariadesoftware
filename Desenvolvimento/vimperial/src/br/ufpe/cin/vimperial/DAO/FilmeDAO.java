package br.ufpe.cin.vimperial.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class FilmeDAO {
	
	private SessionFactory session;
	
	public void inserir(Filme filme) {
		
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(filme);
		tx.commit();
		s.close();
	}

	public void excluir(Filme filme) {

			session = JPAUtil.getSessionFactory();
    		Session s = session.openSession();
    		Transaction tx = s.beginTransaction();
    		s.delete(filme);
    		tx.commit();
    		s.close();
    }
	
	public void alterar(Filme filme){
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.update(filme);
		tx.commit();
		s.close();
	}	

	@SuppressWarnings("unchecked")
	public List<Filme> listarTodos(){
		
		List<Filme> result = new ArrayList<Filme>();
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		result = s.createCriteria(Filme.class).list();
		s.close();
		return result;
	}

}
