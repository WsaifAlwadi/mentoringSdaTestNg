package MentoringTestNg.Day05.Pages;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class T02_ParallelTestingDataProvider {
    /*
         Objective: Implement a data-driven test that runs -search functionality-
         with multiple search terms in parallel.

         Requirements:
         Create a data provider with at least 5 different search terms
         Enable parallel execution for the data provider

         https://www.amazon.com/

         Create a test method that accepts search terms and validates results
         Configure XML file with data-provider-thread-count of 2
         Expected Output: Each search term should be tested simultaneously in separate threads
     */
    @DataProvider(name = "data", parallel = true)
    public Object[][] myDataProvider() {
        return new Object[][] {
                {"Apple"},
                {"Jane"},
                {"Peter"},
                {"Tom"},
                {"Alice"}
        };
    }

    @Test(dataProvider = "data")
    public void searchWord(String word) {
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        Driver.getDriver().get("https://www.amazon.com");
        amazonHomePage.clickSubmit();
        amazonHomePage.searshWord(word);
        amazonHomePage.SearchBtn();


    }

}
