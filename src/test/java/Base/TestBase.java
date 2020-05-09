package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver; 
	
	public static void initialization(){
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajeshwari\\Downloads\\chromedriver_win32_latest\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com");
//		driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		
		
	}
	
	public boolean elementfound(By locator , long waittime)
	{
		boolean found = false ;
		WebDriverWait wait  = new WebDriverWait(driver, waittime);
		try {
			
				found = wait.until(ExpectedConditions.or(
						ExpectedConditions.visibilityOfElementLocated(locator),
						ExpectedConditions.elementToBeClickable(locator),
						ExpectedConditions.presenceOfElementLocated(locator),
						ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(
								driver.findElement(locator)))));
			}
		catch(Exception e)
		{
			found = false;
		}

		return found;
	}
	
}
