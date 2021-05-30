package classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.Scenario;


public class End_Page {
	WebDriver driver;
	@FindBy (xpath="//h2[text()='Order Details']")
	private WebElement Heading;
	
	@FindBy (xpath="//strong[(text()='Success!')]")
	private WebElement success_message;
	
	@FindBy (xpath="//button[@type='button']")
	private WebElement logout_btn;
	
	@FindBy (id="email")
	private WebElement email;

	@FindBy (id="Address")
	private WebElement Address;
	
	@FindBy (id="cost")
	private WebElement Total_cost;
	
    @FindBy (id="TotalItems")
	private WebElement Products;
    
    
public End_Page(WebDriver driver) {
		
		this.driver = driver;
		 PageFactory.initElements(driver,this);
		
	}
Utilities util = new Utilities();

public void Check_if_heading_is_displayed(Scenario sc)
{
	
	try
	{
		if(Heading.isDisplayed())
           {
               System.out.println("Heading of the page is " + Heading.getText());
                  sc.write("Pass: HEading is displayed");
                  byte[] screenshot = util.Take_A_ScreenShot(driver);
  				sc.embed(screenshot, "image/png",sc.getName());
               }
		else
		{
			System.out.println("Exception page heading is displayed");
			byte[] screenshot = util.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png",sc.getName());
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

public void verify_success(Scenario sc)
{
	try {
		if(success_message.isDisplayed())
		{
			System.out.println("Pass: The success message is displayed");
			sc.write("Pass: The successmessage is displayed");
			byte[] screenshot = util.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png",sc.getName());
		}
		Assert.assertTrue(success_message.getText().contains("Success!"));
		
	}
	catch(Exception ex)
	{
		System.out.println("Exception page Message is displayed");
		byte[] screenshot = util.Take_A_ScreenShot(driver);
		sc.embed(screenshot, "image/png",sc.getName());
	}
	
}
 public void verify_if_the_details_are_displayed(Scenario sc)
 {
	 try {
			if(email.isDisplayed())
			{
				System.out.println("Pass: The email is displayed");
				sc.write("Pass: The email is displayed");
				byte[] screenshot = util.Take_A_ScreenShot(driver);
				sc.embed(screenshot, "image/png",sc.getName());
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception email is displayed");
			byte[] screenshot = util.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png",sc.getName());
		}
	 
	 try {
			if(Address.isDisplayed())
			{
				System.out.println("Pass: The address is displayed");
				sc.write("Pass: The address is displayed");
				byte[] screenshot = util.Take_A_ScreenShot(driver);
				sc.embed(screenshot, "image/png",sc.getName());
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception address is displayed");
			byte[] screenshot = util.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png",sc.getName());
		}
	 
	 try {
			if(Products.isDisplayed())
			{
				System.out.println("Pass: The products is displayed");
				sc.write("Pass: The products is displayed");
				byte[] screenshot = util.Take_A_ScreenShot(driver);
				sc.embed(screenshot, "image/png",sc.getName());
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception products is displayed");
			byte[] screenshot = util.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png",sc.getName());
		}
	 

	 try {
			if(Total_cost.isDisplayed())
			{
				System.out.println("Pass: The cost is displayed");
				sc.write("Pass: The products is displayed");
				byte[] screenshot = util.Take_A_ScreenShot(driver);
				sc.embed(screenshot, "image/png",sc.getName());
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception cost is displayed");
			byte[] screenshot = util.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png",sc.getName());
		}
 }
 
 public void click_logout()
 {
	 util.Button_Link_Click(driver, logout_btn);
 }


}
