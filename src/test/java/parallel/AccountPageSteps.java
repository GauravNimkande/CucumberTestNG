package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPages;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	
	private AccountPages accountPage;

@Given("user has already login into the application")
public void user_has_already_login_into_the_application(DataTable dataTable) {
	
	List<Map<String, String>> credList= dataTable.asMaps();
	
	String UserName=credList.get(0).get("username");
	String Password=credList.get(0).get("password");
	
	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	accountPage=loginpage.doLogin(UserName, Password);
	
}

@Given("user is on account page")
public void user_is_on_account_page() {
	String Title=accountPage.getAccountpageTitle();
	System.out.println("Accounts page title is :"+ Title);
}

@Then("user gets account section")
public void user_gets_account_section(DataTable sectionTable) {
	List<String>expSectionTable=sectionTable.asList();
	System.out.println("Expected account Section list "+ expSectionTable);
	
	List<String> actualSectionList=accountPage.getAccountsSectionList();
	System.out.println("Actual account Section list "+ actualSectionList);
	
}

@Then("account section count should be {int}")
public void account_section_count_should_be(Integer ExpectedAccountSectionCount) {
	Assert.assertTrue(accountPage.getaccountSectionCount()==ExpectedAccountSectionCount);
}

}
