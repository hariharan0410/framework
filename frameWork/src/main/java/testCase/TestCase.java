package testCase;


import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseMethods.BaseMethods;
import enums.Locators;
import pom.HomePage;

public class TestCase extends Login{


	@Test
	public void createIncident() {
		new HomePage()
		.searching("Incidents")
		.incidentClick()
		.newButtonClick()
		.getAttributeValue()
		.ShortdiscriptionText("creating incident")
		.clickSubmit();
		System.out.println("INCIDENT CREATED --> " +new HomePage().att2);	
	}
	

	@Test (dependsOnMethods={"createIncident"})
	public void updateIncident() {
		new HomePage()
		.searching("Incidents")
		.incidentClick()
		.numSearch()
		.clickSearchNum()
		.ShortdiscriptionText("updated incident")
		.clickUpdate();		
		System.out.println("INCIDENT UPDATED --> " +new HomePage().att2);
	}
	

	@Test  (dependsOnMethods={"updateIncident"})
	public void DeleteIncident() {
		new HomePage()
		.searching("Incident")
		.incidentClick()
		.numSearch()
		.clickSearchNum()
		.clickDelete()
		.clickPopup();
		System.out.println("INCIDENT DELETED --> " +new HomePage().att2);
	}




}
