package Steps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransform;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginStep extends BaseUtil{

	public static void main(String[] args) {
		
		


	}
	
	private BaseUtil base;
	
	public LoginStep(BaseUtil base) {
		this.base = base;
		
	}

	
	
	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Throwable {
	    
		System.out.println("Navigate to Login Page");
		base.webdriver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
	}
	
	/*
	@And("^I enter the Users email address as Email:([^\"]*)$")
	public void i_enter_the_Users_email_address_as_Email_admin(@Transform(EmailTransform.class) String email) throws Throwable {

		System.out.println("The User Email ID is: " + email);
		
		
	}
	
	
	@And("^I verify the count of my salary digits for JMD ([^\\\"]*)$")
	public void i_verify_the_count_of_my_salary_digits_for_Rs(@Transform(SalaryCountTransform.class) int salary) throws Throwable {

		System.out.println("The count of Salary digits is: " + salary);
			
	}

	*/
	
	@And("^I enter the following for Login$")
	public void i_enter_the_username_and_password(DataTable table) throws Throwable {
			/*System.out.println("Given");
			 List<List<String>> data = table.raw();
		
			
			System.out.println(data.get(1).get(0).toString());
			System.out.println(data.get(1).get(1).toString());
			
			*/
	//	User u = new User();
		
		
		List<User> users = new ArrayList<User>();
		
		users = table.asList(User.class);
		
		LoginPage page = new LoginPage(base.webdriver);
		
		for (User user: users)
		{
			page.Login(user.username, user.password);
			
			//System.out.println("The user name is :"+ user.username);
			//System.out.println("THe password is: "+ user.password);
			
		}
		
		
	}
	
	
	public class User {
		
		public String username;
		public String password;
		public User(String userName, String passWord) {
			username = userName;
			password = passWord;
			
			
		}
		
	}

	@And("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
	 
		//System.out.println("Click Login Button");
		//base.webdriver.findElement(By.name("Login")).submit();
		LoginPage page = new LoginPage(base.webdriver);
		
		//Wait for the button to load
		Thread.sleep(3000); // not a good idea to use 
		page.ClickLogin();
	}

	@Then("^I should see the userform page$")
	public void i_should_see_the_userform_page() throws Throwable {
	
		//System.out.println("Login Successful and Inside UserForm");
		//System.out.println("The driver is: "+base.StepInfo);
		
		Assert.assertEquals(base.webdriver.findElement(By.id("Initial")).isDisplayed(), true);
	}

	
}
