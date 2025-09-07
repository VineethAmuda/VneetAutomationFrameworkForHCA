package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "target/screenshots/";

    public static String captureScreenshot(WebDriver driver, String fileName) {
        if (!(driver instanceof TakesScreenshot)) {
            throw new RuntimeException("Driver does not support screenshots");
        }

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        } catch (IOException e) {
            throw new RuntimeException("Could not create screenshot directory", e);
        }

      
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String safeFileName = fileName.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
        File destFile = new File(SCREENSHOT_DIR + safeFileName + "_" + timestamp + ".png");

        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }

        return destFile.getAbsolutePath();
    }
}
