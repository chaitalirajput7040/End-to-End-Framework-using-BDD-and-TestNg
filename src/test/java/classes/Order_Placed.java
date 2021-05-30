package classes;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.Scenario;

public class Order_Placed {
	
	WebDriver driver;
    Scenario sc;
	
	public Order_Placed(WebDriver driver,Scenario sc) {
		super();
		this.driver = driver;
		this.sc=sc;
		 PageFactory.initElements(driver,this);
	}

@FindBy(xpath="/html/body/h2")
private WebElement heading;
@FindBy(id="fname")
private WebElement first_name;
@FindBy(id="email")
private WebElement email;
@FindBy(id="adr")
private WebElement address;
@FindBy(id="city")
private WebElement city;
@FindBy(id="zip")
private WebElement zip;
@FindBy(id="state")
private WebElement state;
@FindBy(name="sameadr")
private WebElement checkbox;
@FindBy(xpath="//input[@type='submit']")
private WebElement checkout_button;

Utilities util = new Utilities();

public void checkout_page()
{
	
	Assert.assertEquals(heading.getText(),"Almost there!!");
	System.out.println("User lands on the checkout page");
	sc.write("User lands on the checkout page");
	byte[] screenshot = util.Take_A_ScreenShot(driver);
	sc.embed(screenshot, "image/png",sc.getName());
}



public void Check_if_heading_is_displayed(Scenario sc)
{
	
	try
	{
		if(heading.isDisplayed())
           {
               System.out.println("Heading of the page is " + heading.getText());
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

public void Fill_billing_details(Scenario sc) throws SQLException, InterruptedException
{
	List<String> person = utils.Apache_poi.Read();
	
	String test_value=person.get(2);
	
	List<String> db = utils.DatabaseUtils.Get_data(test_value);
	
	util.Input_Text(driver, first_name, db.get(0));
	util.Input_Text(driver, email, db.get(1));
	util.Input_Text(driver, address, db.get(2));
	util.Input_Text(driver, city, db.get(3));
	util.Input_Text(driver, zip, db.get(4));
	util.Input_Text(driver, state, db.get(5));
	if(db.get(6).equalsIgnoreCase("Y"))
	{
	util.check_that_if_not_yet(driver, checkbox);
	}
	else
	{
		util.check_that_if_not_yet(driver, checkbox);
	}
	byte[] screenshot = util.Take_A_ScreenShot(driver);
	sc.embed(screenshot, "image/png",sc.getName());
	Thread.sleep(2000);
	
}
  public void checkout_click()
  {
	util.Button_Link_Click(driver, checkout_button);
	System.out.println("Billing address filled successfully");
	sc.write("Billing address filled successfully");
   }
}
