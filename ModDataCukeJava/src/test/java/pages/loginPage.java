package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	protected WebDriver driver;
	private By txtUserName = By.id("name");
	private By txtPassword = By.id("password");
	private By btnLogin = By.id("login");
	private By btnLogout = By.id("logout");
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		if(!driver.getTitle().contentEquals("TestProject Demo")) {
			throw new IllegalStateException("This is the wrong page. This page is "+driver.getCurrentUrl());
		}
	}
	
	public void enterUsername(String username) {
		driver.findElement(txtUserName).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}

	public void clickLogout() {
		driver.findElement(btnLogout).click();
	}

	public void checkLogoutIsDisplayed() {
		driver.findElement(btnLogout).isDisplayed();
	}

	public void loginValidUser(String username, String password) {
		driver.findElement(txtUserName).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
		driver.findElement(btnLogout).click();



		
	}

	
			

}
