package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testautomation.uiautomation.testing.Base;

public class Gmail extends Page {

	@FindBy(css = "#identifierId")
	public WebElement email;

	@FindBy(xpath = "//span[text()='Next']/..")
	public WebElement next;

	public Gmail() {
		super();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(Base.getDriver(), 10);
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	public void openURL() {
		driver.getDriver().get("http://gmail.com");
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.getDriver().manage().window().maximize();
	}

	public void submitEmail(String email) {
		this.email.sendKeys(email);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		next.click();
		
	}

}
