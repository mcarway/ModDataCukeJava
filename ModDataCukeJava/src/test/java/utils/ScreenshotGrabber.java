package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
//import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotGrabber {
	//Places screenshot in screenshot folder with name of page.

	public static void takeScreenshot(WebDriver driver) {
		String timeStamp;
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		String curDirectory=System.getProperty("user.dir");
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
			FileHandler.copy(scrFile, new File(curDirectory+"/screenshots/"+ timeStamp +".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Inserts screenshot into report as well as saves to screenshots folder.
	public static void reportScreenshot(WebDriver driver) throws Exception {
		String timeStamp;
		File screenShotName;
		String workingDir=System.getProperty("user.dir");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File(workingDir+"/screenshots/"+timeStamp+".png");
		//screenShotName = new File("/screenshots/"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);

		String filePath = screenShotName.toString();
		String path = "<img src=\"File:\\\\"+filePath+"\"/>";
		//String path = "<img src=\""+filePath+"\"/>";
		//Reporter.log(path);

	}

}
