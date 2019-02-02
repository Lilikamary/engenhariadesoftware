package br.ufpe.cin.vimperial.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class JPAUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory buildSessionFactory() {
		 Configuration configuration = new Configuration();
		    configuration.configure("hibernate.cfg.xml");
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
