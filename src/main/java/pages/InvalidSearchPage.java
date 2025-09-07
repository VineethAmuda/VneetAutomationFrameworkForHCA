package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidSearchPage {

    WebDriver driver;

    public InvalidSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(id = "txtSearchTerm")   
    private WebElement searchBox;

    @FindBy(id = "btnSearch")       
    private WebElement searchButton;

    @FindBy(css = ".no-results")    
    private WebElement noResultsMessage;

    
    public void enterInvalidDoctorName(String invalidName) {
        searchBox.clear();
        searchBox.sendKeys(invalidName);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public boolean isNoResultsDisplayed() {
        return noResultsMessage.isDisplayed();
    }
}

