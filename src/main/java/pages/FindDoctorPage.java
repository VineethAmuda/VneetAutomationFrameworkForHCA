package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindDoctorPage {

    WebDriver driver;

    public FindDoctorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(id = "txtSearchTerm")     
    private WebElement searchBox;

    @FindBy(id = "btnSearch")         
    private WebElement searchButton;

    @FindBy(css = ".search-results") 
    private WebElement resultsContainer;

    
    public void enterDoctorName(String doctorName) {
        searchBox.clear();
        searchBox.sendKeys(doctorName);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public boolean isResultsDisplayed() {
        try {
            return resultsContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
