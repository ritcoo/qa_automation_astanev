import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture12Homework {

    public WebDriver driver;

    @Test
    public void Test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/QA_Automation/MyExercises/FirstProjectWithJUnitAndSelenium/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(2500);
        driver.quit();
    }
}
