package TestCases;

import org.testng.annotations.Test;



import org.testng.Assert;

import PageObject.Homepage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
import TestBase.DriverManager;

public class TC002_MyAccountLogin extends BaseClass {
	@Test (groups ={"Regression","Master"})
	public void verify_MyAccountLogin()
	{
		logger.info("******************testcase TC002_MyAccountLogin started****************");
		try {
		Homepage hl= new Homepage(DriverManager.getDriver());
		
		logger.info("clicking on login");
		hl.clickMyAccount();
		hl.ClickLogin();
		
		logger.info("Enter username and password");
		LoginPage lg  = new LoginPage(DriverManager.getDriver());
		
		lg.SetLoginEmailid(p.getProperty("Emailid"));
		lg.SetLoginPassword(p.getProperty("password"));
		lg.click_login();
		
		
		MyAccountPage mc= new MyAccountPage(DriverManager.getDriver());
		boolean targetpage = mc.MyAccountexists();
		Assert.assertTrue(targetpage);
	
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	logger.info("*******************Test case finished*******************");

}
}