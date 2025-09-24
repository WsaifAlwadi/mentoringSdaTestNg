package MentoringTestNg.Assignments.Day01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class T04task {
    /*
            Test Case: Positive Login Test
        1. Navigate to https://claruswaysda.github.io/signIn.html
        2. Enter username: "admin"
        3. Enter password: "123"
        4. Click Submit button
        5. Use hard assertions to verify:

        New page URL is "https://claruswaysda.github.io/signIn.html"
        Page contains text "Employee Table"
        Implementation Requirements:
        Create class HardAssertLoginTest
        Use appropriate WebDriver setup and teardown
        Implement proper element locators
        Use meaningful assertion messages
     */

    protected WebDriver driver;
    @BeforeClass
    void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    void PositiveLogin(){
        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,
                "https://claruswaysda.github.io/signIn.html",
                "URL does not match after login!");

        Assert.assertTrue(driver.findElement(By.id("employeeHeader")).isDisplayed(), "Employee Table header is not displayed");
    }
    @AfterClass
    void tearDown() {

        driver.quit();
    }
}
