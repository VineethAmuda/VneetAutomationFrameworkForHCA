package stepdefinitions.WebStepDef;

import pages.LocationPage;
import utils.ScreenshotUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import hooks.Hooks;

import static org.testng.Assert.assertTrue;

public class LocationSteps {

    WebDriver driver;
    LocationPage locationPage;

    public LocationSteps() {
        this.driver = Hooks.driver; // reusing same driver
        this.locationPage = new LocationPage(driver);
    }

    @When("User clicks on {string}")
    public void userClicksOn(String linkName) {
        System.out.println("Clicked on: " + linkName);
    }

    @Then("User should be redirected to location page")
    public void userShouldBeRedirectedToLocationPage() {
        boolean result = locationPage.isLocationPageDisplayed();
        ScreenshotUtil.captureScreenshot(driver, "LocationPage");
        assertTrue(result, "Location page was not displayed!");
    }
}

