package yp.com.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Leave_Apply_Delete extends BaseTest {

	WebDriver driver;

	public Leave_Apply_Delete(WebDriver driver) {
		this.driver = driver;
	}

	By Admin_username = By.cssSelector(or.getProperty("Username_CSS"));
	By Admin_password = By.cssSelector(or.getProperty("Password_CSS"));
	By EmpName_textbox = By.xpath(or.getProperty("EmployeeName_XPATH"));
	By leaveType = By.xpath(or.getProperty("LeaveType_XPATH"));
	By Calendar = By.xpath(or.getProperty("Calendar_XPATH"));
	By Partial_days = By.xpath(or.getProperty("patialDays_XPATH"));
	By comments = By.xpath(or.getProperty("Comments_XPATH"));
	By Leave_tab = By.xpath(or.getProperty("Leave_XPATH"));

	public void Applyleave() {
		explicitWaitofElementClickable(20, Leave_tab);
		ClickMethod("Leave_XPATH");
		ClickMethod("AssignLeave_Linktext");
		SendKeysMethod(EmpName_textbox, "Test1235 hey heyi");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		WebElement Empname_Textbox = driver.findElement(EmpName_textbox);
		Empname_Textbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		ClickMethod("LeaveType_XPATH");
		WebElement LeaveType_dropdown = driver.findElement(leaveType);
		LeaveType_dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		//ClickMethod("DatePicker_From_Xpath");
		ClickMethod("CalanderFrom_XPATH");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		ClickMethod("MonthChange_XPATH");
//		WebElement datePicker = driver.findElement(Calendar);
//
//		List<WebElement> days = datePicker.findElements(By.xpath("//div[@class='oxd-calendar-dates-grid']"));
//		for (WebElement day : days) {
//			if ((day.getText()).equals("RequiredDate")) {
//				day.click();
//				break;
//			}
//		}
		ClickMethod("Date_From_XPATH");
		log.debug("From date selected");
		ClickMethod("DatePicker_To_XPATH");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		ClickMethod("Date_To_XPATH");
		log.debug("To date selected");
		ClickMethod("patialDays_XPATH");
		WebElement partialDays_Textbox = driver.findElement(Partial_days);
		partialDays_Textbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		SendKeysMethod(comments, "Leave Request applied");
		ClickMethod("Save_btn_CSS");
		log.debug("Leave request created");
	}
}
