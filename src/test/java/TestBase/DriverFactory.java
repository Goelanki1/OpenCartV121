package TestBase;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver(String browser, String os, String env) 
                                                              throws Exception {
        WebDriver driver;

        if (env.equalsIgnoreCase("remote")) {
            DesiredCapabilities cap = new DesiredCapabilities();

            // OS
            if (os.equalsIgnoreCase("windows"))
                cap.setPlatform(Platform.WIN11);
            else if (os.equalsIgnoreCase("mac"))
                cap.setPlatform(Platform.MAC);

            // Browser
            cap.setBrowserName(browser.toLowerCase());

            driver = new RemoteWebDriver(
                new URL("http://localhost:4444/"), cap);

        } else {
            // Local
            switch (browser.toLowerCase()) {
                case "chrome":  driver = new ChromeDriver();  break;
                case "firefox": driver = new FirefoxDriver(); break;
                case "edge":    driver = new EdgeDriver();    break;
                default: throw new IllegalArgumentException(
                    "Browser not supported: " + browser);
            }
        }
        return driver;
    }
}
