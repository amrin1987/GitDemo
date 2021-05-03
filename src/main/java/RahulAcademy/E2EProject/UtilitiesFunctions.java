package RahulAcademy.E2EProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class UtilitiesFunctions extends Base{
	
	
	
	Actions action;
	UtilitiesFunctions(WebDriver webdriver){
		super();
		action=new Actions(webdriver);
		this.webdriver=webdriver;
	}
	
	//Scroll down page using action class
	public void scrollDown() {
	
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
	
	//scrolling up page
	public void scrollUp() {
		
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}
	
	public void moveElement(WebElement target) {
		
		//WebDriverWait wait=new WebDriverWait(webdriver,20);
		//wait.FIVE_HUNDRED_MILLIS;
		action.moveToElement(target).click().build().perform();
	}

	public void takesScreenShot(String filePath) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) webdriver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(filePath);
		FileUtils.copyFile(srcFile, destFile);
		
	}
	
	
}
