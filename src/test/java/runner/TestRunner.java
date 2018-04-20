package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:/Users/pattargv/eclipse-workspace/CucumberBasics/src/test/java/Features"}, 
format = {"json:C:/Users/pattargv/eclipse-workspace/CucumberBasics/target/cucumber.json", 
		"html:C:/Users/pattargv/eclipse-workspace/CucumberBasics/target/site/cucumber-pretty"}, glue = "Steps")

public class TestRunner extends AbstractTestNGCucumberTests{

	
	
}
