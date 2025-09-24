package MentoringTestNg.Assignments.Day01;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T05task {
    /*
           // Task 5: Soft Assertions Practice
            Test Case: Negative Login Test
        1. Navigate to https://claruswaysda.github.io/signin.html
        2. Enter username: "wronguser"
        3. Enter password: "wrongpass"
        4. Click Submit button
        5. Use soft assertions to verify:
             - JavaScript alert is displayed
             - Alert message text is "Incorrect username or password"
        Implementation Requirements
        - Create class SoftAssertLoginTest
        - Handle JavaScript alert using WebDriver's Alert interface
        - Use SoftAssert object for assertions
        - Include proper assertAll call
        - Add meaningful assertion messages
     */

    protected WebDriver driver;

    @BeforeClass
    void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    void testNegativeLogin() {
        driver.get("https://claruswaysda.github.io/signIn.html");


        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(alert, "Alert was not displayed after invalid login!");
        softAssert.assertEquals(actualAlertText,
                "Incorrect username or password",
                "Alert text does not match expected!");

        alert.accept();

        softAssert.assertAll();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
