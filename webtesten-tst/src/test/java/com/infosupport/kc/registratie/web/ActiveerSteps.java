package com.infosupport.kc.registratie.web;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ActiveerSteps {

	public WebDriver webDriver;

	RegistreerPage registreerPage ;
	ActiveerPage activeerPage;

	@Given("^i am on the activeer page voor user (.*)")
	public void i_am_on_the_activeer_page(String username) throws Throwable {
		webDriver = WebDriverFactory.create();
		webDriver.get("http://localhost:8080/delete");
		registreerPage = new RegistreerPage(webDriver);
		activeerPage = new ActiveerPage(webDriver);
		//activeerPage.open(username);
		registreerPage.succesVolleRegistratie(username);
	}

	@When("^I enter username (.*)")
	public void i_enter_username_test(String username) throws Throwable {
		activeerPage.setGebruikersnaam(username);

	}

	@When("^I enter the activation code (.*)$")
	public void i_enter_the_activation_code_secret_test(String activatieCode) throws Throwable {
		activeerPage.setActivatiecode(activatieCode);
	}

	@When("^I submit the activation$")
	public void i_submit_the_activation() throws Throwable {
		activeerPage.submit();
	}

	@Then("^I should arrive at the Account page$")
	public void iShouldArriveAtTheAccountPage() throws Throwable {
		assertThat("Account page", is(equalTo(webDriver.getTitle())));
	}

	
	@After
	public void after() {
		webDriver.quit();
	}


}
