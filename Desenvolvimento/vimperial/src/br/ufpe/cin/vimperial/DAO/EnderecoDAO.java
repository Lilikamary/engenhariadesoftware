package br.ufpe.cin.vimperial.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class EnderecoDAO {
	
	private SessionFactory session;
	
	public void inserir(Endereco endereco) {
		
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(endereco);
		tx.commit();
		s.close();
	}

	public void excluir(Endereco endereco) {

			session = JPAUtil.getSessionFactory();
    		Session s = session.openSession();
    		Transaction tx = s.beginTransaction();
    		s.delete(endereco);
    		tx.commit();
    		s.close();
    }
	
	public void alterar(Endereco endereco){
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.update(endereco);
		tx.commit();
		s.close();
	}	

	@SuppressWarnings("unchecked")
	public List<Endereco> listarTodos(){
		
		List<Endereco> result = new ArrayList<Endereco>();
		session = JPAUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		result = s.createCriteria(Endereco.class).list();
		s.close();
		return result;
		
		
	}
	
}
