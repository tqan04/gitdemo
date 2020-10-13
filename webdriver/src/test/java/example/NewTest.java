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
		@Test(groups={"easy"})				
		public void testEasy() {	
			System.out.println("Test");
			driver.get("https://www.google.com/");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Google")); 		
		}	
		@BeforeTest(groups={"easy"})
		public void beforeTest() {
			System.out.println("beforeTest");
			System.setProperty("webdriver.gecko.driver","C:\\Users\\tqan\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("10.225.3.1:3128");
			proxy.setSslProxy("10.225.3.1:3128");//https proxy
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("proxy", proxy);
		    driver = new FirefoxDriver(options);  
		}		
		@AfterTest(groups={"easy"})
		public void afterTest() {
			System.out.println("afterTest");
			driver.quit();			
		}		
}	