package easy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

	@BeforeTest
	public void initialiseDriver() throws IOException {
		driver = initializeDriver();
		log.info("Browser INITIALZED");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateAppTitle() throws IOException {
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED CO123URSES");
		// Assert.assertTrue(false);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
