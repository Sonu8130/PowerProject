package easy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	public static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());

	@BeforeTest
	public void initialiseDriver() throws IOException {
		driver = initializeDriver();
		log.info("Browser INITIALZED");
	}

	@Test
	public void ValidateNavBar() throws IOException {

		driver.get("http://www.qaclickacademy.com/");
		log.info("Navigated to QA click Academy");
		driver.manage().window().maximize();
		log.info("Maximized page");
		LandingPage l = new LandingPage(driver);

		log.info("Landing page object created");

		Assert.assertTrue(l.getNavigationBar().isDisplayed());

		log.info("Validated Navigation bar");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
