package BDD_runner;

import classes.TestNG_util;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/BDD_feature",
		glue="BDD_stepdefs",
		
		strict=true,
		monochrome=true,
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-html-reports"},
		tags="@Regression"
				
		)


public class E2E_Runner extends TestNG_util {

}
