package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
	}

	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");

	public LoginPage getLogin() {

		driver.findElement(signIn).click();
		return new LoginPage(driver);

	}

	public WebElement getNavigationBar() {

		return driver.findElement(navBar);

	}

	public WebElement getTitle() {

		return driver.findElement(title);

	}
}
