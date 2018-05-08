package pages;

import java.io.File;
import java.io.IOException;
//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"userName\"]/p[1]/input")
	public WebElement txtUserName;
	
	@FindBy(how = How.NAME, using = "Password")
	public WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "Login")
	public WebElement btnLogin;
	
	@FindBy(how = How.ID, using = "Automation Tools")
	public WebElement menu;
	
	@FindBy(how = How.ID, using = "Selenium")
	public WebElement lnkHoverSelenium;
	
	@FindBy(how = How.ID, using = "Selenium WebDriver")
	public WebElement seleWebDriver;
	
	@FindBy(how = How.ID, using = "Initial")
	public WebElement txtInitial;
		
	@FindBy(how = How.ID, using = "FirstName")
	public WebElement txtFirst;
	
	@FindBy(how = How.LINK_TEXT, using = "HtmlPopup ")
	public WebElement lnkPopup;
	
	@FindBy(how = How.XPATH, using = "//form[@id='details']/table/tbody/tr[1]/td[2]/span/select")
	public WebElement SelectTitle;
	
	
	
	//Set username and password fields
	public void Login(String userName, String password) 
	{
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
	}
	
	//Click on Login button
	public void ClickLogin()
	{
		
		btnLogin.submit();
	}
	
	//Explicit wait
	public void ExplicitWait(WebDriver driver, String text)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.name(text)));
	}
	
	
	//Implicit Wait
	public void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}
	
	//Take Screen Shot
	public void GrabScreenShot(WebDriver driver) throws IOException
	{
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File("C:\\Automation\\Screenshots\\CucumberBasics\\Screenshot.jpg"));
	}
	
	// check for webelement to exist
	public boolean Exist(WebElement element)
	{
		try
		{
			return element.isDisplayed();
		}
		catch (NoSuchElementException e)
		{
			return false;
			
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	//Drag and drop option in same window
	public void DragAndDrop(WebDriver driver, WebElement srcElement, WebElement dstElement)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(srcElement, dstElement);
	}
	
	public void Hover(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	// handle Mouse hover and click
	public void HoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick)
	{
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}
	
	//handle popup window 
	public void PopupWindow(WebDriver driver)
	{
		lnkPopup.click();
		for (String windowName: driver.getWindowHandles())
		{
			driver.switchTo().window(windowName);
		}
		
		
		//txtInitial.sendKeys("KK");
		//txtFirst.sendKeys("Goutam");
		
	}
	
	// Click on hidden button
	public void HiddenButton(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement hiddenButton = driver.findElement(By.xpath("Path"));
		String script = "arguments[0].click();";
		
		js.executeScript(script, hiddenButton);
		
	}
	
}

