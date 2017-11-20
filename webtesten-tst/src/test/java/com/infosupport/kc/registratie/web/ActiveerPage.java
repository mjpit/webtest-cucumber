package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActiveerPage extends PageBase {

	@FindBy(name = "activatieGebruikersnaam")
	private WebElement gebruikersnaam;

	@FindBy(name = "activatiecode")
	private WebElement inputActivatiecode;

	@FindBy(id = "activeer")
	private WebElement submit;

	public ActiveerPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void setGebruikersnaam(String naam) {
		gebruikersnaam.sendKeys(naam);
	}

	public void setActivatiecode(String activatiecode) {
		inputActivatiecode.sendKeys(activatiecode);
	}

	public void submit() {
		submit.submit();
	}

	public void open(String username) {
		RegistreerPage registreerPage = new RegistreerPage(webDriver);
		registreerPage.succesVolleRegistratie(username);

	}
}
