import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class Lecture15Homework {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void BeforeTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.automationtesting.in/Register.html");
    }

    @Test
    public void Test1() throws InterruptedException {

        WebElement dropDownSwitch = driver.findElement(By.linkText("SwitchTo"));
        dropDownSwitch.click();

        WebElement dropDownAlerts = driver.findElement(By.linkText("Alerts"));
        dropDownAlerts.click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.click().build().perform();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Alert with Textbox")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn-info")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Asen");
        Thread.sleep(3000);
        alert.accept();

        String actualResult = driver.findElement(By.id("demo1")).getText();
        Assertions.assertEquals("Hello Asen How are you today", actualResult);
    }
    @Test
    public void Test2() throws InterruptedException {
        WebElement dropDownSwitch = driver.findElement(By.linkText("SwitchTo"));
        dropDownSwitch.click();

        WebElement dropDownAlerts = driver.findElement(By.linkText("Frames"));
        dropDownAlerts.click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.click().build().perform();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("input")).click();
        driver.findElement(By.cssSelector("input")).sendKeys("Test");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Home")).click();
        Thread.sleep(3000);
        String actualResult = driver.getCurrentUrl();
        Assertions.assertEquals("https://demo.automationtesting.in/Index.html", actualResult);
    }

    @AfterEach
    public void AfterTest() {
        driver.quit();
    }

}
