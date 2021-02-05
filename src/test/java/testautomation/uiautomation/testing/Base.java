package testautomation.uiautomation.testing;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import utitilities.ExtentReport;

public class Base {
	
	public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public ThreadLocal<DesiredCapabilities> dc = new ThreadLocal<DesiredCapabilities>();
	public ThreadLocal<ExtentTest> tests = new ThreadLocal<ExtentTest>();
	ExtentTest test;
	public static String folder;
	
	public WebDriver getDriver() {
		return dr.get();
	}
	public ExtentTest getTest() {
		return tests.get();
	}


	public void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}
	public void setTest(ExtentTest test) {
		tests.set(test);
	}

	public DesiredCapabilities getDesiredCapabilities() {
		return dc.get();
	}

	public void setDesiredCapabilities(DesiredCapabilities cap) {
		dc.set(cap);
	}

	@BeforeSuite
	public void suiteSetup() {
		Date today;
		today=new Date();
		folder=today.toString().replace(":", "").replace("-", "_");
		ExtentReport.createReport(folder);
		System.out.println("suite setup");
	}

	@AfterSuite
	public void suiteCleanup() {
		ExtentReport.closeReport();
		System.out.println("suite Cleanup");
	}

}
