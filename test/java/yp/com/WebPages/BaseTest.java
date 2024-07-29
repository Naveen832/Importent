package yp.com.WebPages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import yp.com.TestCases.DriverSetup;

public class BaseTest extends DriverSetup {
	
	// Generic method for click operation
		public void ClickMethod(String locator_name) {
			if(locator_name.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locator_name))).click();
				}else if(locator_name.endsWith("_XPATH")) {
					driver.findElement(By.xpath(or.getProperty(locator_name))).click();
				}else if(locator_name.endsWith("_ID")) {
					driver.findElement(By.id(or.getProperty(locator_name))).click();
				}else if(locator_name.endsWith("_Linktext")) {
					driver.findElement(By.linkText(or.getProperty(locator_name))).click();
				}
				//test.log(LogStatus.INFO, "Clicking on: "+ locator);;
		}

		// Generic Method for sendKeys
		public void SendKeysMethod(By locator, String text) {
			getElement(locator).sendKeys(text);
		}

		// Generic method for WebDriver waits
		public void webdriverwait(int time, By element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}

		// Generic method for inplicitlyWait
		public void ImplicitlyWait(int time) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		}

		// Method to return driver
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}

		// Methods for Explicit wait
		public void explicitWaitofElementPresense(int time, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			System.out.println("Waited: " + time);

		}
		
		public void explicitWaitofElementClickable(int time, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			System.out.println("Waited: " + time);
		}
		
		public void explicitWaitofElementvisibility(int time, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Waited: " + time);
		}

		// Geniric method to take screenshots
		public static void screenshot(WebDriver driver, String str) {
			String Screenshotname;
			File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(ss, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + str + ".jpeg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println();
			}
			System.out.println("Screenshot of " + str + " captured");
		}

		// Generic method for fluent wait
		public void FluentWait(int timeout, int polltime, By element) {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofSeconds(timeout));
			wait.pollingEvery(Duration.ofSeconds(polltime));
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			// System.out.println("waited");
		}
		
		// Generic method for Dropdown
		static WebElement dropdown;
		
		public void select(String locator, String value) {
			
			if(locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(or.getProperty(locator)));
			}else if(locator.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
			}else if(locator.endsWith("_ID")) {
				dropdown = driver.findElement(By.id(or.getProperty(locator)));
			}
			
			Select select = new Select(dropdown);
			select.deselectByVisibleText(value);
			//test.log(LogStatus.INFO, "Typing in: "+ locator + "of value: "+ value);
		}

}
