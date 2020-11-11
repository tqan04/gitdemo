package example;		

import org.openqa.selenium.Proxy;

import java.io.IOException;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;	
import org.testng.annotations.DataProvider;

public class NewTest {		
	    private WebDriver driver;	
	    
	    @DataProvider
	    public static Object[][] url() {
	    	System.out.println("DataProvider:url");
	        return new Object[][] {{"http://www.google.com", "Google"}, {"http://www.bing.com", "Bing"}, {"http://www.amazon.com", "Amazon"}};
	    }

	    @DataProvider
	    public static Object[][] dataFromExcel() throws IOException{
	    	System.out.println("DataProvider:dataFromExcel");
	    	return ReadExcel.readDataFromExcel("data\\url.xls", "Sheet1");
	    }
	    
		@Test(groups={"_easy"},dataProvider="url")				
		public void testDataProvider(String url, String ExpectedTitle) {	
			System.out.println("Test:testDataProvider");
			driver.get(url);  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains(ExpectedTitle)); 		
		}
		@Test(groups={"easy"},dataProvider="dataFromExcel")				
		public void testDataProviderExcel(String url, String ExpectedTitle) {	
			System.out.println("Test:testDataProviderExcel");
			driver.get(url);  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains(ExpectedTitle)); 		
		}		
		
		@BeforeTest(alwaysRun=true)
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
		@AfterTest(alwaysRun=true)
		public void afterTest() {
			System.out.println("afterTest");
			driver.quit();			
		}		
}	
