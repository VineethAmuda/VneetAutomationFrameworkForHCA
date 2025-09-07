package stepdefinitions.WebStepDef;

import pages.HomePage;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    private WebDriver driver;
    private HomePage homePage;

    @Given("User launches the browser")
    public void user_launches_the_browser() {
        driver = Hooks.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver was not initialized. Check Hooks class.");
        }
        homePage = new HomePage(driver);
    }

    @When("User navigates to HCA Healthcare home page")
    public void user_navigates_to_home_page() {
        driver.get("https://www.hcahealthcare.com/");
    }

    @Then("Home page title should be {string}")
    public void home_page_title_should_be(String expectedTitle) {
        String actual = driver.getTitle();
        Assert.assertTrue(actual != null && actual.contains(expectedTitle),
            "Expected title to contain: [" + expectedTitle + "] but was: [" + actual + "]");
    }

    @When("User clicks on {string}")
    public void user_clicks_on_link(String linkName) {
        if (homePage == null) {
            driver = Hooks.getDriver();
            homePage = new HomePage(driver);
        }
        homePage.clickLink(linkName);
    }

    @Then("User should be redirected to {string} page")
    public void user_should_be_redirected_to_page(String pageName) {
        String url = driver.getCurrentUrl().toLowerCase();
        String title = driver.getTitle().toLowerCase();
        Assert.assertTrue(url.contains(pageName.toLowerCase()) || title.contains(pageName.toLowerCase()),
            "Expected to be redirected to page containing '" + pageName + "'; URL: " + url + ", title: " + title);
    }

    
}
