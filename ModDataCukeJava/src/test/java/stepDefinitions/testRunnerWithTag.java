package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/featureWithTags/tags.feature", 
glue= {"stepDefinitions"},
//NOTE: If you use AND it means both tags have to be attached to the scenario.
tags= "@smoke or @sanity",

//The plugin info generates the 3 types of reports on the fly.
monochrome=true, 
plugin = {"pretty", "html:target/HTMLReports/report.html",
		"json:target/JSONReports/report.json",
		"junit:target/JUnitReports/report.xml"}

)

public class testRunnerWithTag {

}
