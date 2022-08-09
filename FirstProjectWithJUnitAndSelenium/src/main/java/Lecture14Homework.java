import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture14Homework {
    public WebDriver driver;

    @BeforeEach
    public void BeforeTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://todomvc.com/examples/vue/");
    }

    @Test
    public void Test1() throws InterruptedException {
        // Create one "todo" item and mark it as completed
        WebElement searchBox = driver.findElement(By.className("new-todo"));
        searchBox.sendKeys("test");
        searchBox.sendKeys(Keys.ENTER);
        WebElement checkBox = driver.findElement(By.className("toggle"));
        checkBox.click();

        // Verify that the item is checked/completed

        String expected = "todo completed";
        WebElement completed = driver.findElement(By.xpath("//ul[@class='todo-list']/li"));
        String actual = completed.getAttribute("class");
        Assert.assertEquals(expected, actual);
        Thread.sleep(3000);
    }

    @AfterEach
    public void AfterTest() {
        driver.quit();
    }
}
