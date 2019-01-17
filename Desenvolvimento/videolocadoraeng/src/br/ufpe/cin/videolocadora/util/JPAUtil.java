package br.ufpe.cin.videolocadora.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//baseado em github.com/utluiz/jpa-exemplo-01/blob/master/jpa-exemplo01/src/main/java/br/com/starcode/exemplos/jpa/util/JPAUtil.java
public class JPAUtil {
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getFactory() {
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("videolocadoraeng");
		}
		return factory;
	}

	public static EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}
}
