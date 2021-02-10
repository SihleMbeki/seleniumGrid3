package testautomation.uiautomation.testing;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import utitilities.ExtentReport;

public class Base {
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public ThreadLocal<DesiredCapabilities> dc = new ThreadLocal<DesiredCapabilities>();

	public static String folder;

	public static ThreadLocal<ExtentTest> tests = new ThreadLocal<ExtentTest>();

	public static ExtentTest getTest() {
		return tests.get();
	}

	public static void setTest(ExtentTest test) {
		tests.set(test);
	}
	
	
	public static WebDriver getDriver() {
		return (WebDriver) dr.get();
	}

	public String takeScreenshot(WebDriver driver) {
		Date date = new Date();
		String fileName =  ExtentReport.baseDirectory + "images\\"
				+ date.toString().replace(":", "_").replace(" ", "") + ".jpg";
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(fileName));
			return fileName;
		} catch (Exception E) {
			return fileName;
		}
	}

	public void setWebDriver(RemoteWebDriver driver) {
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
		Date today;
		today=new Date();
		folder=today.toString().replace(":", "").replace("-", "_");
		ExtentReport.createReport(folder);
		System.out.println("suite setup");
	}

	@AfterSuite
	public void suiteCleanup() {
		if(ExtentReport.reports!=null)
		ExtentReport.closeReport();
		System.out.println("suite Cleanup");
	}

}
