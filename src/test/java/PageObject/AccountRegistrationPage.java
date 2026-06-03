package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	    //First Name Textfield
	   @FindBy(xpath= "//input[@name='firstname']")
	    WebElement txt_Firstname;
	
	//Last Name Textfield
		@FindBy(xpath= "//input[@name='lastname']")
		WebElement txt_Lastname;
		
		//Email Textfield
		@FindBy(xpath= "//input[@name='email']")
		WebElement txt_Email;
		
		//Telephone Textfield
		@FindBy(xpath= "//input[@name='telephone']")
		WebElement txt_Telephone;
		
		//Password Textfield
		@FindBy(xpath= "//input[@name='password']")
		WebElement txt_Password;
		
		//ConfirmPAssword Textfield
		@FindBy(xpath= "//input[@name='confirm']")
		WebElement txt_ConfirmPassword;
		
		//policyagree checkbox
		@FindBy(xpath= "//input[@name='agree']")
		WebElement chk_agree;
		
		//Continue button
		@FindBy(xpath= "//input[@class= 'btn btn-primary']")
		WebElement btn_Continue;
				
		//Registration successfull message "Your Account Has Been Created!"
		
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement txt_messageConfirmation;
		
		public void Firstname(String name)
		{
			txt_Firstname.sendKeys(name);
			
		}
		public void Email(String email)
		{
			txt_Email.sendKeys(email);
			
		}
		public void Lastname(String lastname)
		{
			txt_Lastname.sendKeys(lastname);
			
		}
		public void TelePhone(String number)
		{
			txt_Telephone.sendKeys(number);
			
		}
		public void Passowrd(String passowrd)
		{
			txt_Password.sendKeys(passowrd);
			
			
		}
		public void ConfirmPassword(String password)
		{
			txt_ConfirmPassword.sendKeys(password);
			
		}
		public void Agreecheckbox()
		{
			chk_agree.click();
			
		}
		public void Continue()
		{
			btn_Continue.click();
			
		}
		
		public String getConfirmationMessage()
		{
			try
			{
				return (txt_messageConfirmation.getText());
			}
			catch(Exception e)
			{
			return (e.getMessage());
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
