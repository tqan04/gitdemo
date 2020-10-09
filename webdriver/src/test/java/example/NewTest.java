package example;		

import org.openqa.selenium.Proxy;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("https://www.google.com/");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Google")); 		
		}	
		@BeforeTest
		public void beforeTest() {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\tqan\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("10.225.3.1:3128");
			proxy.setSslProxy("10.225.3.1:3128");//https proxy
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("proxy", proxy);
		    driver = new FirefoxDriver(options);  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	