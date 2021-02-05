package PageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import utitilities.WebDriverActions;

public class Page {
	protected WebDriverActions driver;

	public Page(WebDriver driver) {
		this.driver = new WebDriverActions(driver);
	}

}
