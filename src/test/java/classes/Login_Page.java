package classes;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Scenario;
import utils.Decode;



public class Login_Page {
	WebDriver driver=null ;
	
	
	
	public Login_Page(WebDriver driver) {
		
		this.driver = driver;
		 PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="/html/body/h2")
	WebElement heading;
	@FindBy(name="uname")
	private WebElement username;
	
	@FindBy(name="psw")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='loginbtn']")
	private WebElement login_btn;
			
	
	Utilities util = new Utilities();
	Decode de= new Decode();
	
	public void launch_the_app(WebDriver driver,String Url)
	{
		util.Naigate_to_URL(driver, Url);
	}
	
	
	public void enter_username(WebDriver driver_instance,String str)
	{
		util.Input_Text(driver, username, str);
	}
	
	public void enter_password(WebDriver driver_instance,String str)
	{
		util.Input_Text(driver, password, Decode.decrypt_data(str));
	}
	public void Button_click()
	{
		util.Button_Link_Click(driver, login_btn);
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
	
	
	


}
