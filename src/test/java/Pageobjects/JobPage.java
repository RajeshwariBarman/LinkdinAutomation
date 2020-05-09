package Pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import Base.TestBase;

public class JobPage extends TestBase{
	
	By search_btn = By.xpath("//button[@type = 'submit' and text() = 'Search']");
	By clear_btn = By.xpath("//span[@class = 'artdeco-button__text' and text()  = 'Clear ' ]/parent::button");
	By explevel_btn = By.xpath("//span[text() = 'Experience Level']/parent::button");
	By midlevel_cbx = By.xpath("//span[text() = 'Mid-Senior level']/../../preceding::input[@name = 'experience-level-group' and @type = 'checkbox'][1]");
	By nooffilter_txt = By.xpath("//span[@class = 'artdeco-button__text' and text()  = 'Clear ' ]/parent::button/span/span");
	By allfilter_btn = By.xpath("//span[text() = 'All filters']/parent::button");
	By fulltime_cbx = By.xpath("//span[text() = 'Full-time']/../../../input");
	By apply_btn = By.xpath("//span[text() = 'Apply']/parent::button[@data-control-name = 'all_filters_apply']");
	By profile_btn = By.xpath("//li[@id = 'profile-nav-item']//div[@id = 'nav-settings__dropdown']/button");
	By signout = By.xpath("//ul/li/a[text() = 'Sign out']");
	By app_btn = By.xpath("(//div[@class = 'ember-view']/div/button[@data-control-name='filter_pill_apply'])[4]");
	
	public void validatefilter() throws InterruptedException
	{
		Thread.sleep(2000);
		
		if(elementfound(search_btn, 2000))
			driver.findElement(search_btn).click();
		else
			System.out.println(" search_btn  Element not found");
		
		List<WebElement> ele = driver.findElements(clear_btn);
		System.out.println(ele);
		if(ele.size()==0)
			System.out.println("No Filter");
		else
			System.out.println("FAIL Filter is there");
	}
	
	public void selectcbx() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		Thread.sleep(2000);	
		if(elementfound(explevel_btn, 2000))
			driver.findElement(explevel_btn).click();
		else
			System.out.println(" esp level Element not found");
		
		Thread.sleep(3000);
		
		if(elementfound(midlevel_cbx, 3000))
			js.executeScript("arguments[0].click();", driver.findElement(midlevel_cbx));
		else
			System.out.println("mid level element not found");
		
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();", driver.findElement(app_btn));
	
		if(elementfound(nooffilter_txt, 3000))
		{
			if(driver.findElement(nooffilter_txt).getText().trim().equalsIgnoreCase("1"))
				System.out.println("PASSED , 1 filer selected");
			else
				System.out.println("FAILED filter count did not match");
		}
		else
			System.out.println("no of filter element not found");
		
		}
	
	public void selectjobtype() throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if(elementfound(allfilter_btn, 2000))
			driver.findElement(allfilter_btn).click();
		else
			System.out.println(" all filter  Element not found");
		
		Thread.sleep(3000);
		if(elementfound(fulltime_cbx, 3000))
			js.executeScript("arguments[0].click();", driver.findElement(fulltime_cbx));
	
		else
			System.out.println("full time element not found");
		
		
		Thread.sleep(3000);
		if(elementfound(nooffilter_txt, 2000))
		{
			if(driver.findElement(nooffilter_txt).getText().equalsIgnoreCase("2"))
				System.out.println("PASSED , 2 filer selected");
			else
				System.out.println("FAILED , filter mis match");
		}
		else
			System.out.println("no of filter element not found");
		
		}
	
	public void logout() throws InterruptedException
	{
		if(elementfound(apply_btn, 2000))
			driver.findElement(apply_btn).click();
		else
			System.out.println("apply element not found");
		
		Thread.sleep(2000);
		if(elementfound(profile_btn, 3000))
			driver.findElement(profile_btn).click();
		else
			System.out.println("profile btn element not found");
		
		Thread.sleep(2000);;
		if(elementfound(signout, 3000))
			driver.findElement(signout).click();
		else
			System.out.println("signout element not found");
	}
	

}

