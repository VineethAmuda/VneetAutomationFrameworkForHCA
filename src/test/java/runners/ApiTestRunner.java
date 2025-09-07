package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/api-features",
    glue = {"com.org.automation.api.stepdefinitions"},
    plugin = {"pretty", "json:target/api-cucumber.json", "html:target/api-cucumber.html"},
    tags = "@APITest"
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {
	
}
