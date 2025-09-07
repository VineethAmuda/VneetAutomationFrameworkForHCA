package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import utils.ScreenshotUtil;

public class Hooks {

    public static WebDriver driver;

    
    @Before
    public void setUp() {
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome");
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

            if ("chrome".equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                options.addArguments("--start-maximized");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }
        }
    }

    
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed() && driver != null) {
                
                String safeName = scenario.getName().replaceAll("[^a-zA-Z0-9-_\\.]", "_");
                try {
                    String path = ScreenshotUtil.captureScreenshot(driver, safeName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

    
    public static WebDriver getDriver() {
        return driver;
    }
}
