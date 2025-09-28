package MentoringTestNg.Day04.tests;
import MentoringTestNg.Day04.pages.ClaruswaySdaPage;
import org.testng.annotations.Test;
import utilities.Driver;

public class T01WebTAbleRecordManagementFluentPage {
            /*
        Go to https://claruswaysda.github.io/addRecordWebTable.html
        //https://claruswaysda.github.io/
        Add 5 records
        Delete first record you created.
        (Use Fluent POM and don't use any index in locators)
       */
    @Test
    public void test01() {
        Driver.getDriver().get("https://claruswaysda.github.io");
        ClaruswaySdaPage sdaPage = new ClaruswaySdaPage();
        sdaPage
                .clickWebTable()
                .enterFakeRecord(5)
                .deleteLastAddedRecord();
    }
}
