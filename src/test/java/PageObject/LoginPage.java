package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage
{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_loginEmailID;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_LoginPassword;
	
	@FindBy(xpath="//input[@class ='btn btn-primary']")
	WebElement btn_Loginbutton;
	
	@FindBy(xpath="//div[@class='form-group']//a[text()='Forgotten Password']")
	WebElement link_ForgottenPassword;
	
	public void SetLoginEmailid(String email)
	{
		txt_loginEmailID.sendKeys(email);
	}

	public void SetLoginPassword(String password)
	{
		
		txt_LoginPassword.sendKeys(password);
	}
	
	public void click_login()
	{
		btn_Loginbutton.click();
		
	}
	
	public void login_successful()
	{
		
	}
	 public void ForgottenPassowrd()
	 {
		 link_ForgottenPassword.click();
	 }
}

