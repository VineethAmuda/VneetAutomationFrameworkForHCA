package stepdefinitions.WebStepDef;

import pages.FindDoctorPage;
import utils.ScreenshotUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import hooks.Hooks;

import static org.testng.Assert.assertTrue;


public class FindDoctorSteps {

    WebDriver driver;
    FindDoctorPage findDoctorPage;

    public FindDoctorSteps() {
        this.driver = Hooks.driver; // Reuse driver from Hooks
        this.findDoctorPage = new FindDoctorPage(driver);
    }

    @When("User clicks on {string}")
    public void userClicksOn(String linkName) {
        System.out.println("Navigated to: " + linkName);
    }

    @And("User enters {string} in search box")
    public void userEntersInSearchBox(String doctorName) {
        findDoctorPage.enterDoctorName(doctorName);
    }

    @And("User clicks Search button")
    public void userClicksSearchButton() {
        findDoctorPage.clickSearch();
    }

    @Then("Search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        boolean result = findDoctorPage.isResultsDisplayed();
        ScreenshotUtil.captureScreenshot(driver, "FindDoctorResults");
        assertTrue(result, "Expected results to be displayed, but none found.");
    }
}

