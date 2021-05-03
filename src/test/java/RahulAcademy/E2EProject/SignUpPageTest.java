package RahulAcademy.E2EProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import E2EProject.Pages.MyntraHomePage;
import E2EProject.Pages.SignUpPage;

public class SignUpPageTest extends Base{
	
	SignUpPage signupPage;
    MyntraHomePage homePage;
    UtilitiesFunctions action;
    

	public SignUpPageTest() {
		super();
	}

@BeforeMethod
	public void setup() throws IOException {
		intializeDriver();
		homePage = new MyntraHomePage(webdriver);
		homePage.signup();
		signupPage= new SignUpPage(webdriver);
		action=new UtilitiesFunctions(webdriver);
	}
	@Test
	public void signup() throws IOException, InterruptedException {
		String actualURL=webdriver.getCurrentUrl();
		//String accountNotExist="C:\\Users\\wahid\\Desktop\\E2E Project ScreenShots\\screenshot1.jpeg";
		signupPage.phnNum().sendKeys(prop.getProperty("phnNum"));
		signupPage.button().click();
		//Thread.sleep(60000);
		signupPage.passWord().click();
		signupPage.newpassWord().sendKeys(prop.getProperty("newPassword"));
		signupPage.login().click();
		
		//action.takesScreenShot(accountNotExist);
		String expectedURL=webdriver.getCurrentUrl();
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(actualURL, expectedURL);
		softAssertion.assertAll();
	}
	
	@AfterMethod
	public void teraDown() {
		webdriver.quit();
	}
	
	
	
}
