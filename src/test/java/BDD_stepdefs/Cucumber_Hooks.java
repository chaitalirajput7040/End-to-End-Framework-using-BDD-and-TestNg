package BDD_stepdefs;

import classes.TestNG_util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Cucumber_Hooks {
	
	@Before
	public void before(Scenario sc)
	{
		TestNG_util.sc=sc;
		
	}
	

	@After
	public void after(Scenario sc)
	{
		if(sc.isFailed())
		{
			System.out.println(sc.getName()+"Failed");
		}
		else
		{
			
		}
	}

}
