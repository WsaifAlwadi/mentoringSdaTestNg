package MentoringTestNg.Assignments.Day03;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.time.Duration;

public class N03task extends TestBase {
    /*  Task 3: Negative Testing with Data Provider java
      Go to https://claruswaysda.github.io/signln.html
      Do negative test with all scenarios
      */
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidData() {
        return new Object[][]{
                {"", ""},
                {"validUser", ""},
                {"", "validPass"},
                {"wrongUser", "wrongPass"},
                {"validUser", "wrongPass"},
                {"wrongUser", "validPass"}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String username, String password) {

        driver.get("https://claruswaysda.github.io/signIn.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement userBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit']")));

        fillInput(userBox, username);
        fillInput(passBox, password);
        signInBtn.click();

        if (isAlertPresent(wait)) {
            validateAlert(driver.switchTo().alert());
        } else {
            validateHtml5Messages(userBox, passBox, username, password);
        }
    }

    private void fillInput(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    private boolean isAlertPresent(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void validateAlert(Alert alert) {
        String alertMsg = alert.getText();
        System.out.println("Alert: " + alertMsg);
        Assert.assertTrue(alertMsg.contains("Incorrect"), "Unexpected alert message!");
        alert.accept();
    }

    private void validateHtml5Messages(WebElement userBox, WebElement passBox, String username, String password) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (username.isEmpty()) {
            String msg = (String) js.executeScript("return arguments[0].validationMessage;", userBox);
            Assert.assertEquals(msg, "Please fill out this field.");
            return;
        }

        if (password.isEmpty()) {
            String msg = (String) js.executeScript("return arguments[0].validationMessage;", passBox);
            Assert.assertEquals(msg, "Please fill out this field.");
            return;
        }

        Assert.fail("No error feedback found!");
    }
}
