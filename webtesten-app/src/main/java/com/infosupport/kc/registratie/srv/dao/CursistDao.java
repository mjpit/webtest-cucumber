package com.infosupport.kc.registratie.srv.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.infosupport.kc.registratie.domain.Cursist;

@Singleton
public class CursistDao {

	@CursistDb
	@Inject
	EntityManager em;

	private CursistDao() {
	}

	public boolean isGeregistreerd(String gebruikersnaam) {
		return getCursist(gebruikersnaam) != null;
	}

	public void save(Cursist cursist) {
		em.getTransaction().begin();
		em.persist(cursist);
		em.getTransaction().commit();
	}

	public Cursist getCursist(String gebruikersnaam) {
		TypedQuery<Cursist> query = em.createQuery("select c from Cursist c where c.gebruikersnaam = :naam",
				Cursist.class);
		query.setParameter("naam", gebruikersnaam);
		List<Cursist> resultList = query.getResultList();
		if (resultList.isEmpty()) {
			return null;
		}
		return resultList.get(0);
	}
	
	public void deleteCursisten() {
		em.getTransaction().begin();
		em.createQuery("delete from Cursist").executeUpdate();
		em.getTransaction().commit();
	}
}
