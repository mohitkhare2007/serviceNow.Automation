package serviceNow.serviceNow.Automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
	(
		strict = false,
		features = "src/test/resource",
		glue = {"serviceNow.serviceNow.Automation"},
		plugin = {"pretty", "json:target/cucumber.json", 
				  "html:target/site/cucumber-pretty"},
		tags = {"@tag15"},
		//tags = {"@tag21, @tag22"},
		monochrome = true
	)

public class TestRunner {

}