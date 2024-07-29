package yp.com.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import yp.comUtilities.ExcelReader;
import yp.comUtilities.ExtentManager;

public class DriverSetup {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentReports report = ExtentManager.getInstance();	
    public static ExtentTest test;
    public static ExcelReader excel = new ExcelReader("C:\\Users\\rodara\\OneDrive - Capgemini\\Desktop\\Selenium_Work\\Orange_HRM\\src\\test\\resources\\ExcelFiles\\OrangeHRM.xlsx");

	@BeforeSuite
	public void BrowserSetUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\PropertyFiles\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file uploaded!!");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\PropertyFiles\\OR.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				or.load(fis);
				log.debug("OR file uploaded!!");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\rodara\\OneDrive - Capgemini\\Desktop\\Selenium_Work\\My_project\\src\\test\\resources\\ExecutableFiles\\chromedriver.exe");
				driver = new ChromeDriver();
			 }
			if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\ExecutableFiles\\msedgedriver.exe");
				driver = new EdgeDriver();
				log.debug("Edge Driver started successfully");
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\ExecutableFiles\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("FireFox Driver started successfully");
			}

			driver.get(config.getProperty("testURL"));
			log.debug("Navigated to: " + config.getProperty("testURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		}
	}

	//@AfterSuite
	public void BrowserTearDown() {
		if (driver != null) {
			driver.quit();
			log.debug("driver is closed");
		}
	}
}
