package PageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utitilities.WebDriverActions;

public class Page {
	protected WebDriverActions driver;

	public Page() {
		this.driver = new WebDriverActions();
	}

}
