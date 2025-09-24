package MentoringTestNg.Assignments.Day02;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.time.Duration;

public class N01task extends TestBase {
    //1. Navigate to:
    //    https://www.amazon.com/
    // 2. Search for different keywords: Java, Selenium
    // 3. Assert that result text contains the searched word
    // 4. Run tests from XML file using parameter

    @Test
    @Parameters("searchKeyword")
    public void amazonSearchTest(String searchKeyword) {

        driver.get("https://www.amazon.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.findElement(By.xpath("//button[@alt='Continue shopping']")).click();
        } catch (Exception e) {
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));


        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchKeyword);
        driver.findElement(By.id("nav-search-submit-button")).click();


        String resultsText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(resultsText.toLowerCase().contains(searchKeyword.toLowerCase()),
                "Result text does not contain the search keyword!");
    }
}
