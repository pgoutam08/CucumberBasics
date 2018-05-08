package Steps;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.LoginPage;

public class Hook extends BaseUtil {
	
	private BaseUtil base;
	public Hook(BaseUtil base) {
		this.base = base;
	}

	@Before
	public void InitializeTest()
	{
		System.out.println("Opening the Browser");
		System.out.println("Configuration setup");
		//Passing a dummy WebDriver instance
		//base.StepInfo = "ChromeDriver";
		
		System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver.exe");
		base.webdriver = new ChromeDriver();
		
		
		//System.setProperty("webdriver.gecko.driver","C:/Automation/firefox.exe");
		//base.webdriver = new FirefoxDriver();
		
		
	}
	
	@After
	public void TearDownTest(Scenario scenario) throws IOException
	{
		LoginPage page = new LoginPage(base.webdriver);
		if(scenario.isFailed())
		{
			//take screenshot
			page.GrabScreenShot(base.webdriver);
			
			
		}
		System.out.println("Closing the browser");
		//base.webdriver.close();
	}
}
