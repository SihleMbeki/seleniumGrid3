package testautomation.uiautomation.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
	
	public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public ThreadLocal<DesiredCapabilities> dc = new ThreadLocal<DesiredCapabilities>();
	
	public WebDriver getDriver() {
		return dr.get();
	}

	public void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

	public DesiredCapabilities getDesiredCapabilities() {
		return dc.get();
	}

	public void setDesiredCapabilities(DesiredCapabilities cap) {
		dc.set(cap);
	}

	@BeforeSuite
	public void suiteSetup() {
		System.out.println("suite setup");
	}

	@AfterSuite
	public void suiteCleanup() {
		System.out.println("suite Cleanup");
	}

}
