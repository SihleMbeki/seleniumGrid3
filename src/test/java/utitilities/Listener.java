package utitilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testautomation.uiautomation.testing.Base;

public class Listener extends Base implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		WebDriverActions actions=new WebDriverActions(getDriver());
		Markup label=MarkupHelper.createLabel("Test Finished", ExtentColor.GREEN);
		try {
			System.out.println("Failed to take screenshot:"+actions.takeScreenshot());
		getTest().pass("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(actions.takeScreenshot()).build());
		}catch(Exception e) {
			
			e.printStackTrace();
			getDriver().close();
		}
		getTest().log(Status.PASS, label);
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		Markup label=MarkupHelper.createLabel("Test Finished", ExtentColor.RED);
		getTest().log(Status.FAIL, label);
		if(getDriver()!=null)
		getDriver().close();
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
