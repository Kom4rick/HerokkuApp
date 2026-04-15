import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownTest {

    @Test
    public void dropDownCheck() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement webElement = driver.findElement(By.id("dropdown"));

        Select select = new Select(webElement);
        List<WebElement> elements = select.getOptions();
        Assert.assertEquals(elements.size(), 3);

        WebElement element = elements.get(1);
        String value = element.getAttribute("value");
        select.selectByValue(value);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");

        element = elements.get(2);
        value = element.getAttribute("value");
        select.selectByValue(value);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");

        driver.quit();
    }
}
