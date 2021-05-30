package classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestNG_util extends AbstractTestNGCucumberTests{
public static WebDriver driver=null;
public static Scenario sc;
	
     @BeforeTest
	 @Parameters({"Browser"})
	  public   void beforeTest(String browser) {
		
	
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
				 driver = new ChromeDriver();
				// driver.get("https://www.facebook.com");
				
		  }
		  else if(browser.equalsIgnoreCase("IE"))
		  {
			  WebDriverManager.iedriver().setup();
				 driver = new InternetExplorerDriver();
		  }
		  else if(browser.equalsIgnoreCase("Firefox"))
		  {
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
		  }
		  else if(browser.equalsIgnoreCase("headless"))
		  {
			  WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
				
			    ChromeOptions options = new ChromeOptions();
			    options.setHeadless(true);
			    driver = new ChromeDriver(options);
		  }
		  else
		  {
			  System.out.println("Oops the browser is not supported!!!");
		  }
		  
		 
	  }
	
	@AfterTest
	@Parameters({"Browser"})
	public void after_the_test()
	{
		//driver.close();
		driver.quit();
		}
	
	@AfterSuite
	@Parameters({"Browser"})
	public void Execution_done()
	{
		System.out.println("done");
		/*utils.Mail.Sendmail("chaitalirajput45@gmail.com","chaitali@7040","chaitalirajput45@gmail.com",
					"My 1st Automation email!!", 
					"test-output\\Spark\\ExtentSpark.html");*/
	}

	
	


}
