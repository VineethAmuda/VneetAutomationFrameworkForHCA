package stepdefinitions.WebStepDef;

import pages.CareersPage;
import utils.ScreenshotUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import hooks.Hooks;

import static org.testng.Assert.assertTrue;

public class CareersSteps {

    WebDriver driver;
    CareersPage careersPage;

    public CareersSteps() {
        this.driver = Hooks.driver;
        this.careersPage = new CareersPage(driver);
    }

    @When("User clicks on {string}")
    public void userClicksOn(String linkName) {
        System.out.println("Clicked on: " + linkName);
    }

    @Then("Careers page should open")
    public void careersPageShouldOpen() {
        boolean result = careersPage.isCareersPageDisplayed();
        ScreenshotUtil.captureScreenshot(driver, "CareersPage");
        assertTrue(result, "Careers page was not displayed!");
    }
}

