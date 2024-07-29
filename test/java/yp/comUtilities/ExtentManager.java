package yp.comUtilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	public static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			extent = new ExtentReports(
					System.getProperty("user.dir") + "\\target\\surefire-reports\\ExtentReports\\Extent.html", true,
					DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\ExtentConfigFile\\ReportConfigFile.xml"));
		}
		return extent;
	}

}
