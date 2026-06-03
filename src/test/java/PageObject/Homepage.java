package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage
{

	public Homepage(WebDriver driver) {
		super(driver);
		
	}
	
	//"My Account" button
	
	@FindBy(xpath = "//a[@title='My Account']/span[@class='hidden-xs hidden-sm hidden-md']")
	WebElement btn_MyAccount;
	
	//"Register" button
	@FindBy(xpath = "//a[text()='Register']")
	WebElement btn_Register;
	
	
	//Login button
	@FindBy(xpath = "//a[text()='Login']")
	WebElement btn_Login;
	
	public void clickMyAccount()
	{
		btn_MyAccount.click();
	}
	
	
	public void ClickLogin()
	{
		btn_Login.click();
	}

	public void ClickRegister()
	{
		btn_Register.click();
	}
}
