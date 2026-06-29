package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Homepage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
import TestBase.DriverManager;
import Utilities.DataProviders;

public class TC003_LoginDDTTest extends BaseClass
{

	

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups ={"datadriven"})//getting data provider from different class
	public void Verify_loginDDT(String email, String password, String Res)
	{
		//click on login button
		try
		{
		logger.info("==============Testcase TC003_LoginDDT is started=========================");
		Homepage hp = new Homepage(DriverManager.getDriver());
		
		hp.clickMyAccount();
		hp.ClickLogin();
		
		//Enter email and password details on my accountpage
		
		LoginPage lg = new LoginPage(DriverManager.getDriver());
		
		lg.SetLoginEmailid(email);
		lg.SetLoginPassword(password);
		lg.click_login();

		//Verify account on myaccount page and click on logout too
		MyAccountPage maccpage = new MyAccountPage(DriverManager.getDriver());
	boolean Targetpage = maccpage.MyAccountexists();
		
	if(Res.equalsIgnoreCase("Valid"))
	{	if(Targetpage == true)
	    { 
		Assert.assertTrue(Targetpage);
		
		maccpage.MyAccountLogout();
	}
	else
	{
		Assert.assertTrue(false);
	}
	}
	
	if(Res.equalsIgnoreCase("Invalid"))
	{
		if(Targetpage==true)
	
	{
		maccpage.MyAccountLogout();
	
		Assert.assertTrue(false);
	}
		
	
	else {
		Assert.assertTrue(true);
	}
	}
	
		}
	
	catch(Exception e)
	{ e.printStackTrace();
		Assert.fail();
	}
	logger.info("==============Testcase TC003_LoginDDT is finished=========================");

	}
}

	
