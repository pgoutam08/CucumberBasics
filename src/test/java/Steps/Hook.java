package Steps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

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
		
		//System.setProperty("webdriver.firefox.driver", "C:/Automation/firefox installer.exe");
		//System.setProperty("webdriver.gecko.driver","C:/Users/pattargv/AppData/Local/Mozilla Firefox/firefox.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        base.webdriver = new FirefoxDriver(capabilities);
		//base.webdriver = new FirefoxDriver();
		
		
	}
	
	@After
	public void TearDownTest(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//take screenshot
			
			
		}
		System.out.println("Closing the browser");
		base.webdriver.close();
	}
}
