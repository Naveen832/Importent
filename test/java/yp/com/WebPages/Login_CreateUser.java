package yp.com.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_CreateUser extends BaseTest {

	WebDriver driver;

	public Login_CreateUser(WebDriver driver) {
		this.driver = driver;
	}

	By Admin_username = By.cssSelector(or.getProperty("Username_CSS"));
	By Admin_password = By.cssSelector(or.getProperty("Password_CSS"));
	By Usermanagement_deopdown_wait = By.xpath(or.getProperty("UserManagement_btn_XPATH"));
	By user_Role = By.xpath(or.getProperty("User_role_XPATH"));
	By Status = By.xpath(or.getProperty("Status_btn_XPATH"));
	By ProfileName_tab = By.xpath(or.getProperty("ProfileName_XPATH"));
	By EmpName = By.xpath(or.getProperty("EmployeeName_XPATH"));
	By username = By.xpath(or.getProperty("UserName_XPATH"));
	By password = By.xpath(or.getProperty("Password_XPATH"));
	By confirm_PW = By.xpath(or.getProperty("Confirm_PW_XPATH"));
	By userSearch = By.xpath(or.getProperty("UserName_Textbox_XPATH"));
	By filtered_User = By.xpath(or.getProperty("UserName_Feild_XPATH"));
	By WaitFor_RecordsFound = By.xpath(or.getProperty("RecordsFound_P_XPATH"));
	By WaiFor_LogoutBtn = By.linkText(or.getProperty("Logout_Linktext"));

	public void Entercredentials(String UserName, String Password) {
		SendKeysMethod(Admin_username, UserName);
		SendKeysMethod(Admin_password, Password);
		screenshot(driver, "LoginCredentials");
		ClickMethod("Login_btn_CSS");
		log.debug("Login Successful");
	}

	public void CreateUserForm() {
		ClickMethod("Admin_btn_Linktext");
		explicitWaitofElementClickable(20, Usermanagement_deopdown_wait);
		ClickMethod("UserManagement_btn_XPATH");
		ClickMethod("User_btn_Linktext");
		ClickMethod("+Add_btn_CSS");
		ImplicitlyWait(10);
		ClickMethod("User_role_XPATH");
		ImplicitlyWait(10);
		WebElement UserRole_dropdown = driver.findElement(user_Role);
		UserRole_dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		ClickMethod("Status_btn_XPATH");
		ImplicitlyWait(10);
		WebElement Status_dropdown = driver.findElement(Status);
		Status_dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		String p_name = driver.findElement(ProfileName_tab).getText();
		SendKeysMethod(EmpName, p_name);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		WebElement EmpName_Textbox = driver.findElement(EmpName);
		EmpName_Textbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		SendKeysMethod(username, "Pheobe");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		SendKeysMethod(password, "admin@345");
		log.debug("password entered");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		SendKeysMethod(confirm_PW, "admin@345");
		log.debug("Confirm p entered");
		screenshot(driver, "New_User_Form");
		ClickMethod("Save_btn_CSS");
		log.debug("User Added Successfully");
	}

	public void SearchNewUser() {
		explicitWaitofElementvisibility(20, WaitFor_RecordsFound);
		SendKeysMethod(userSearch, "Pheobe");
		ClickMethod("Search_btn_CSS");
		WebElement FilteredUser = driver.findElement(filtered_User);
		String UserName_String = FilteredUser.getText();
		if (UserName_String.equals("Admin1")) {
			System.out.println("User Created Successfully");
			log.debug(" New User Validation Successful");
		}
	}

	public void UserLogout() {
		ClickMethod("Profile_Tab_XPATH");
		explicitWaitofElementClickable(10, WaiFor_LogoutBtn);
		ClickMethod("Logout_Linktext");
		log.debug("Logged out Successfully");
	}
}
