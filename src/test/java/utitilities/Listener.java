package utitilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testautomation.uiautomation.testing.Base;

public class Listener extends Base implements ITestListener {
	public static ThreadLocal<ExtentTest> tests = new ThreadLocal<ExtentTest>();

	public static ExtentTest getTest() {
		return tests.get();
	}

	public static void setTest(ExtentTest test) {
		tests.set(test);
	}

	@Override
	public void onFinish(ITestContext arg0) {
//		System.out.println("Listener class");
//		try {
//			if (getTest() == null)
//				System.out.println("Empty test");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		
//		WebDriverActions actions = new WebDriverActions(getDriver());
//		Markup label = MarkupHelper.createLabel("Test Finished", ExtentColor.GREEN);
//		getTest().log(Status.PASS, label);
//		try {
//			System.out.println("Failed to take screenshot:" + actions.takeScreenshot());
////			getTest().pass("Screenshot",
////					MediaEntityBuilder.createScreenCaptureFromPath(actions.takeScreenshot()).build());
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			if (getDriver() != null)
//				getDriver().close();
//		}
//		// ExtentReport.getTest().log(Status.PASS, label);
//		if (Base.getDriver() != null)
//			Base.getDriver().close();

	}

	@Override
	public void onStart(ITestContext arg0) {
	

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		Markup label = MarkupHelper.createLabel("Test Finished", ExtentColor.RED);
		getTest().log(Status.FAIL, label);
		getTest().log(Status.FAIL, arg0.getThrowable().getStackTrace().toString());
		 if(getDriver()!=null)
		 getDriver().close();

		 if(ExtentReport.reports!=null)
				ExtentReport.closeReport();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		ExtentTest test;
		test = ExtentReport.createTest(arg0.getMethod().getMethodName());
		setTest(test);

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		Markup label = MarkupHelper.createLabel("Test Finished", ExtentColor.GREEN);
		getTest().log(Status.PASS, label);
		
		try {
			getTest().pass("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(getDriver())).build());
		} catch (Exception e) {

			e.printStackTrace();

		}
		if (Base.getDriver() != null)
			Base.getDriver().close();
		
		

	}

}
