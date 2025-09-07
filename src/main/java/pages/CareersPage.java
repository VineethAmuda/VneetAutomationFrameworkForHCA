package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {

    WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   
    @FindBy(tagName = "h1")  
    private WebElement careersHeader;

    
    public boolean isCareersPageDisplayed() {
        return careersHeader.getText().contains("Careers")
                || driver.getCurrentUrl().contains("careers");
    }
}

