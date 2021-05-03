package RahulAcademy.E2EProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import E2EProject.Pages.MyntraHomePage;

public class MyntraHomePageTest extends Base {

	MyntraHomePage homePage;
	UtilitiesFunctions uaction;
	

	public MyntraHomePageTest() {
		super();
		
	}

	@BeforeMethod
	public void setup() throws IOException {
		intializeDriver();
		homePage = new MyntraHomePage(webdriver);
		uaction=new UtilitiesFunctions(webdriver);
	}

	@Test
	public void verifyTitle() {
		String title = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		String actual = homePage.verifyTitle();
		Assert.assertEquals(actual, title);
		System.out.println("changed this line for checking github1");
		System.out.println("changed this line for checking github2");
	}
	@Test
	public void linksCount() {
		
		int actualount=homePage.linksCount();
	    int expectedCount=470;
	    
	    SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(actualount, expectedCount);
		softAssertion.assertAll();
	}

	@Test
	public void verifyLink() {
		homePage.linkWomenWorking().click();
		//https response code
	}
	
	@AfterMethod
	public void tearDown() {
		webdriver.quit();
	}
	
	@Test
	public void scrollDownSaree() {
		//action.scrollDown();
		uaction.moveElement(homePage.sareeLink());
	}
	
	
}
