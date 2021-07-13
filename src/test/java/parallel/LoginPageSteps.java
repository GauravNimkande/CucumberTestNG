package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private String AccountPageTitle;
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_Page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	 	}

	@When("user get the title of the page title should be {string}")
	public void user_get_the_title_of_the_page_title_should_be(String ExpectedTitle) {
		String PageTitle=loginPage.GetLoginPagetitle();
		System.out.println("Login Page Tiltle is :"+PageTitle);
		
		Assert.assertTrue(PageTitle.contains(ExpectedTitle));
	}

	/*
	 * @When("User is on login password page") public void
	 * user_is_on_login_password_page() {
	 * System.out.println("\"User is on login password page"); }
	 */

	@Then("forget password link should be displayed")
	public void forget_password_link_should_be_displayed() {
		
		Assert.assertTrue(loginPage.ForgetPasswordLinkExist());
	}

	@When("user enters user name as {string}")
	public void user_enters_user_name_as(String Username) {
           loginPage.enterUsername(Username);
	}

	@When("user enters password is {string}")
	public void user_enters_password_is(String password) {
		loginPage.EnterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.ClickOnSignINbutton();
	}

	@Then("user get the title of the page")
	public void user_get_the_title_of_the_page() {
		 AccountPageTitle=loginPage.GetLoginPagetitle();
		System.out.println("Account Page Tiltle is :"+AccountPageTitle);
		

	}

	@Then("account page title should be {string}")
	public void account_page_title_should_be(String ExpectedAccountPagettl) {
		Assert.assertTrue(AccountPageTitle.contains(ExpectedAccountPagettl));
	}


}
