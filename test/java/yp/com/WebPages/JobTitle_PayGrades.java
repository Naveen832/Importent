package yp.com.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobTitle_PayGrades extends BaseTest {

	WebDriver driver;

	public JobTitle_PayGrades(WebDriver driver) {
		this.driver = driver;
	}

	By Admin_username = By.cssSelector(or.getProperty("Username_CSS"));
	By Admin_password = By.cssSelector(or.getProperty("Password_CSS"));
	By JobTitles_deopdown_wait = By.xpath(or.getProperty("Job_Titles_XPATH"));
	By JobTitle_TextBox = By.xpath(or.getProperty("JobTitle_Textbox_XPATH"));
	By JobDescription = By.xpath(or.getProperty("Job_Desc_XPATH"));
	By Notes_Input = By.xpath(or.getProperty("Notes_XPATH"));
	By Paygrade_Dropdown_wait = By.linkText(or.getProperty("Pay_Grade_Linktext"));
	By paygrade_name = By.xpath(or.getProperty("PayGrade_name_XPATH"));
	By Employeestatus_Dropdown_wait = By.linkText(or.getProperty("EmployeeStatus_Linktext"));
	By EmployeeStatus_TextBox = By.xpath(or.getProperty("EmployeeStatus_Text_XPATH"));
	By JobCategories_Dropdown_wait = By.linkText(or.getProperty("JobCategories_Linktext"));
	By JobCategories_Text = By.xpath(or.getProperty("JobCategories_Text_XPATH"));
	By WorkShifts_Dropdown_wait = By.linkText(or.getProperty("WorkShifts_Linktext"));
	By ShiftName = By.xpath(or.getProperty("ShiftName_Textbox_XPATH"));
	By StartTime = By.xpath(or.getProperty("Starting_Time_XPATH"));
	By EndTime = By.xpath(or.getProperty("Ending_Time_XPATH"));
	By workingHours = By.xpath(or.getProperty("TotalWorkingHours_XPATH"));
	By AssignEmployee = By.xpath(or.getProperty("EmployeeName_XPATH"));
	By ProfileName_tab = By.xpath(or.getProperty("ProfileName_XPATH"));
	By EmpName = By.xpath(or.getProperty("EmployeeName_XPATH"));
	By StartTime_Text = By.xpath(or.getProperty("StartTime_XPATH"));
	By EndTime_Text = By.xpath(or.getProperty("EndTime_XPATH"));
	
	public void Entercredentials(String UserName, String Password) {
		SendKeysMethod(Admin_username, UserName);
		SendKeysMethod(Admin_password, Password);
		ClickMethod("Login_btn_CSS");
	}

	public void SelectJobTitles() {
		ClickMethod("Admin_btn_Linktext");
		explicitWaitofElementvisibility(10, JobTitles_deopdown_wait);
		ClickMethod("Job_Titles_XPATH");
		ClickMethod("JobTitles_Linktext");
		ClickMethod("+Add_btn_CSS");
		SendKeysMethod(JobTitle_TextBox, "Senior Analyst");
		SendKeysMethod(JobDescription, "Im an Senior Analyst");
		ImplicitlyWait(10);
		String filepath = "C:\\Users\\rodara\\Downloads\\dummy_compressed.pdf";
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(filepath);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
		SendKeysMethod(Notes_Input, "Onboarding as senior analyst");
		screenshot(driver, "JobTitle");
		ClickMethod("Save_btn_CSS");
		log.debug("Job Title Created");
	}

	public void SelectpayGrades() {
		ClickMethod("Job_Titles_XPATH");
		explicitWaitofElementvisibility(10, Paygrade_Dropdown_wait);
		ClickMethod("Pay_Grade_Linktext");
		ClickMethod("+Add_btn_CSS");
		ImplicitlyWait(10);
		SendKeysMethod(paygrade_name, "Analyst");
		screenshot(driver, "PayGrades");
		ClickMethod("Save_btn_CSS");
		log.debug("Pag Grades created");
	}

	public void SelectEmployeeStatus() {
		ClickMethod("Job_Titles_XPATH");
		explicitWaitofElementvisibility(10, Employeestatus_Dropdown_wait);
		ClickMethod("EmployeeStatus_Linktext");
		ClickMethod("+Add_btn_CSS");
		ImplicitlyWait(10);
		SendKeysMethod(EmployeeStatus_TextBox, "Full-Time");
		ClickMethod("Save_btn_CSS");
		log.debug("Employee status created");
	}

	public void Selctjobcategories() {
		ClickMethod("Job_Titles_XPATH");
		explicitWaitofElementvisibility(10, JobCategories_Dropdown_wait);
		ClickMethod("JobCategories_Linktext");
		ClickMethod("+Add_btn_CSS");
		ImplicitlyWait(10);
		SendKeysMethod(JobCategories_Text, "Devops");
		screenshot(driver, "Job_Categories");
		ClickMethod("Save_btn_CSS");
		log.debug("Jobn category created");
	}

	public void SelectWorkShifts() {
		ClickMethod("Admin_btn_Linktext");
		ClickMethod("Job_Titles_XPATH");
		explicitWaitofElementvisibility(10, WorkShifts_Dropdown_wait);
		ClickMethod("WorkShifts_Linktext");
		ClickMethod("+Add_btn_CSS");
		ImplicitlyWait(10);
		SendKeysMethod(ShiftName,  "Shift99");
		ClickMethod("Starting_Time_XPATH");
		ClickMethod("StartTime_Increase_XPATH");
		ClickMethod("Ending_Time_XPATH");
		ClickMethod("EndTime_Increase_XPATH");
		String defaultTime = "8";
		String totalTime = driver.findElement(workingHours).getText();
		if (defaultTime.equals(totalTime)) {
			System.out.println("Working hours are " + defaultTime);
			log.debug("Login Successful" + defaultTime);
		}
		String Emp_name = driver.findElement(ProfileName_tab).getText();
		SendKeysMethod(EmpName, Emp_name);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		WebElement AssignEmp_Textbox = driver.findElement(AssignEmployee);
		AssignEmp_Textbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		ClickMethod("Save_btn_CSS");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
		}
		String Start_time = driver.findElement(StartTime_Text).getText();
		String End_time = driver.findElement(EndTime_Text).getText();
		if(Start_time.equals("10:00 AM") || End_time.equals("06:00 PM")) {
			System.out.println("Shift Validation Success");
		}
		log.debug("Work shift created and validated successfully");
	}
	
	public void DeleteWorkShift() {
		ClickMethod("Delete_btn_XPATH");
		screenshot(driver, "DeleteShift_popup");
		ClickMethod("ConfirmDelete_XPATH");
	}
}
