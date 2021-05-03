package RahulAcademy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;


public class Base {

	Properties prop;
	String filePath = "C:\\Users\\wahid\\eclipse-workspace_Selenium\\E2EProject\\src\\main\\java\\RahulAcademy\\E2EProject\\config.properties";
	public static String FILE_PATH= "C:\\Users\\wahid\\Desktop\\E2E Project ScreenShots\\Screenshots\\"; 
	private static String DRIVER_PATH = "C:\\Users\\wahid\\Documents\\chromedriver.exe";
	public WebDriver webdriver ;
	
	
public Base() {
		
		
			prop = new Properties();
			FileInputStream inStream = null;
			try {
				inStream = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(inStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
//intializeDriver
	public WebDriver intializeDriver() throws IOException {
		
		if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
			webdriver= new ChromeDriver();
			webdriver.get(prop.getProperty("url"));
			webdriver.manage().window().maximize();
			webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
		return webdriver;
	}

	public void takesScreenShot(String methodName,WebDriver webdriver) throws IOException {
		
		TakesScreenshot screenshot=(TakesScreenshot) webdriver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+methodName+ ".jpeg";
		FileUtils.copyFile(srcFile, new File (destFile));
}
	
	
}
	
	
	

