package Pageobjects;

import org.openqa.selenium.By;


import Base.TestBase;

public class LoginPage extends TestBase {
	
	By uname_txt = By.cssSelector("input#username");
	By pass_txt = By.cssSelector("input#password");
	By sign_btn = By.xpath("//button[text() = 'Sign in']");
	
	public void Signin(String uname , String pass) throws InterruptedException
	{
		System.out.println("In sign in page");
		Thread.sleep(2000);
		if(elementfound(uname_txt, 3000))
			driver.findElement(uname_txt).sendKeys(uname);
		else
			System.out.println("Uname_txt not found");
		
		if(elementfound(pass_txt, 3000))
			driver.findElement(pass_txt).sendKeys(pass);
		else
			System.out.println("pass_txt not found");
		
		if(elementfound(sign_btn, 3000))
		{
		
			Thread.sleep(2000);
			driver.findElement(sign_btn).click();
		}
			
		else
			System.out.println("sign_btn not found");
	}
	
}
