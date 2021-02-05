package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Gmail extends Page {

	@FindBy(css = "#identifierId")
	public WebElement email;

	@FindBy(xpath = "//span[text()='Next']/..")
	public WebElement next;

	public Gmail(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public void openURL() {
		driver.getDriver().get("http://gmail.com");
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.getDriver().manage().window().maximize();
	}
	
	public void close() {
		driver.getDriver().close();
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
