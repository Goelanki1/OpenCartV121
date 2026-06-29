package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.AccountRegistrationPage;
import PageObject.Homepage;
import TestBase.BaseClass;
import TestBase.DriverManager;

public class TC001_AccountRegistration extends BaseClass
{
	
	@Test (groups ={"sanity","Master"})
	public void Verify_AccountRegistration()
	{
		logger.info("****************Account Registration Started***********************");
		Homepage hp = new Homepage(DriverManager.getDriver());
		
		logger.info("Click on My Account");
		hp.clickMyAccount();
		
		logger.info("Click on Register");
		hp.ClickRegister();
		
		logger.info("Enter All Details");
		
		AccountRegistrationPage accpage = new AccountRegistrationPage(DriverManager.getDriver());
		accpage.Firstname(RandomAlpha());
		accpage.Lastname(RandomAlpha());
		accpage.Email(RandomAlpha()+"@gmail.com");
		accpage.TelePhone(RandomNumeric());
	  String	pass= RandomAlphanum();
			accpage.Passowrd(pass);
		accpage.ConfirmPassword(pass);
		accpage.Agreecheckbox();
		accpage.Continue();
		
 String Actualmessage = accpage.getConfirmationMessage();
	logger.info("Account Created");
Assert.assertEquals(Actualmessage, "Your Account Has Been Created!");
logger.info("Test Passed");
logger.info("*********************Test Finished*****************");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
