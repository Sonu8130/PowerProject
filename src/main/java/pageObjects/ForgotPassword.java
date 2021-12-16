package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	private By Email = By.cssSelector(".form-control.input-hg");

	private By click = By.xpath("//input[@name='commit']");

	public WebElement getEmail() {

		return driver.findElement(Email);
	}

	public WebElement click() {

		return driver.findElement(click);
	}
}
