package com.infosupport.kc.registratie.srv;

import com.infosupport.kc.registratie.domain.Cursist;

/**
 * Class die een activiatiecode maakt voor een {@link Cursist}
 * 
 * @author infosupport
 * 
 */
public class ActivatieCodeFactory {

	/**
	 * Creert een activatiecode gebaseerd op de gebruikersnaam
	 * 
	 * @param cursist
	 *            cursist waarvoor een activatiecode gegenereerd moet worden
	 * @return the activatiecode
	 */
	public String createActivatieCode(Cursist cursist) {
		return "secret-" + cursist.getGebruikersnaam();
	}
}
