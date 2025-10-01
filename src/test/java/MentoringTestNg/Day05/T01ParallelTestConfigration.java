package MentoringTestNg.Day05;

import MentoringTestNg.Day05.Pages.CLContactListPage;
import MentoringTestNg.Day05.Pages.CLHomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class T01ParallelTestConfigration {
    /*Task 1: Parallel Test Configuration
Objective: Create a parallel test suite that runs login tests on multiple browsers simultaneously.
Requirements:
Create a TestNG XML file with parallel execution at the method level
Set thread count to 3
Include at least 2 test classes: PositiveLoginTest and NegativeLoginTest
Configure timeout for each test method to 30 seconds
Expected Output: All tests should run in parallel, reducing total execution time.*/
    @Test
    void positiveLoginTest() {

        CLHomePage homePage = new CLHomePage();
        CLContactListPage contactListPage = new CLContactListPage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.email.sendKeys(ConfigReader.getProperty("cl_email"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        assert contactListPage.logout.isDisplayed();
        Driver.closeDriver();

    }
    @Test
    void navigaitiveLoginTest() {
        CLHomePage homePage = new CLHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(homePage.error));
        assert homePage.error.isDisplayed();
        Driver.closeDriver();
    }

}
