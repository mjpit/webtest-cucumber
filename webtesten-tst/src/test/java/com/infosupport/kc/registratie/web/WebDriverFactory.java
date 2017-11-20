package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverFactory {
	public static WebDriver create() {
		return new HtmlUnitDriver(true);
	}
}
