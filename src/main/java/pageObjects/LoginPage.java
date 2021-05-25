package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	By email=By.xpath("//input[@type='email']");
	By password=By.xpath("//input[@type='password']");
	By submit=By.xpath("//input[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	}
	
	public WebElement Email()
	{
		return driver.findElement(email);	
	}
	
	public WebElement Password()
	{
		return driver.findElement(password);	
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);	
	}
	
	
	
	
	
	
	
}
