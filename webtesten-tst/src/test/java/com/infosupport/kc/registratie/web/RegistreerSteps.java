package com.infosupport.kc.registratie.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import cucumber.api.PendingException;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistreerSteps {

	public WebDriver webDriver;
	public RegistreerPage registreerPage;

	@Given("^I have a browser open$")
	public void iHaveABrowserOpen() {
		webDriver = WebDriverFactory.create();

	}

	@When("^I navigate to the home page$")
	public void iNavigateToTheHomePage() {
		webDriver.get("http://localhost:8080/");
		registreerPage = new RegistreerPage(webDriver);
}

	@And("^I enter the user name (.*)$")
	public void iEnterAUsername(String username) {
		registreerPage.setGebruikersnaam(username);
	}

	@And("^I enter the email (.*)$")
	public void iEnterTheEmai(String email) {
		registreerPage.setEmail(email);
	}

	@And("^I submit the registration$")
	public void iSubmitTheRegistration() {
		registreerPage.submit();
	}

	@Then("^I should arrive at the page titled (.*)$")
	public void iShouldArriveAtTheActivationPage(String pageTitle) {
		assertThat(webDriver.getTitle(), is(equalTo(pageTitle)));
	}
	
	@Then("^we are still at the page titled \"([^\"]*)\"$")
	public void we_are_still_at_registration_page(String pageTitle) throws Throwable {
		assertThat(webDriver.getTitle(), is(equalTo(pageTitle)));
	}

	@Then("^I should get error message (.*)$")
	public void i_should_get_error_message_Ongeldige_registratie(String foutmelding) throws Throwable {
	    
		assertThat(registreerPage.getFoutlabelText(), is (equalTo(foutmelding)));
		
	}

	
	@After
	public void after() {
		webDriver.quit();
	}

	@Given("^there are no registered users$")
	public void thereAreNoRegisteredUsers() throws Throwable {
		webDriver.get("http://localhost:8080/delete");
	}
}
