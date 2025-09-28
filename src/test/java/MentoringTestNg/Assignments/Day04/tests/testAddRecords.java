package MentoringTestNg.Assignments.Day04.tests;
import MentoringTestNg.Assignments.Day04.pages.AddRecords;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class testAddRecords {
    @DataProvider(name = "recordData")
    public Object[][] recordData() {
        return new Object[][]{
                {"Ali", "25", "USA"},
                {"Sara", "30", "Canada"},
                {"Omar", "40", "Germany"},
                {"Lina", "35", "Australia"},
                {"Khalid", "28", "UK"}
        };
    }

    @Test(dataProvider = "recordData")
    public void addRecordTest(String name, String age, String country) {
        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");

        AddRecords addRecords = new AddRecords();
        addRecords.enterName(name)
                .enterAge(age)
                .selectByVisibleText(country)
                .clickAddRecords();

        String lastRowText = Driver.getDriver()
                .findElement(org.openqa.selenium.By.xpath("//tbody/tr[last()]"))
                .getText();

        Assert.assertTrue(lastRowText.contains(name));
        Assert.assertTrue(lastRowText.contains(age));
        Assert.assertTrue(lastRowText.contains(country));
    }
}
