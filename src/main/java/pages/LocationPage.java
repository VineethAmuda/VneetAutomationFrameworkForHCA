package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationPage {

    WebDriver driver;

    public LocationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(tagName = "h1")   
    private WebElement locationHeader;

    
    public boolean isLocationPageDisplayed() {
        return locationHeader.getText().contains("Location")
                || driver.getCurrentUrl().contains("location");
    }
}
