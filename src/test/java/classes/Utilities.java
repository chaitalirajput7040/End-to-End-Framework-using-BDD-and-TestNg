package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Utilities {
	public void Button_Link_Click(WebDriver driver_instance, WebElement ele){
		ele.click();
	}
	
	public void Assert_My_Title(WebDriver driver_instance, String Expected){
		String Actual=driver_instance.getTitle();
		Assert.assertEquals(Expected, Actual);
		
	}

	public void Naigate_to_URL(WebDriver driver_instance, String URL){
		driver_instance.get(URL);
	}
	
	public void Input_Text(WebDriver driver_instance,WebElement ele, String Text){
		ele.sendKeys(Text);
	}
	
	public void Enter_key_Press(WebDriver driver_instance,By ele){
		driver_instance.findElement(ele).sendKeys(Keys.ENTER);
	}
	
	public void wait_for_some_Time(int time) throws InterruptedException{
		Thread.sleep(time);
	}
	
	public byte[] Take_A_ScreenShot(WebDriver driver){
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}
	
	public void  maximize_my_window(WebDriver driver){
		driver.manage().window().maximize();
	}
	
	public boolean check_if_already_checked(WebDriver driver, WebElement ele){
		return ele.isSelected();
	}
	
	public void check_that_if_not_yet(WebDriver driver, WebElement ele){
		boolean ischecked =check_if_already_checked( driver,  ele);
		if(!ischecked){
			Button_Link_Click(driver, ele);
		}
	}
	
	public void uncheck_that_if_checked(WebDriver driver, WebElement ele){
		boolean ischecked =check_if_already_checked( driver,  ele);
		if(ischecked){
			Button_Link_Click(driver, ele);
		}
	}
	
	public void Handle_Alert(WebDriver driver){
		try{
		driver.switchTo().alert().accept();
		}
		catch(Exception e){
			System.out.println("Alert Not found");
		}

}
	
}
