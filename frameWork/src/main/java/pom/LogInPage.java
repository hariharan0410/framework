package pom;

import baseMethods.BaseMethods;
import enums.Locators;

public class LogInPage extends BaseMethods {
	
	private String username = "//input[@name='user_name']";
	private String password = "//input[@name='user_password']";
	private String loginButton = "//button[@type='submit']";
	
	public LogInPage typeUsername(String value) {
		type(locators(Locators.xpath,username), value);
		return this;		
	}
	
	public LogInPage typePassword(String value) {
		type(locators(Locators.xpath, password), value);
		return this;
	}
	
	public HomePage loginButton() {
		click(locators(Locators.xpath, loginButton));
		return new HomePage();
	}
	
	public LogInPage frame(String value) {
		frameName(value);
		return this;
		
	}
	

}
