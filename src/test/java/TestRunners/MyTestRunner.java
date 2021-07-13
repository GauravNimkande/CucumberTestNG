package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	       // features = {"src/test/java/Apppfeature"}
	        		features = "src\\test\\resources\\FeaturesFiles\\Contactus.feature",
	        		//monochrome=true,
	        		//dryRun=true,
	       glue = {"step_defination","AppHooks"},
	    		   plugin = {"pretty",
	    					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    					
	    			}
	        		//publish=true
			)
public class MyTestRunner {

}
