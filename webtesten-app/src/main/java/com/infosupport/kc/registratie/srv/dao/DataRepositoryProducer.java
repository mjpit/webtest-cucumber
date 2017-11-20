package com.infosupport.kc.registratie.srv.dao;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.infosupport.kc.registratie.domain.Cursist;

/**
 * 
 * @author teunh
 * 
 */
@Singleton
// @Singleton zorgt ervoor dat er maar 1 instantie van een DataRepoProducer
// wordt aangemaakt
public class DataRepositoryProducer {

	private static EntityManagerFactory factory;

	/**
	 * Private constructor zodat deze klasse niet aangemaakt kan worden.
	 */
	private DataRepositoryProducer() {

	}

	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("pu");

			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			List<Cursist> cursisten = Arrays.asList(new Cursist("PietHein", "PietHein@mail.com"),
					new Cursist("Michiel", "Michiel@mail.com"));

			for (Cursist cursist : cursisten) {
				cursist.activate();
				em.persist(cursist);
			}
			em.getTransaction().commit();

		}
		return factory;
	}

	@Produces
	@CursistDb
	@RequestScoped
	// @RequestScoped: voor elk request een nieuwe EM
	public EntityManager produceEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}

}
