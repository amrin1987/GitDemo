package E2EProject.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulAcademy.E2EProject.Base;

public class SignUpPage extends Base {
	
	public SignUpPage(WebDriver webdriver ) throws IOException {
		super();
		this.webdriver=webdriver;
		PageFactory.initElements(webdriver, this);
	}
	@FindBy(xpath="//div[@class='mobileInputContainer']/div[1]/input")
     WebElement phnnumber;
	
	public WebElement phnNum() {
		return phnnumber;
	}
	
	@FindBy(xpath="//div[@class='mobileInputContainer']/div[3]")
	WebElement continueButton;
	
	public WebElement button() {
		return continueButton;
	}
	
	@FindBy(xpath="//div[@class='bottomeLink']/span")
	WebElement password;
	
	public WebElement passWord() {
		return password;
	}
	@FindBy(xpath="//*[@id=\"reactPageContent\"]/div/div/form/div/div[2]/input")
	WebElement newPassword;
	
	public WebElement newpassWord() {
		return newPassword;
	}
	@FindBy(xpath="//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")
	WebElement loginButton;
	
	public WebElement login() {
		return loginButton;
		
	}
}
