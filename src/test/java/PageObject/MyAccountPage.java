package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[@class='caret']")
	WebElement caret_MyAccount;
	@FindBy (xpath="//h2[text()='My Account']")
	WebElement MyAccountHeading;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
	WebElement btn_MyAccountLogout;
	
	public void MyAccountLogout()
	{
		caret_MyAccount.click();
		btn_MyAccountLogout.click();
	}
	
	public boolean MyAccountexists()

	{
		try
		{		
			return (MyAccountHeading.isDisplayed());

			
		}
		catch(Exception e)
		{
			return false;
			
		}
		
	}
	

}
