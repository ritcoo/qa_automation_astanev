import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lecture16Homework {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void BeforeTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow);
        String baseURL = "https://demo.automationtesting.in/Windows.html";
        driver.navigate().to(baseURL);

        driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']/button")).click();
        Thread.sleep(3000);

        //Switch to the newly-opened window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String actualResult = driver.findElement(By.xpath("//h1[@class='display-1 mt-0 mt-md-5 pb-1']")).getText();
        Assert.assertEquals("Selenium automates browsers. That's it!", actualResult);

        driver.switchTo().window(mainWindow);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(baseURL, currentURL);
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Static.html");

        Actions actions = new Actions(driver);
        WebElement dragged = driver.findElement(By.id("node"));
        actions.moveToElement(dragged).perform();
        WebElement dropped = driver.findElement(By.id("droparea"));
        //actions.dragAndDrop(dragged, dropped).build().perform(); //it doesn't want to work so I did it with JS executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var dragged = arguments[0];\n" + "var dropped = arguments[1];\n" + "simulateHTML5DragAndDrop(dragged,dropped);", dragged, dropped);
        Thread.sleep(3000);

    }

    @AfterEach
    public void AfterTest() {
        driver.quit();
    }

}
