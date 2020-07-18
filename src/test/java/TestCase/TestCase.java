package TestCase;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pageobjects.HomePage;
import Pageobjects.JobPage;
import Pageobjects.LandingPage;
import Pageobjects.LoginPage;

public class TestCase extends TestBase {
	
	HomePage homepage;
	JobPage jobpage;
	LandingPage landingpage;
	LoginPage loginpage;
	
	
	@BeforeMethod
	void setup()
	{
		initialization();

		
	}
	
	
	
	@Test(dataProvider = "signindetails")
	void vaidations(String uname , String pass) throws InterruptedException, AWTException
	{
		System.out.print("in the tes");
		landingpage = new LandingPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		jobpage = new JobPage();
		
		landingpage.clicksign();
		loginpage.Signin(uname,pass);
		homepage.validatehomepage();
		homepage.search();
		homepage.clickjobs();

		//The below method is used for checking that no filter is present, so it scanning the entire dom.
		//It will take time. 
		jobpage.validatefilter();
		jobpage.selectcbx();
		jobpage.selectjobtype();
		jobpage.logout();
		
		Thread.sleep(3000);
		
	}
	
	@DataProvider(name="signindetails")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "raajeshwaribarman1@gmail.com", "23011993" },
        };
	} 
	
	
	@AfterMethod
	void tear()
	{
		driver.quit();
	}

}
