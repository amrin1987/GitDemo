package RahulAcademy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListnerTest extends Base implements ITestListener {

	ExtentReports extents = ExtentReportsE2E.getReportObject();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = extents.createTest(result.getMethod().getMethodName());
		{
			System.out.println(result.getName() + " test case started");
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Passed");
		ITestListener.super.onTestSuccess(result);
		{
			System.out.println("The name of the testcase passed is :" + result.getName());

		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
        System.out.println("The Name of method failed is "+result.getMethod().getMethodName());
        
        String methodName=result.getMethod().getMethodName();
        ITestContext context = result.getTestContext();
        WebDriver webdriver = (WebDriver)context.getAttribute("webdriver");
        try {
			takesScreenShot(methodName, webdriver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extents.flush();
		ITestListener.super.onFinish(context);
	}

}
