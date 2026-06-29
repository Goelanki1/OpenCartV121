package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	// ✅ NO static WebDriver here anymore
	protected Properties p;
	public static Logger logger;

	@BeforeClass(groups = { "Sanity", "datadriven", "Master", "Regression" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String browser) throws Exception {

		// ✅ STEP 1 — Load config.properties FIRST (p must not be null)
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
// STEP 2 — Logger
		logger = LogManager.getLogger(this.getClass());

		// ✅ STEP 3 — Now safe to read from p
		String env = p.getProperty("execution_env");

		// ✅ STEP 4 — Create driver via Factory
		WebDriver driver = DriverFactory.createDriver(browser, os, env);

		// ✅ STEP 5 — Store in ThreadLocal
		DriverManager.setDriver(driver);
		// ✅ STEP 6 — Browser configuration
		DriverManager.getDriver().get(p.getProperty("appurl").trim()); // reading url from config properties file
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		DriverManager.getDriver().manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "datadriven", "Master", "Regression"})
	public void teardown() {

		// ✅ Use DriverManager — not bare 'driver'
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.removeDriver(); // ✅ prevent memory leak
		}

	}

	public String RandomAlpha() {
		String randomAlpha = RandomStringUtils.insecure().nextAlphabetic(6);
		return randomAlpha;
	}

	public String RandomNumeric() {
		String randomNum = RandomStringUtils.insecure().nextNumeric(10);
		return randomNum;
	}

	public String RandomAlphanum() {
		String randomAlpha = RandomStringUtils.insecure().nextAlphabetic(6);
		String randomNum = RandomStringUtils.insecure().nextNumeric(10);
		return randomAlpha + "@" + randomNum;

	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));

		TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

}
