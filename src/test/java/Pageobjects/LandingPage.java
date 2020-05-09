package Pageobjects;

import org.openqa.selenium.By;

import Base.TestBase;

public class LandingPage extends TestBase {
	
	By sign_btn = By.xpath("//a[text() = 'Sign in']");
	
	public void clicksign()
	{
		if(elementfound(sign_btn, 3000))
			driver.findElement(sign_btn).click();
		else
			System.out.println("Sign in buttion not found");
	}

}
