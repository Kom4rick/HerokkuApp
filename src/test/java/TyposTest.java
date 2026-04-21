import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TyposTest {
    @Test
    public void typoCheck() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/typos");

        driver.findElement(By.tagName("p"));

        String text = null;
        int i = 0;
        while (i < 7) {
            driver.navigate().refresh();
            text = driver.findElement(By.xpath("(//p)[2]")).getText();
            i++;
            Thread.sleep(1000);
            softAssert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");
        }
        driver.quit();
        softAssert.assertAll();
    }
}
