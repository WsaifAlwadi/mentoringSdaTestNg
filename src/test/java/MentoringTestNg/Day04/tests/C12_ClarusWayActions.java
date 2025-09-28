package MentoringTestNg.Day04.tests;

import MentoringTestNg.Day04.pages.FillFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C12_ClarusWayActions {
  /*  Go to https://claruswaysda.github.io/ActionsForm.html
    Fill form and submit
    Do all actions and assert
            */

    @Test
    public void testAddRecord() {


        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");
        FillFormPage fillFormPage = new FillFormPage();

        String alertText=
                fillFormPage
                        .fillName("Test")
                        .fillAge("25")
                        .fillOptions("it")
                        .fillInterest()
                        .fillGender()
                        .formSubmit()
                        .getAlertMessage();

        Assert.assertTrue(alertText.contains("Your passcode is:"));


        Driver.closeDriver();
    }
    @Test
    public void testAddRecord02() {


        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");
        FillFormPage fillFormPage = new FillFormPage();

        fillFormPage
                .fillName("Test")
                .fillAge("25")
                .fillOptions("it")
                .fillInterest()
                .fillGender()
                .formSubmit()
                .verifyPasscode();

        Driver.closeDriver();
    }
}
