package TestCases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseClass;

public class sample extends BaseClass{

	public static void main(String[] args) {
		
		//fluent wait
	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
	
	wait.until(ExpectedConditions.alertIsPresent());
	
	
	//implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	//explicit wait
	
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(By.className(null)));
			
	}

}
