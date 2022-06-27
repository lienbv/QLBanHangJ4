package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectJPA {
	public static EntityManagerFactory getFactory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ASMJ4");
		return factory;
	}
	public static EntityManager getEntityManager() {
		EntityManager em = ConnectJPA.getFactory().createEntityManager();
		return em;
	}

}
