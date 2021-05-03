package RahulAcademy.E2EProject;

import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsE2E {

	static ExtentReports extents;
	
	
	@BeforeTest
	public static  ExtentReports getReportObject() {
		String filepath="C:\\Users\\wahid\\Desktop\\E2E Project ScreenShots\\E2EProject Test Results.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(filepath);
		reporter.config().setReportName("E2E Project Report");
		reporter.config().setDocumentTitle("Test  Results");
		
		extents= new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Tester", "Amrin");
		return extents;
	}
	
	
	
}
