package yp.com.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import yp.com.WebPages.JobTitle_PayGrades;

public class JobTitles_PayGrades_Test extends DriverSetup {

	@Test(dataProvider = "Exceldata")
	public void Scenario_2(String UserName, String Password) {
		JobTitle_PayGrades obj = new JobTitle_PayGrades(driver);
		obj.Entercredentials(UserName, Password);
		obj.SelectJobTitles();
		obj.SelectpayGrades();
		obj.SelectWorkShifts();
		obj.DeleteWorkShift();
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
