package baseMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.Driver;
import enums.Locators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods {

	static WebDriver driver;
	//static WebDriverWait wait = new WebDriverWait(driver, 10);
	//protected static WebDriverWait wait = new WebDriverWait(driver, 10);
//	public String att;
	
	
	
	public void browserSetup(Driver browser, String url) {

		switch(browser) {

		case CHROME: 
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:

		}
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public WebElement locators(Locators type, String value) {

		switch(type) {

		case id: return driver.findElement(By.id(value));
		case name: return driver.findElement(By.name(value));
		case classname: return driver.findElement(By.className(value));
		case linktext: return driver.findElement(By.linkText(value));
		case partiallinktext: return driver.findElement(By.partialLinkText(value));
		case tagname: return driver.findElement(By.partialLinkText(value));
		case xpath: return driver.findElement(By.xpath(value));
		case css: return driver.findElement(By.cssSelector(value));
		}
		return null;
	}

	public void switchToWindow(int i) {

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst_windowHandles = new ArrayList(windowHandles);
		lst_windowHandles.get(i);
	}

	public void selectValue(WebElement ele, String value) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));		
		Select slt = new Select(element);
		slt.selectByValue(value);		

	}

	public void selectText(WebElement ele, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));		
		Select slt = new Select(element);
		slt.selectByVisibleText(Text);		
	}

	public void selectIndex(WebElement ele, int index) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));		
		Select slt = new Select(element);
		slt.selectByIndex(index);		
	}

	public void click(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
	}

	public void type(WebElement ele, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.clear();
		element.sendKeys(value);
	}
	
	public void typeEnter(WebElement ele, String value, Keys key) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.clear();
		element.sendKeys(value,key);
	}

	public void frameName(String value) {
		driver.switchTo().frame(value);
	}

//	public String getAttribute(WebElement ele, String attribute)	{
//		String att = ele.getAttribute(attribute);
//		System.out.println(att);
//		return att;
//	}
	
	public String getAttributeValue(WebElement ele, String attribute)
	{
		return ele.getAttribute(attribute);
	}



}
