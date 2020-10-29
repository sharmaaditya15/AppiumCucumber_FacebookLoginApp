package pages_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FB_LoginPage {

	WebDriver driver;

	By usernameField = By.cssSelector("#m_login_email");
	By passwordField = By.cssSelector("#m_login_password");
	By loginButton = By.cssSelector("#u_0_5");

	public FB_LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
