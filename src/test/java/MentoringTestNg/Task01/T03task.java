package MentoringTestNg.Task01;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T03task {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("WebDriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(description = "Open Yahoo")
    public void openYahoo() {
        driver.get("https://www.yahoo.com");

    }
    @Test(dependsOnMethods = {"openYahoo"}, description = "Open Bing")
    public void openBing() {
        driver.get("https://www.bing.com");
    }
    @Test(dependsOnMethods = {"openBing"}, description = "Open DuckDuckGo")
    public void openDuckDuckGo() {
        driver.get("https://www.duckduckgo.com");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
