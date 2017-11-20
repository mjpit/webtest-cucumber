
package com.infosupport.kc.registratie.web;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistratieWebTest {

	private WebDriver webDriver;

	@Before
	public void before() {
		webDriver = WebDriverFactory.create();
	}

	@After
	public void after() {
		webDriver.quit();
	}

	@Test
	public void registreer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		registreerHappyFlow(naam);

		assertEquals("Activeer cursist", webDriver.getTitle());
	}

	@Test
	public void activeer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		registreerHappyFlow(naam);

		ActiveerPage activeerPage = new ActiveerPage(webDriver);

		activeerPage.setGebruikersnaam(naam);

		activeerPage.setActivatiecode("secret-" + naam);

		activeerPage.submit();

		assertEquals("Account page", webDriver.getTitle());
	}

	private void registreerHappyFlow(String naam) {

		webDriver.get("http://localhost:8080");

		RegistreerPage registreerPage = new RegistreerPage(webDriver);

		registreerPage.setGebruikersnaam(naam);

		registreerPage.setEmail(naam);

		registreerPage.submit();

		assertEquals("Activeer cursist", webDriver.getTitle());
	}

	@Test
	public void legeRegistratie() throws Exception {
		webDriver.get("http://localhost:8080");

		RegistreerPage registreerPage = new RegistreerPage(webDriver);

		registreerPage.submit();

		assertEquals("Ongeldige registratie", registreerPage.getFoutlabelText());
	}
}
