package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C14_CrossBrowserTesting extends TestBase {
    /*
    Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    Enter username and password
    Click on login
    Assert that you are logged in
     */
    @Test
    void crossBrowserTesting() {

//        Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        Enter username and password
        driver.findElement(By.name("username")).sendKeys("Admin");
        WebElement passwordInput = driver.findElement(By.name("password"));

        Assert.assertEquals(passwordInput.getAttribute("type"),"password");

        passwordInput.sendKeys("admin123");

//        Click on login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        Assert that you are logged in
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).isDisplayed());

    }

}