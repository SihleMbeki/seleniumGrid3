package utitilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testautomation.uiautomation.testing.Base;

public class WebDriverActions extends Base{


	public boolean sendKeys(WebElement element, String value) {

		try {
			element.sendKeys(value);
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}

	}

	public boolean scrollUpByPixels() {
		try {
			((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,110)");
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}



	public boolean scrollToElement(String xpath) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block:'Center'});", xpath);
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean scrollDownByPixels() {
		try {
			((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,-110)");
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean pressEnter() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean switchToDefaultContent() {
		try {
			getDriver().switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean switchToFrame(String frame) {
		try {
			getDriver().switchTo().frame(frame);
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean switchToSecondTab(String frame) {
		try {
			Set winids = getDriver().getWindowHandles();
			Iterator iterate = winids.iterator();
			System.out.println(iterate.next()); // first window
			String second_window = (String) iterate.next(); // second window
			getDriver().switchTo().window(second_window);
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean waitForVisible(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean waitClickable(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean selectDropDown(WebElement element, String option) {
		try {
			Select selection = new Select(element);
			selection.selectByVisibleText(option);
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}

	public boolean contextClick(WebElement element) {
		try {
			Actions action = new Actions(getDriver());
			action.contextClick(element).perform();
			return true;
		} catch (Exception e) {
			System.out.println("No such Element");
			return false;
		}
	}
	
}
