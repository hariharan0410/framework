package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import baseMethods.BaseMethods;
import enums.Locators;

public class HomePage extends LogInPage{
	public static String att2 = null;
	public String search = "//input[@type='search' and @name='filter']";
	public String incident = "//div[text()='Incidents']";
	public String newButton = "//button[@type='submit' and @value='sysverb_new']";
	public String incidentNumber = "//input[@id='incident.number']";
	public String shortdiscription = "//input[@id='incident.short_description']";
	public String submit = "(//button[@type='submit' and text()='Submit'])[1]";
	public String numberSearch = "//input[@placeholder='Search' and @class='form-control']";	
	public String update = "(//button[@type='submit' and text()='Update'])[1]";
	public String delete = "//button[@id='sysverb_delete']";
	public String popup = "//button[@onclick='return ok()']";
	
	public String clicknum = "//a[text()='"+att2+"']";
	
	public HomePage searching(String value) {
		type(locators(Locators.xpath, search), value);
		return this;		
	}
	
	public HomePage incidentClick() {
		click(locators(Locators.xpath, incident));
		return this;
		
	}

	public HomePage newButtonClick() {
		frameName("gsft_main");
		click(locators(Locators.xpath, newButton));
		return this;
	}
	
	public HomePage getAttributeValue() {
		att2 = getAttributeValue(locators(Locators.xpath, incidentNumber),"value");
//		System.out.println("Homepage ->"+att2);
		return this;				
	}
	
	public HomePage ShortdiscriptionText(String value) {
		type(locators(Locators.xpath, shortdiscription), value);
		return this;
	}
	
	public HomePage clickSubmit() {
		click(locators(Locators.xpath, submit));
		return this;
	}
	
	public HomePage numSearch() {
		frameName("gsft_main");
//		System.out.println("numsearch-> "+att2);
		typeEnter(locators(Locators.xpath, numberSearch), att2, Keys.ENTER);
		
		return this;
	}
	
	public HomePage clickSearchNum() {
//		frameName("gsft_main");
		click(locators(Locators.xpath, clicknum));
		return this;
	}
	
	public HomePage clickUpdate() {
		click(locators(Locators.xpath, update));
		return this;
	}
	
	public HomePage clickDelete() {
		click(locators(Locators.xpath, delete));
		return this;
	}
	
	public HomePage clickPopup() {
		click(locators(Locators.xpath, popup));
		return this;
	}
	


	

}
