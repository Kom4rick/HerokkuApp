import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest {

    @Test
    public void dynamicControlsTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        assertEquals(driver.findElement(By.xpath("//*[text() = \"It's gone!\"]")).getText(), "It's gone!");
        assertTrue(driver.findElements(By.xpath("//*[text() = \" A checkbox\"]")).isEmpty());

        Assert.assertFalse(driver.findElement(By.cssSelector("[type='text']")).isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        assertEquals(driver.findElement(By.xpath("//*[text() = \"It's enabled!\"]")).getText(), "It's enabled!");
        assertTrue(driver.findElement(By.cssSelector("[type='text']")).isEnabled());

        driver.quit();
    }
}
