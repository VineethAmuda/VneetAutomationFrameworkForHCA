package stepdefinitions.WebStepDef;

import pages.InvalidSearchPage;
import utils.ScreenshotUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import hooks.Hooks;

import static org.testng.Assert.assertTrue;

public class InvalidSearchSteps {

    WebDriver driver;
    InvalidSearchPage invalidSearchPage;

    public InvalidSearchSteps() {
        this.driver = Hooks.driver;
        this.invalidSearchPage = new InvalidSearchPage(driver);
    }

    @And("User enters {string} in search box")
    public void userEntersInvalidName(String invalidName) {
        invalidSearchPage.enterInvalidDoctorName(invalidName);
    }

    @And("User clicks Search button")
    public void userClicksSearchButton() {
        invalidSearchPage.clickSearch();
    }

    @Then("No results should be displayed")
    public void noResultsShouldBeDisplayed() {
        boolean result = invalidSearchPage.isNoResultsDisplayed();
        ScreenshotUtil.captureScreenshot(driver, "InvalidSearch");
        assertTrue(result, "Expected 'No results' message but it was not displayed.");
    }
}

