import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputsTest {

    @Test
    public void inputsCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/inputs");

        driver.findElement(By.tagName("input")).sendKeys("tst");
        String text = driver.findElement(By.tagName("input")).getText();
        softAssert.assertEquals(text, "");

        driver.findElement(By.tagName("input")).sendKeys("10");
        String nums = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(nums, "10");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        nums = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(nums, "11");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        nums = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(nums, "10");

        driver.quit();
        softAssert.assertAll();
    }
}
