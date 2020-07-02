package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class homePage_PF {
	WebDriver driver;
	//Select dropCountry;

	public homePage_PF(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "logout")
	WebElement btnLogout;
	
	@FindBy(id = "country")
	WebElement txtCountry;

	@FindBy(id = "address")
	WebElement txtAddress;

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(id = "phone")
	WebElement txtPhone;

	@FindBy(id = "save")
	WebElement btnSave;

	@FindBy(css = "span.tp-saved")
	WebElement lblSaved;

	
	public void checkLogoutIsDisplayed() {
		btnLogout.isDisplayed();
	}
	
	public void selectCountry(String country) {
		Select drpCountry = new Select(txtCountry);
		drpCountry.selectByVisibleText(country);

//		dropCountry = new Select(driver.findElement(By))
//		txtCountry.selectByVisibleText(country);
	}

	public void enterAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	public void clickSave() {
		btnSave.click();
	}

	public void checkSavedIsDisplayed() {
		Assert.assertEquals("Saved", lblSaved.getText());
	}

}
