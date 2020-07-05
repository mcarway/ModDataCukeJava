
package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*; 
import io.github.bonigarcia.wdm.WebDriverManager;




public class testSteps_PF { 
	WebDriver driver=null;
	loginPage_pf login;
	homePage_PF home;
	Scenario scenario;
	String username;
	String password="";
	Boolean passValid;
	String msgType;

	@Before()
	public void setup(Scenario scenario) {
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		login = new loginPage_pf(driver);
		home = new homePage_PF(driver);

		//These 3 lines set up our screenshot utility. 
		this.scenario=scenario; //This is only if you want to use scenario more globally.
		Utility.message = scenario; //Passes our scenario to the utility.
		Utility.driver = driver; //Passes our driver to the utility.
	}

	@Given("browser is open") 
	public void browser_is_open() {
//		Utility.printRunDate();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); }

	@And("user is on login page") 
	public void user_is_on_login_page() {
		driver.navigate().to("https://example.testproject.io/web"); 
	}
	
	@When("^user enters '(.*?)' and '(.*?)'$") 
	public void	user_enters_username_and_password(String username, String password) throws InterruptedException { 
		this.username=username;
		this.password=password;
		login.enterUsername(username);
		login.enterPassword(password);
		Utility.takeAShot();
	}

	@And("user clicks login") 
	public void user_clicks_login() {
		login.clickLogin();
	}

	@Then("user is directed to the home page") 
	public void user_is_directed_to_the_home_page() throws InterruptedException {
		home.checkLogoutIsDisplayed();
		Utility.takeAShot();
	}

	//===== Test invalid login credentials here =========
	
//	@When("^invalid '(.*?)' and '(.*?)' are entered$")
//	public void invalid_username_and_password_are_entered(String username, String password) {
//		System.out.println("I'm inside invalid credentials.");	
//		this.username=username;
//		this.password=password;
//		login.enterUsername(username);
//		login.enterPassword(password);
//		Utility.takeAShot();
//}

	@And ("password is invalid")
	public void password_is_invalid() {
		login.checkPassword(password);
		msgType="wrongPassword";
	}

	@And ("username is invalid")
	public void username_is_invalid() {
		login.checkUsername(username);
		msgType="wrongUsername";
	}

	
	@Then("user remains on login page")
	public void user_remains_on_login_page() {
		login.checkPageLocation("login");

	}

	@And("user receives proper error messages")
	public void user_receives_proper_error_messages() {
		login.checkErrorMessage("msgType");
		Utility.takeAShot();

	}




	// ================ Test form data entry feature ==========================

	@Given("user is logged in and on homepage")
	public void user_is_logged_in_and_on_homepage() throws InterruptedException {
		Utility.printRunDate();

		driver.navigate().to("https://example.testproject.io/web"); 
		login.enterUsername("Mike Smith");
		login.enterPassword("12345");

		login.clickLogin();
	}

	@And("^subscriber inputs '(.*?)' '(.*?)' '(.*?)' and '(.*?)' in all address fields$")
	public void subscriber_inputs_country_address_email_and_phone_in_all_address_fields(String country, String address, String email, String phone) throws InterruptedException {

		home.selectCountry(country);
		home.enterAddress(address);
		home.enterEmail(email);
		home.enterPhone(phone);

		Utility.takeAShot();

		Thread.sleep(3000);

	}

	@And("user clicks save button")
	public void user_clicks_save_button() {
		home.clickSave();
	}

	@Then("the saved message appears")
	public void the_saved_message_appears() throws InterruptedException {
		home.checkSavedIsDisplayed();
		Utility.takeAShot();

		Thread.sleep(3000);
	}
	@Then("user should see test project logo")
	public void user_should_see_test_project_logo() {
		login.checkLogo();
	}
	@And("user should see bold title and introductory paragraph")
	public void user_should_see_bold_title_and_introductory_paragraph() {
		login.checkHeaderTitle();
		login.checkIntroPara();
	}		
	
	@And("user should see free sign up button")
	public void user_should_see_free_sign_up_button() {
		login.checkSignUpButton();
	}
	
	@And("user should see watch demos label")
	public void user_should_see_watch_demos_label() {
		login.checkLblWatchDemos();
	}
	@Then("user should see bold title in login form")
	public void user_should_see_bold_title_in_login_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should see description text in login form")
	public void user_should_see_description_text_in_login_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should see password hint text in login form")
	public void user_should_see_password_hint_text_in_login_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should see try test project label in footer")
	public void user_should_see_try_test_project_label_in_footer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should see support email address in footer")
	public void user_should_see_support_email_address_in_footer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




	@After()
	public void tearDown() throws InterruptedException, IOException {
		if(scenario.isFailed()) {
			Utility.takeAShot();
		}

		driver.quit();
	}
}


