import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;

public class FileUploadTest {
    @Test
    public void fileUploadTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        File file = new File("src/test/resources/text.txt");
        driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.cssSelector("#file-submit")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[text() = \"File Uploaded!\"]")).isDisplayed());
        driver.quit();
        softAssert.assertAll();
    }
}
