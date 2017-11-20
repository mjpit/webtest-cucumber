package com.infosupport.kc.registratie.srv;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import com.infosupport.kc.registratie.domain.Cursist;
import com.infosupport.kc.registratie.domain.exceptions.OngeldigeCursistActivatieException;
import com.infosupport.kc.registratie.domain.exceptions.OngeldigeCursistRegistratieException;
import com.infosupport.kc.registratie.srv.dao.CursistDao;

@javax.inject.Singleton
public class CursistRegistratieManager {

	@Inject
	private CursistDao dao;

	private ActivatieCodeFactory activatieCodeFactory = new ActivatieCodeFactory();

	private Map<String, Cursist> activaties = new ConcurrentHashMap<String, Cursist>();

	/**
	 * Registers a new member (account is left inactive)
	 * 
	 * @param gebruikersnaam
	 *            gebruikersnaam van de nieuwe cursist
	 * @param email
	 *            emailadres van de cursist
	 * @return de activatiecode voor deze nieuwe registratie
	 * @throws OngeldigeCursistRegistratieException
	 *             wanneer de gebruikersnaam al in gebruik is
	 */
	public String registreer(String gebruikersnaam, String email) throws OngeldigeCursistRegistratieException {
		if (gebruikersnaam == null || gebruikersnaam.isEmpty() || email == null || email.isEmpty()) {
			throw new OngeldigeCursistRegistratieException();
		}
		Cursist bestaandeCursist = dao.getCursist(gebruikersnaam);
		if (bestaandeCursist != null) {
			throw new OngeldigeCursistRegistratieException();
		}
		Cursist cursist = new Cursist(gebruikersnaam, email);
		String activatieCode = activatieCodeFactory.createActivatieCode(cursist);
		dao.save(cursist);
		activaties.put(activatieCode, cursist);
		return activatieCode;
	}

	/**
	 * Activeert een cursist
	 * 
	 * @param gebruikersnaam
	 *            De gebruikersnaam van de cursist
	 * @param activatiecode
	 *            De bijbehorende activatiecode die verkregen is bij registreren
	 * @return
	 * @throws OngeldigeCursistActivatieException
	 *             Wanneer de gegeven gebruikersnaam onbekend is of de activatiecode
	 *             ongeldig is of wanneer de cursist reeds geactiveerd is.
	 */
	public Cursist activeer(String gebruikersnaam, String activatiecode) throws OngeldigeCursistActivatieException {
		if (!this.activaties.containsKey(activatiecode)) {
			throw new OngeldigeCursistActivatieException();
		}
		Cursist cursist = activaties.get(activatiecode);
		if (cursist == null || !cursist.getGebruikersnaam().equals(gebruikersnaam) || cursist.isActive()) {
			throw new OngeldigeCursistActivatieException();
		}
		cursist = dao.getCursist(gebruikersnaam);
		cursist.activate();
		this.activaties.remove(activatiecode);
		return cursist;
	}
	
	public void delete() {
		this.activaties.clear();
		dao.deleteCursisten();
	}

}
