package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.ContactusPages;
import com.qa.factory.DriverFactory;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactusPageSteps {
	
	private ContactusPages contactuspage=new ContactusPages(DriverFactory.getDriver());
	
	
	@Given("user is navigate to contact us page")
	public void user_is_navigate_to_contact_us_page() {
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	   
	}

	@When("user fills the from given sheetname {string} and rownumber {int}")
	public void user_fills_the_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("C://Users//gaurav.nimkande//Desktop//Automationtestdata.xlsx", sheetName);
		
		String heading = testData.get(rowNumber).get("subjectheading");
		String email = testData.get(rowNumber).get("email");
		String orderRef = testData.get(rowNumber).get("orderref");
		String message = testData.get(rowNumber).get("message");
		
		contactuspage.fillContactUsForm(heading, email, orderRef, message);
	    
	}

	@When("user clicks on snnd button")
	public void user_clicks_on_snnd_button() {
		contactuspage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMessage) {
		String actualSuccMessg = contactuspage.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
	}


}
