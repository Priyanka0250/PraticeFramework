package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class LandingPage {
	public WebDriver driver;
	By sign_in=By.cssSelector("div.ast-button");
	String Signin="cssSelector:=div.ast-button";
	
	By Search_Title=By.cssSelector("h1.elementor-heading-title.elementor-size-default");
	By Header=By.cssSelector("div.ast-flex.main-header-container");
	By Header_link=By.cssSelector("div.main-navigation");	
	public LandingPage(WebDriver driver) {
	this.driver=driver;
	}

	public WebElement Login()
	{
		return driver.findElement(sign_in);	
	}	

	public WebElement SearchCourse() 
	{
		return driver.findElement(Search_Title);	
	}
	
	public WebElement Header()
	{
		return driver.findElement(Header);	
	}
	
	public WebElement Header_links()
	{
		return driver.findElement(Header_link);	
		
	}
	
	public List<WebElement> Header_links_Count()
	{		
		Header_links();
		List<WebElement> Header_count=driver.findElements(By.tagName("a"));
		return Header_count;
		
	}

	
}
