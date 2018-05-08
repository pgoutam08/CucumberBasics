package runner;

import java.io.File;
import java.util.Properties;

import com.cucumber.listener.Reporter;

//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//public constant PATH = "C:/Users/pattargv/eclipse-workspace/CucumberBasics";

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:/Users/pattargv/eclipse-workspace/CucumberBasics/src/test/java/Features"}, 
format = {"json:C:/Users/pattargv/eclipse-workspace/CucumberBasics/target/cucumber.json", 
		"html:C:/Users/pattargv/eclipse-workspace/CucumberBasics/target/site/cucumber-pretty"}, glue = "Steps")

public class TestRunner extends AbstractTestNGCucumberTests{

	public static void reportSetup()
	{
		//Reporter.loadXMLConfig(new File("src/test/resource/extent-config.xml"));
		
		// To get all system property files
		
		Properties p = System.getProperties();
		p.list(System.out);
		
	}
	
	

}
