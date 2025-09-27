package MentoringTestNg.Assignments.Day03;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtilities;
import utilities.TestBase;

public class T03task extends TestBase {
    /*
    Task 3:
    Go to https://claruswaysda.github.io/signln.html
    Do negative test with all scenarios using DataProvider
    Do it with all 3 ways (hardcoded, Faker, Excel)
    */

    //Hardcoded DataProvider
    @DataProvider
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"", ""},                     // empty username & password
                {"", "admin123"},             // empty username
                {"admin", ""},                // empty password
                {"wrongUser", "wrongPass"},   // both invalid
                {"admin", "wrongPass"},       // correct username, wrong password
                {"wrongUser", "admin123"}     // wrong username, correct password
        };
    }

    //Faker DataProvider
    @DataProvider
    public Object[][] invalidCredentialsFaker() {
        Faker faker = new Faker();
        return new Object[][]{
                {faker.name().username(), faker.internet().password()},
                {faker.name().username(), faker.internet().password()},
                {faker.name().username(), faker.internet().password()}
        };
    }

    //Excel DataProvider
    @DataProvider
    public Object[][] invalidCredentialsExcel() {
        ExcelUtilities eu = new ExcelUtilities("loginData.xlsx", "Sheet1");
        return eu.getExcelDataAsArray();
    }

    //Test with Hardcoded data
    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String username, String password) {
        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("signInBtn")).click();
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed(),
                "Error message should be displayed!");
    }

    //Test with Faker data
    @Test(dataProvider = "invalidCredentialsFaker")
    public void negativeLoginTestFaker(String username, String password) {
        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("signInBtn")).click();
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed(),
                "Error message should be displayed!");
    }

    // Test with Excel data
    @Test(dataProvider = "invalidCredentialsExcel")
    public void negativeLoginTestExcel(String username, String password) {
        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("signInBtn")).click();
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed(),
                "Error message should be displayed!");
    }
}
