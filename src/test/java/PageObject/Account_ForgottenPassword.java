package PageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Account_ForgottenPassword  extends BasePage

{
	public Account_ForgottenPassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	

		@FindBy (xpath="//input[@id='input-email' and @name ='email']")
		WebElement txt_EMailAddress;
		
		
		@FindBy(xpath= "//input[@type='submit']")
		WebElement btn_Continue;;
		
		@FindBy (xpath= "//div[contains(@class , 'alert alert-danger alert-dismissible')]")
		WebElement warningmessage;
		
		@FindBy (xpath= "//div[contains(@class , 'alert alert-success alert-dismissible')]")
		WebElement successmessage;
		
		public void EnterEmail(String Email)
		{
			txt_EMailAddress.clear();
			txt_EMailAddress.sendKeys(Email);
			
		}
		
		public void ContinueClick()
		{
			btn_Continue.click();
	}
		
		public String successmessage()
		{
			return successmessage.getText();
			
		}
	
		public String warningmessage()
		{
			return warningmessage.getText();
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
