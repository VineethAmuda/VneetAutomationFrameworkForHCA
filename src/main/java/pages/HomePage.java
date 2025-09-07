package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Find a Doctor")
    private WebElement findDoctorLink;

    @FindBy(linkText = "Find a Location")
    private WebElement findLocationLink;

    @FindBy(linkText = "Careers")
    private WebElement careersLink;

    @FindBy(tagName = "h1")
    private WebElement header;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFindDoctor() {
        findDoctorLink.click();
    }

    public void clickFindLocation() {
        findLocationLink.click();
    }

    public void clickCareers() {
        careersLink.click();
    }

    
    public void clickLink(String linkName) {
        if (linkName == null) throw new IllegalArgumentException("linkName is null");

        switch (linkName.trim()) {
            case "Find a Doctor":
                clickFindDoctor();
                return;
            case "Find a Location":
                clickFindLocation();
                return;
            case "Careers":
                clickCareers();
                return;
            default:
                
                try {
                    driver.findElement(By.linkText(linkName)).click();
                } catch (Exception e) {
                    driver.findElement(By.partialLinkText(linkName)).click();
                }
        }
    }

    public String getHeaderText() {
        try {
            return header.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
