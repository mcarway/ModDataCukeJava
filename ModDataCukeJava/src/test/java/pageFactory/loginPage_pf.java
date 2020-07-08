package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.junit.Assert;

public class loginPage_pf {
	WebDriver driver;
	
	public loginPage_pf(WebDriver driver){
		this.driver=driver;
		//This pauses and waits for ajax controls to load.
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(id = "name")
	WebElement txtUsername;
	
	@FindBy(id = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//div[2]/div/div[2]")
	WebElement txtPWMessage;

	@FindBy(xpath = "//div/div/div[2]")
	WebElement txtUsernameMessage;
	
	@FindBy(className = "sign-up")
	public WebElement btnSignup;

	@FindBy(id = "login")
	public WebElement btnLogin;
	
	@FindBy(id = "logo")
	WebElement lblTopLogo;

	@FindBy(tagName = "h1")
	WebElement lblMainHeader;

	@FindBy(tagName = "p")
	WebElement lblIntroPara;
	
	@FindBy(className = "sign-up")
	WebElement btnSignUp;
	
	@FindBy(tagName = "span")
	WebElement lblWatchDemos;

	@FindBy(xpath = "//*/div[@class='demos-links']/a/span")
	WebElement btnWebDemo;
	
	@FindBy(xpath = "//*/div[@class='demos-links']/a[2]/span")
	WebElement btnMobileDemo;
	
	@FindBy(xpath = "//*/div[@id='pageLogin']/h1")
	WebElement lblLoginTitle;

	@FindBy(xpath = "//*/div[@id='pageLogin']/p")
	WebElement lblLoginPara;

	@FindBy(xpath = "//*/div[@class='tp-input-wrapper']/small")
	WebElement lblPWHint;

	@FindBy(xpath = "//*/div[@class='tp-try']/span")
	WebElement lblFooterLabel;

	@FindBy(xpath = "//*/div[@class='tp-support-contact']/span")
	WebElement lblFooterEmail;

	@FindBy(xpath = "//*/div[@class='contact-social']/div/a")
	WebElement linkTwitter;

	@FindBy(xpath = "//*/div[@class='contact-social']/div/a/img")
	WebElement logoTwitter;

	@FindBy(xpath = "//*/div[@class='contact-social']/div[2]/a")
	WebElement linkFacebook;

	@FindBy(xpath = "//*/div[@class='contact-social']/div[2]/a/img")
	WebElement logoFacebook;

	@FindBy(xpath = "//*/footer/div[@class='tp-try']/a")
	public WebElement btnFooterSignUp;

	//Start processing
	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void checkPassword(String password) {
		//Confirm password is NOT valid
		Assert.assertNotEquals("12345", password);
	}
	
	public void checkPageLocation(String page) {
		if(page.equals("login")) {
			Assert.assertEquals("Login", btnLogin.getText());
		}
		else {
			return;
		}
	}
	
	public void checkErrorMessage(String msgType) {
		if(msgType.equals("wrongPassword")) {
			Assert.assertEquals("Password is invalid", txtPWMessage.getText());
			System.out.println("Password was invalid says MIKE.");
		}
		else if(msgType.equals("wrongUsername")) {
			Assert.assertEquals("Please provide your full name", txtUsernameMessage.getText());
			System.out.println("Username was invalid says MIKE.");
		}
		else {
			return;
		}
	}
	
	public void checkUsername(String username) {
		//Confirm it's not empty
		Assert.assertEquals("", username);
	}
	
	public void checkBtnSignup() {
		Assert.assertEquals("FREE SIGN UP", btnSignup.getText());
	}
	
	public void checkLogo() {
		Assert.assertNotNull(lblTopLogo);
	}
	
	public void checkHeaderTitle() {
		Assert.assertEquals("Community Powered Test Automation", lblMainHeader.getText());
	}
	
	public void checkIntroPara() {
		String introPara=lblIntroPara.getText();
		Assert.assertTrue(introPara.contains("TestProject simplifies and enhances the use of leading")); 
	}
	public void checkSignUpButton() {
		Assert.assertEquals("FREE SIGN UP", btnSignUp.getText());
	}
	public void checkLblWatchDemos() {
		Assert.assertEquals("Watch demos:", lblWatchDemos.getText());
	}
	public void checkBtnWebDemo() {
		Assert.assertEquals("Web", btnWebDemo.getText());
	}
	public void checkBtnMobileDemo() {
		Assert.assertEquals("Mobile", btnMobileDemo.getText());
	}
	public void checkLoginFormTitle() {
		Assert.assertEquals("TestProject Example page", lblLoginTitle.getText());
	}
	public void checkLoginFormPara() {
		String loginPara=lblLoginPara.getText();
		Assert.assertTrue(loginPara.contains("This is the TestProject playground website.")); 
	}
	public void checkPWHint() {
		Assert.assertEquals("Hint: password is 12345", lblPWHint.getText()); 
	}
	public void checkFooterLabel() {
		Assert.assertEquals("Try TestProject:", lblFooterLabel.getText()); 
	}
	public void checkFooterEmail() {
		Assert.assertEquals("support@testproject.io", lblFooterEmail.getText()); 
	}
	public void checkTwitter() {
		//Confirm both the href and img attribute links are correct.
		Assert.assertEquals("https://twitter.com/TestProject_io", linkTwitter.getAttribute("href")); 
		Assert.assertEquals("https://example.testproject.io/web/assets/img/ri-twitter.svg", logoTwitter.getAttribute("src")); 
	}
	public void checkFacebook() {
		//Confirm both the href and img attribute links are correct.
		Assert.assertEquals("https://www.facebook.com/testproject.io", linkFacebook.getAttribute("href")); 
		Assert.assertEquals("https://example.testproject.io/web/assets/img/ri-facebook.svg", logoFacebook.getAttribute("src")); 
	}
	public void checkFooterSignUp() {
		//Confirm both the href and link text are correct.
		Assert.assertEquals("https://app.testproject.io/signup", btnFooterSignUp.getAttribute("href")); 
		Assert.assertEquals("FREE SIGN UP", btnFooterSignUp.getText());
	}

}
