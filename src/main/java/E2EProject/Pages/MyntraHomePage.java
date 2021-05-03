package E2EProject.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulAcademy.E2EProject.Base;

public class MyntraHomePage extends Base {

	

	public MyntraHomePage(WebDriver webdriver ) throws IOException {
		super();
		this.webdriver=webdriver;
		PageFactory.initElements(webdriver, this);
	}
	
	@FindBy(xpath="//body/div[@id='mountRoot']/div[1]/div[1]/main[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/picture[1]/img[1]")
    WebElement sareeLink;
	
	public WebElement sareeLink() {
		return sareeLink;
	}
	
	@FindBy(xpath = "//div[@class='desktop-user']")
	WebElement profile;
	// all links
	@FindBy(xpath = "//div[@class='desktop-navLinks']/div[1]")
	WebElement linkMen;

	@FindBy(xpath = "//div[@class='desktop-navLinks']/div[2]")
	WebElement linkWomen;

	@FindBy(xpath = "//div[@class='desktop-navLinks']/div[3]")
	WebElement linkKids;

	@FindBy(xpath = "//div[@class='desktop-navLinks']/div[4]")
	WebElement linkHomeLiving;

	@FindBy(xpath = "//div[@class='desktop-navLinks']/div[5]")
	WebElement linkOffers;
	


///methods
	public WebElement linkMenWorking() {
		return linkMen;
	}

	public WebElement linkWomenWorking() {
		return linkWomen;
	}
	
	

	public WebElement linkKidsWorking() {
		return linkKids;
	}

	public WebElement linkHomeLivingWorking() {
		return linkHomeLiving;
	}

	public WebElement linkOffersWorking() {
		return linkOffers;
	}

	public String verifyTitle() {
		String title= webdriver.getTitle();
		return title;
	}

	public SignUpPage signup() throws IOException {
		profile.click();
		WebElement loginButton = webdriver.findElement(By.xpath("//a[contains(text(),'login / Signup')]"));
		loginButton.click();
		return new SignUpPage(webdriver);

	}
	
	public int linksCount() {
	
		List<WebElement>linksList=webdriver.findElements(By.tagName("a"));

	    return (linksList.size());
	}
	
	 public WomenslinkPage womensLinkPage() throws IOException {
		 linkWomen.click();
		 return new WomenslinkPage(webdriver);
	 }
}
