package madision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//Webdriver object
	WebDriver driver;
	
	//Constructir
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Elements
	By myAccount = By.xpath("//*[@id='header']/div/div[2]/div/a/span[2]");
	By login = By.xpath("//*[@id='header-account']/div/ul/li[6]/a");
	By email = By.xpath("//*[@id='email']");
	By password = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");
	By forgotLink = By.xpath("//*[@id='login-form']/div/div[2]/div[1]/ul/li[3]/a");
	
	public void doLogin(String emailID, String pass) {
		driver.findElement(myAccount).click();
		driver.findElement(login).click();
		driver.findElement(email).sendKeys(emailID);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
	public void forgotLink() {
		driver.findElement(myAccount).click();
		driver.findElement(login).click();
		driver.findElement(forgotLink).click();
	}
}
