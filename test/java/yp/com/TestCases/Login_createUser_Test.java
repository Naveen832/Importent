package yp.com.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import yp.com.WebPages.Login_CreateUser;

public class Login_createUser_Test extends DriverSetup {

	@Test(dataProvider = "Exceldata")
	public void Scenario_1(String UserName, String password) {

		Login_CreateUser obj = new Login_CreateUser(driver);
		obj.Entercredentials(UserName, password);
		obj.CreateUserForm();
		obj.SearchNewUser();
		obj.UserLogout();
	}

	@DataProvider
	public Object[][] Exceldata() {

		String sheetname = "LogIn_data";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
			}
		}
		return data;
	}

}
