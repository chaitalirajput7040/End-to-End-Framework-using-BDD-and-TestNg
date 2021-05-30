package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.Scenario;

public class Add_to_Cart {
	WebDriver driver;
	Scenario sc;
	
	public Add_to_Cart(WebDriver driver,Scenario sc) {
		super();
		this.driver = driver;
		this.sc=sc;
		 PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="/html/body/h2")
	WebElement heading;
	@FindBy(id="numberofitems")
	private WebElement count;
	
	@FindBy(xpath="//button[text()='Checkout']")
	private WebElement checkout;
	
	@FindBy(xpath="//p[@class='price']")
	private List<WebElement>  price;
	
	@FindBy(id="priceamt")
	private WebElement amt;
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	private List<WebElement>  Add_Buttons;
	
	@FindBy(xpath="//a[@class='qtyqty']")
	private List<WebElement>  Qty;
	

	@FindBy(xpath="//button[text()='Remove item']")
	private List<WebElement>  Remove_Buttons;
	
	Utilities util = new Utilities();
	public void select_items(int[] data)
	{
		//Apple
		for(int i=0; i<data[0];i++)
		{
			util.Button_Link_Click(driver, Add_Buttons.get(0));
		}
		//Banana
		for(int i=0; i<data[1];i++)
		{
		util.Button_Link_Click(driver, Add_Buttons.get(1));
		}
		//Orange
		for(int i=0; i<data[2];i++)
		{
		util.Button_Link_Click(driver, Add_Buttons.get(2));
		}
		//Brinjal
		for(int i=0; i<data[3];i++)
		{
		util.Button_Link_Click(driver, Add_Buttons.get(3));
		}
		//Potato
		for(int i=0; i<data[4];i++)
		{
		util.Button_Link_Click(driver, Add_Buttons.get(4));
		}
	}
	
	public void verify_the_quantity(int arr[])
	{
		String Apple_qty	=Qty.get(0).getText().replace("Qty :","").trim();
		String Banana_qty	=Qty.get(1).getText().replace("Qty :","").trim();
		String Orange_qty	=Qty.get(2).getText().replace("Qty :","").trim();
		String Brinjal_qty	=Qty.get(3).getText().replace("Qty :","").trim();
		String potato_qty	=Qty.get(4).getText().replace("Qty :","").trim();
		
		int data[] =new int [] {
				Integer.parseInt(Apple_qty),
				Integer.parseInt(Banana_qty),
				Integer.parseInt(Orange_qty),
				Integer.parseInt(Brinjal_qty),
				Integer.parseInt(potato_qty)
				};
		Assert.assertTrue(Arrays.equals(arr,data));
		System.out.println("Passed the quantity step!!!!!");
		sc.write("Passed the quantity step!!!!!");
	}
	
	public void Verify_total_item(int data[])
	{
		int total_item=0;
		for(int i :data)
		{
			total_item+=i;
		}
		
		int total_ui=Integer.parseInt(count.getText());
		Assert.assertEquals(total_item, total_ui);
		System.out.println("Passed the total_items count!!!");
		sc.write("Passed the total_items count!!!");
	}
	public void Verify_total_cost(int data[])
	{
		ArrayList<Integer> price_arr = new ArrayList();
		
		for(WebElement i :price)
		{
			price_arr.add(Integer.parseInt(i.getText().replace("$","").trim()));
		}
		int tot_cost=0;
		int counter=0;
		for (int i : price_arr)
		{if(counter!=0)
		{
			counter++;
		}
			tot_cost=tot_cost+(i*data[counter]);
		}
		//System.out.println(tot_cost);
		int tot=Integer.parseInt(amt.getText());
		
		Assert.assertEquals(tot_cost, tot);
		System.out.println("Passed the cost amount!!!");
		sc.write("Passed the cost amount!!!");
		
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
	
	public void click_checkout()
	{
		util.Button_Link_Click(driver,checkout);
	}
	
}
	


