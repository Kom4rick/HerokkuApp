import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest {

    @Test
    public void fileDownloadTest() throws InterruptedException {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()=\"test-file.txt\"]")).click();
        Thread.sleep(5000);

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches("test-file.txt")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();

        driver.quit();
    }
}
