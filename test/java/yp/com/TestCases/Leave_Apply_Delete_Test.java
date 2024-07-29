package yp.com.TestCases;

import org.testng.annotations.Test;

import yp.com.WebPages.Leave_Apply_Delete;

public class Leave_Apply_Delete_Test extends DriverSetup{
	@Test
	public void Scenario4() {
		Leave_Apply_Delete obj= new Leave_Apply_Delete(driver);
		obj.Applyleave();
	}

}
