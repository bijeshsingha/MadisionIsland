package madision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
	// Webdriver object
	WebDriver driver;

	// Constructor
	public SignUp(WebDriver driver)
		{
			this.driver=driver;
		}

	// Elements
	By myAccount = By.xpath("//*[@id='header']/div/div[2]/div/a/span[2]");
	By signUp = By.xpath("//*[@id='header-account']/div/ul/li[5]/a");
	By fName = By.xpath("//*[@id='firstname']");
	By lName = By.xpath("//*[@id='lastname']");
	By email = By.xpath("//*[@id='email_address']");
	By password = By.xpath("//*[@id='password']");
	By confirmPassword = By.xpath("//*[@id='confirmation']");
	By rButton = By.xpath("//*[@id='form-validate']/div[2]/button/span/span");
	
	public void doSignUp(String emailID) {
		driver.findElement(myAccount).click();
		driver.findElement(signUp).click();
		driver.findElement(fName).sendKeys("Bijesh");
		driver.findElement(lName).sendKeys("Singha");
		driver.findElement(email).sendKeys(emailID);
		driver.findElement(password).sendKeys("password");
		driver.findElement(confirmPassword).sendKeys("password");
		driver.findElement(rButton).click();
	}
}
