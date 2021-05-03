package E2EProject.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulAcademy.E2EProject.Base;

public class WomenslinkPage  extends Base{
	
	public WomenslinkPage(WebDriver webdriver)throws IOException {
		
		super();
		this.webdriver=webdriver;
		PageFactory.initElements(webdriver, this);
	}

	@FindBy(xpath="//div[@class='myx-base']/div[6]/div/div/div/div/div[2]")
	WebElement kurtaSet;
		
	public WebElement linkforKurtaSet() {
		return kurtaSet;
	}
}
