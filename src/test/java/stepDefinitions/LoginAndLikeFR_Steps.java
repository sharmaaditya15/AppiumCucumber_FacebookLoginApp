package stepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages_POM.FB_HomePage;
import pages_POM.FB_LoginPage;

public class LoginAndLikeFR_Steps {

	private WebDriver driver;
	String path;

	
	
	@Before
	public void setUp() throws MalformedURLException {
		path = System.getProperty("user.dir");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability(MobileCapabilityType.VERSION, "11");
		cap.setCapability("browserName", "Chrome");

		/* ----- If you are running in native mobile app-----
		 * 
		 * cap.setCapability("app", path+"//app//facebook-295-0-0-12-119.apk"); 
		 * comment/remove the line(39) for browserName  
		 * 
		 * 
		*/
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("user opens the Facebook")
	public void openFacebook() {
		driver.get("https://m.facebook.com");
		
		/* ----- In case of Native mobile app , this method can be removed-----*/
	}

	@When("enter username (.*) and password (.*)")
	public void enterCredentials(String username, String password) {
		FB_LoginPage login = new FB_LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
		/* ----- If you are running in native mobile app-----
		 * 
		 * driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Username']")).sendKeys(username);
		 * driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']")).sendKeys(password);
		 * 
		 * 
		*/
		
		

	}

	@When("click on Login button")
	public void clickLoginButton() throws InterruptedException {
		FB_LoginPage login = new FB_LoginPage(driver);
		login.clickLoginButton();
		
		/* ----- If you are running in native mobile app-----
		 * 
		 * driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="Log In"]")).click();
		 * 
		*/
	}

	@When("search for (.*) and hit enter")
	public void searchText(String text) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[name='Search']")));

		FB_HomePage homePage = new FB_HomePage(driver);
		homePage.clickOnSearchButton();
		homePage.enterSearchText(text);
		homePage.hitEnterOnSearch();


		/* ---- Not able to locate the Web element for Search button in native mobile app , hence the used it in the browser----*/
		
	}

	@Then("click on Like button")
	public void clickLikeButton() {
		FB_HomePage homePage = new FB_HomePage(driver);
		homePage.clickLikeButton();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
