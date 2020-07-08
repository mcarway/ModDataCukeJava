package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/Features/loginPageElements.feature", "src/test/resources/Features/loginPage.feature","src/test/resources/Features/homePage.feature"}, glue= {"stepDefinitions"},

//The plugin info generates the 3 types of reports on the fly and places them in the Target folder.
monochrome=true, 
plugin = {"pretty",
		"html:target/HTMLReports/report.html",
		"json:target/JSONReports/report.json",
		"junit:target/JUnitReports/report.xml"})
public class testRunner {

}
