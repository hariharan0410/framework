package testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseMethods.BaseMethods;
import enums.Driver;
import pom.LogInPage;

public class Login extends BaseMethods {
	
	@BeforeMethod
	public void beforeMethod() {
		browserSetup(Driver.CHROME, "https://dev115042.service-now.com/");
		
		new LogInPage()
		.frame("gsft_main")
		.typeUsername("admin")
		.typePassword("8wwyFB6$Or=I")
		.loginButton();
	}
	
	@AfterMethod
	public void afterMethod() {
		quit();
	}
	
	

}
