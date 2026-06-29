package TestBase;

import org.openqa.selenium.WebDriver;

public class DriverManager
{
	  // Each thread gets its OWN WebDriver instance
	    private static ThreadLocal<WebDriver> driver =
	            new ThreadLocal<>();
		public static Object getDriver;

	    // Store driver for current thread
	    public static void setDriver(WebDriver wdriver){

	        driver.set(wdriver);
	    }

	    // Get driver for current thread
	    public static WebDriver getDriver(){

	        return driver.get();
	    }

	    // ✅ IMPORTANT — always remove after test to prevent memory leak
	    public static void removeDriver() {
	        driver.remove();
	    }
	}

