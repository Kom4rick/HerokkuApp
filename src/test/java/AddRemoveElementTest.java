import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRemoveElementTest {

    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        int size = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size, 2);

        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int size1 = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size1, 1);

        driver.quit();
    }
}
