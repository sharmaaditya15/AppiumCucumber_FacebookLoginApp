package pages_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FB_HomePage {

	WebDriver driver;

	By searchButton = By.cssSelector("a[name='Search']");
	By searchField = By.cssSelector("#main-search-input");
	By likeButton = By.cssSelector("div[aria-label='Like Page']");
			

	public FB_HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void enterSearchText(String text) {
		driver.findElement(searchField).sendKeys(text);
	}
	
	public void hitEnterOnSearch() {
		driver.findElement(searchField).sendKeys(Keys.ENTER);
	}
	
	public void clickLikeButton() {
		driver.findElement(likeButton).click();
	}
}
