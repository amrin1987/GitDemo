package RahulAcademy.E2EProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import E2EProject.Pages.MyntraHomePage;
import E2EProject.Pages.WomenslinkPage;

public class WomenslinkPageTest extends Base {

	WomenslinkPage womenslinkPage;
	MyntraHomePage homePage;
	UtilitiesFunctions uaction;

	public WomenslinkPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		intializeDriver();
		homePage = new MyntraHomePage(webdriver);
		womenslinkPage = new WomenslinkPage(webdriver);
		uaction = new UtilitiesFunctions(webdriver);
	}

	@Test
	public void kurtaSet() throws IOException, InterruptedException {
		homePage.womensLinkPage();
		uaction.moveElement(womenslinkPage.linkforKurtaSet());
	}

	//for loop and string manupulations and parsing
	@Test
	public void productsKurtaSet() throws IOException, Exception {
		
		kurtaSet();
		String pagenum = webdriver.findElement(By.xpath("//ul[@class='pagination-container']/li[2]")).getText();
		List<Integer> price12 = new ArrayList<Integer>();
		List<Integer> productToBuy = new ArrayList<Integer>();
		if (pagenum.matches("1"))
		{
			
			List<WebElement> productsPrices = webdriver.findElements(By.xpath("//div[@class='product-price']"));
			for (WebElement productPrice:productsPrices) {
				 String price=productPrice.getText().substring(4).split("R")[0];
				 int intPrice=Integer.parseInt(price);
				 //System.out.println(intPrice);
				 price12.add(intPrice);
		     }
			
			productToBuy=price12.subList(0, 3);
			
            System.out.println(productToBuy);
			}
		
	
	}
	//Dropdowns 
	@Test
	public void makeAnOrder() throws IOException, InterruptedException {
		kurtaSet();
		webdriver.findElement(By.xpath("//div[@class='sort-sortBy']/span[2]")).click();
		webdriver.findElement(By.xpath("//div[@class='sort-sortBy']/ul/li[5]")).click();
		Thread.sleep(2000);
		String pagenum = webdriver.findElement(By.xpath("//ul[@class='pagination-container']/li[2]")).getText();
		if (pagenum.matches("1"))
		{
			
			List<WebElement> products = webdriver.findElements(By.xpath("//li[@class='product-base']"));
			//int counter=products.size();
			for (int i=1;i<=4;i++) {
				String parentWindow=webdriver.getWindowHandle();
				
				products.get(i).click();
				Set<String> childTabs=webdriver.getWindowHandles();
				//now iterating on set
				Iterator<String> iterator=childTabs.iterator();
				while (iterator.hasNext()) {
					String childTab=iterator.next();
					if (!parentWindow.equals(childTab)) {
						webdriver.switchTo().window(childTab);
						webdriver.findElement(By.xpath("//div[@class='size-buttons-size-buttons']/div[1]")).click();
						webdriver.findElement((By.xpath("//div[@class='pdp-description-container']/div[3]/div/div[1]"))).click();
						webdriver.close();
						webdriver.switchTo().window(parentWindow);
					}
					
				}
				
				
			}
			
	}
	}
	
	@AfterMethod
	public void tearDown() {
		webdriver.quit();
	}
}

