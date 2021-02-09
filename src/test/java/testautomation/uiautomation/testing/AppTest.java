package testautomation.uiautomation.testing;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import PageObjects.Gmail;
import utitilities.ExtentReport;
import utitilities.TestData;
import utitilities.WebDriverActions;

public class AppTest extends Base {

	public WebDriver driver;
	public DesiredCapabilities cap;

	@BeforeMethod
	public void setup(Method method) {
		System.out.println("setup");
	}

	@Test(dataProviderClass = TestData.class, dataProvider = "getTableData")
	public void login(String name, String lastname, String age) {
	 
		cap = new DesiredCapabilities();
		setDesiredCapabilities(cap);
		getDesiredCapabilities().setPlatform(Platform.ANY);
		getDesiredCapabilities().setBrowserName("chrome");

		ChromeOptions options = new ChromeOptions();
		options.merge(getDesiredCapabilities());

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getDesiredCapabilities());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setWebDriver(driver);
		Gmail gmail = new Gmail(getDriver());
		gmail.openURL();
		gmail.submitEmail("sihle.matanzima@gmail.com");
		
	}

	@AfterMethod
	public void teardown(Method method) {
		System.out.println("teardown");
	}

}
