package TestCases;

import org.testng.annotations.Test;

import PageObject.Account_ForgottenPassword;
import PageObject.Homepage;
import PageObject.LoginPage;
import TestBase.BaseClass;
import Utilities.DataProviders;
import Utilities.ExcelUtility;


public class TC004_ForgottenPassword extends BaseClass
{
	@Test(
		    groups = {"Master"},
		    dataProvider = "ForgotPasswordData",
		    dataProviderClass = DataProviders.class
		)
		public void Verify_ForgottenPassword(int rowNum, String email)
		                                     throws Exception
		{
		 logger.info("******** TC004 Forgot Password Started ********");

		    Homepage hp = new Homepage(driver);
		    hp.clickMyAccount();
		    hp.ClickLogin();

		    LoginPage lp = new LoginPage(driver);
		    lp.ForgottenPassowrd();

		    Account_ForgottenPassword fp = new Account_ForgottenPassword(driver);
		    fp.EnterEmail(email);
		    fp.ContinueClick();
		    String path = System.getProperty("user.dir")
		            + "\\TestData\\OpenCard_LoginData.xlsx";

		    ExcelUtility xlutil = new ExcelUtility(path);

		    if(fp.successmessage().contains("confirmation link"))
		    {
		        xlutil.setCellData("Sheet2",
		                           rowNum,
		                           1,
		                           "Valid Email");

		        xlutil.fillGreenColor("Sheet2",
		                              rowNum,
		                              1);
		    }
		    else
		    	
		    {
		        xlutil.setCellData("Sheet2",
		                           rowNum,
		                           1,
		                           "Invalid Email");

		        xlutil.fillRedColor("Sheet2",
		                            rowNum,
		                            1);
		    }
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
