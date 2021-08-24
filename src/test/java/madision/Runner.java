package madision;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Runner {
	public WebDriver driver;
	public WebDriverWait wt;

	@BeforeMethod
	public void bm() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	@Test 
	public void homepage() {
		driver.get("http://demo-store.seleniumacademy.com/");
		Assert.assertTrue(driver.getTitle().equals("Madison Island"));
	}

	@Test(priority = 1, dependsOnMethods = "homepage")
	public void signUp() {
		//new SignUp(driver).doSignUp("singhabijesh7@gmail.com");
		//Assert.assertTrue(driver.getTitle().equals("My Account"));
	}

	@Test(priority = 2)
	public void loginValid() {
		new LoginPage(driver).doLogin("singhabijesh7@gmail.com", "password");
		Assert.assertTrue(driver.getTitle().equals("My Account"));
	}
	
	@Test(priority = 3)
	public void loginInvalid() {
		new LoginPage(driver).doLogin("singhabijesh7@gmail.com", "password123");
		Assert.assertTrue(driver.getTitle().equals("Customer Login"));
	}
	
	@Test(priority = 4)
	public void forgotPass() {
		new LoginPage(driver).forgotLink();
		Assert.assertTrue(driver.getTitle().equals("Forgot Your Password"));
	}

	@BeforeTest
	public void beforeTest() throws Exception, Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
