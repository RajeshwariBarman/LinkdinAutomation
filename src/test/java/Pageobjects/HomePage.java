package Pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import Base.TestBase;

public class HomePage extends TestBase {

	By home_icon = By.xpath("//span[text() = 'Home']");
	By search_txt = By.cssSelector("input.search-global-typeahead__input.always-show-placeholder");
	
	public void validatehomepage()
	{
		if(elementfound(home_icon, 4000))
			System.out.println("Login Successfull");
		else
			System.out.println("Login not Successfull");
	}
	
	public void search()
	{
		if(elementfound(search_txt, 4000))
			driver.findElement(search_txt).click();
		else
			System.out.println("Login not Successfull");
	}
	
	public void clickjobs() throws InterruptedException, AWTException
	{
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
				
		
	}
}
