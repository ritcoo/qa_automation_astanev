import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lecture12HomeworkForMostBrowsers {

    public WebDriver driver;

    @Test
    public void Test1() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void Test2() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectPath+"/src/main/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void Test3() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectPath+"/src/main/resources/Drivers/operadriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void Test4() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.edge.driver", projectPath+"/src/main/resources/Drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(2500);
        driver.quit();
    }
}
