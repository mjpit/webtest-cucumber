package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistreerPage extends PageBase {

	@FindBy(name = "registratieGebruikersnaam")
	private WebElement gebruikersnaam;

	@FindBy(name = "registratieEmail")
	private WebElement inputEmail;

	@FindBy(id = "registreer")
	private WebElement submit;

	public RegistreerPage(WebDriver webDriver) {
		super(webDriver);

	}

	public void setGebruikersnaam(String naam) {
		gebruikersnaam.sendKeys(naam);
	}

	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}

	public void submit() {
		submit.submit();
	}

	public void succesVolleRegistratie(String username) {
		//webDriver = WebDriverFactory.create();
		//webDriver = new ChromeDriver();
		webDriver.get("http://localhost:8080/delete");
		webDriver.get("http://localhost:8080/");
		wait.until(ExpectedConditions.titleIs("Registreer cursist"));
		setGebruikersnaam(username);
		setEmail(username + "@mail.com");
		submit();
	}
}
