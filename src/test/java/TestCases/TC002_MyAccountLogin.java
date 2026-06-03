package TestCases;

import org.testng.annotations.Test;



import org.testng.Assert;

import PageObject.Homepage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;

public class TC002_MyAccountLogin extends BaseClass {
	@Test (groups ={"Regression","Master"})
	public void verify_MyAccountLogin()
	{
		logger.info("******************testcase TC002_MyAccountLogin started****************");
		try {
		Homepage hl= new Homepage(driver);
		
		logger.info("clicking on login");
		hl.clickMyAccount();
		hl.ClickLogin();
		
		logger.info("Enter username and password");
		LoginPage lg  = new LoginPage(driver);
		
		lg.SetLoginEmailid(p.getProperty("Emailid"));
		lg.SetLoginPassword(p.getProperty("password"));
		lg.click_login();
		
		
		MyAccountPage mc= new MyAccountPage(driver);
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