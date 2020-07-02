package stepDefinitions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;

public class Utility {

	public static Scenario message;   
	public static WebDriver driver;


	public static void takeAShot() {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		message.attach(screenshot, "image/png","screenshot.png");
	}
	public static void printRunDate() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 

		message.log("Run date: "+timeStamp);
		
	}
}

