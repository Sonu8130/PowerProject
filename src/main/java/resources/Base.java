package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Sonu\\eclipse-workspace\\Power\\src\\main\\java\\resources\\data.properties");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sonu\\eclipse-workspace\\Power\\src\\main\\java\\resources\\chromedriver.exe");
		prop.load(fis);
		String Browser = prop.getProperty("browser");

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShot(String methodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + methodName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
