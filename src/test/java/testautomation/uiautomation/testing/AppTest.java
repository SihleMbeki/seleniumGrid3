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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Gmail;
import utitilities.ExtentReport;
import utitilities.TestData;

public class AppTest extends Base {

	public WebDriver driver;
	public DesiredCapabilities cap;

	@BeforeMethod
	public void setup(Method method) {
		System.out.println("setup");
	}

	@Test(dataProviderClass = TestData.class, dataProvider = "getTableData")
	public void test(String name, String lastname, String age) {
		test = ExtentReport.createTest("sample<not threaded");
		setTest(test);
		getTest().log(Status.PASS, "Test");
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
		gmail.close();
	}

	@AfterMethod
	public void teardown(Method method) {
		System.out.println("teardown");
	}

}
