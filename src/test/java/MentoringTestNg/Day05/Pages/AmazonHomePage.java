package MentoringTestNg.Day05.Pages;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import utilities.Driver;


public class AmazonHomePage {
    By searchBy = By.id("twotabsearchtextbox");
    By searchBtnBy = By.id("nav-search-submit-button");
    By submitBtnBy = By.xpath("//button[@type='submit']");

    public AmazonHomePage clickSubmit() {
        Driver.getDriver().findElement(submitBtnBy).click();
        return this;
    }

    public AmazonHomePage searshWord(String word) {
        Driver.getDriver().findElement(searchBy).sendKeys(word);
        return this;
    }

    public AmazonHomePage SearchBtn() {
        Driver.getDriver().findElement(searchBtnBy).click();
        return this;
    }


}