package BDD_stepdefs;

import java.sql.SQLException;
import java.util.List;

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

import classes.Add_to_Cart;
import classes.End_Page;
import classes.Login_Page;
import classes.Order_Placed;

import java.util.Map;
import classes.TestNG_util;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;


public class E2E_stepdefs extends TestNG_util {
	private int qty[];
	
	

Login_Page ln = new Login_Page(driver);
Add_to_Cart cart = new Add_to_Cart(driver,sc);
Order_Placed order = new Order_Placed(driver,sc);
End_Page end = new End_Page(driver);


	@Given("^User launches the app$")
	public void launching(DataTable url)
	{
		List<String> URL = url.asList();
		String str1 =URL.get(0);
		ln.launch_the_app(driver,str1);
	}
	

	@When("User gives the username as {string}")
	public void user_gives_the_username_as_And_User_gives_the_password_as(String str) {
	    // Write code here that turns the phrase above into concrete actions
		//beforeTest("chrome");
		ln.enter_username(driver, str);
		
		 }
@Given("User gives the password as {string}")
public void cred(String str) throws InterruptedException
{
	ln.enter_password(driver, str);
	Thread.sleep(3000);
}
	@Given("some other precondition")
	public void some_other_precondition() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("User clicks on Login button")
	public void user_clickson_Login_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    ln.Button_click();
	    ln.Check_if_heading_is_displayed(sc);
	}

	@Given("USer lands on the Add to Cart page")
	public void user_lands_on_the_Add_to_Cart_page() {
	    // Write code here that turns the phrase above into concrete actions
		 cart.Check_if_heading_is_displayed(sc);
	}

	@Given("user selects the items and add them to cart")
	public void user_selects_the_items_and_add_them_to_cart(DataTable dataTable) throws InterruptedException {
	Map<String, String> data = dataTable.asMap(String.class, String.class);
	System.out.println(data.get("Banana"));
	 qty =  new int[]{Integer.parseInt(data.get("Apple")),
		Integer.parseInt(data.get("Banana"))	,
		Integer.parseInt(data.get("Orange")),
	    Integer.parseInt(data.get("Brinjal")),
		Integer.parseInt(data.get("Potatoes"))};
            cart.select_items(qty);
            Thread.sleep(2000);
	}

	@Then("Verify the quantity")
	public void verify_the_quantity() {
	    // Write code here that turns the phrase above into concrete actions
		cart.verify_the_quantity(qty);   
	}

	@Then("verify the total items is accurate")
	public void verify_the_total_items_is_accurate() {
	    // Write code here that turns the phrase above into concrete actions
	   cart.Verify_total_item(qty);
	}

	@Then("verify the total cost is accurate")
	public void verify_the_total_cost_is_accurate() {
	    // Write code here that turns the phrase above into concrete actions
	   cart.Verify_total_cost(qty);
	}

	@Then("User click on the checkout button")
	public void user_click_on_the_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
	   cart.click_checkout();
	}

	@Given("User lands on the checkout page")
	public void checkout_page()
	{
		order.checkout_page();
		order.Check_if_heading_is_displayed(sc);
	}


	@Then("User fills the billing address details")
	public void user_fills_the_billing_address_details() throws SQLException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		order.Fill_billing_details(sc);
	    
	}

	@Then("User clicks on the checkout button")
	public void user_clicks_on_the_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
	  order.checkout_click();
	}

	@Given("User lands on the order placed page")
	public void user_lands_on_the_order_placed_page() {
	    // Write code here that turns the phrase above into concrete actions
	   end.Check_if_heading_is_displayed(sc);
	}

	@Given("User verify the message")
	public void user_verify_the_message() {
	    // Write code here that turns the phrase above into concrete actions
	   end.verify_success(sc);
	}

	@Given("Verify the details are accurate")
	public void verify_the_details_are_accurate() {
	    // Write code here that turns the phrase above into concrete actions
	    end.verify_if_the_details_are_displayed(sc);
	}

	@Then("User clicks on logout button")
	public void user_clicks_on_logout_button() {
	    // Write code here that turns the phrase above into concrete actions
	   end.click_logout();
	}
	


}
