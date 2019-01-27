package br.ufpe.cin.imperial.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("vimperial");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
