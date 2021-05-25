package pageObjects;

import java.util.List;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class LandingPage {
	public WebDriver driver;
	By sign_in=By.cssSelector("div.ast-button");
	By Search_Title=By.cssSelector("h1.elementor-heading-title.elementor-size-default");
	By Header=By.cssSelector("div.ast-flex.main-header-container");
	By Header_link=By.cssSelector(".main-navigation");	
	
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
	
	
	public void HeaderLinks_Click()
	{
		WebElement header_driver=driver.findElement(Header_link);
		List<WebElement> Header_count=header_driver.findElements(By.tagName("a"));
		int Total_links=Header_count.size();
		System.out.println(Total_links);
		
		for(int i=0;i<=Total_links-1;i++)
		{
			String clickonLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			Header_count.get(i).sendKeys(clickonLinkTab);		
		}	
	}
	
	
}
