package easy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void initialiseDriver() throws IOException {
		driver = initializeDriver();
		log.info("Browser INITIALZED");
	}
 
	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password) throws IOException {

		driver.get(prop.getProperty("url"));
		// driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		ForgotPassword fp = lp.forgotPasword();
		fp.getEmail().sendKeys("sonukumar@gmail.com");
		fp.click().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "non-restricted user";
		data[0][1] = "123456";

		data[1][0] = "restricted user";
		data[1][1] = "12345";

		return data;
	}

}
