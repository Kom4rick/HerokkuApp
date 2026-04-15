import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckboxesTest {

    @Test
    public void checkboxesCheck() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //проверка статуса первого чекбокса
        boolean isCheck = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertFalse(isCheck);

        //изменение статуса первого чекбокса и проверка
        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        boolean isCheck1 = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertTrue(isCheck1);

        //проверка второго чекбокса
        boolean isCheck2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertTrue(isCheck2);

        //изменение статуса второго чекбокса и проверка
        driver.findElements(By.cssSelector("[type=checkbox]")).get(1).click();
        boolean isCheck3 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertFalse(isCheck3);

        driver.quit();
    }
}
