package MentoringTestNg.Assignments.Day04.pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AddRecords {
    //name age select addBTNBy
    By nameBy = By.id("nameInput");
    By ageBy = By.id("ageInput");
    By selectBy = By.id("countrySelect");
    By addRecordButtonBy = By.xpath("//button[.='Add Record']");
    By addedRecordsBy = By.xpath("//tbody/tr");

    public AddRecords enterName(String name){
        Driver.getDriver().findElement(nameBy).sendKeys(name);
        return this;
    }
    public AddRecords enterAge(String age){
        Driver.getDriver().findElement(ageBy).sendKeys(age);
        return this;
    }
    public AddRecords selectByVisibleText(String country){
        new Select(Driver.getDriver().findElement(selectBy))
                .selectByVisibleText(country);
        return this;
    }
    public AddRecords selectByByIndex(int index){
        new Select(Driver.getDriver().findElement(selectBy))
                .selectByIndex(index);
        return this;
    }
    public AddRecords clickAddRecords(){
        Driver.getDriver().findElement(addRecordButtonBy).click();
        return this;
    }
    public AddRecords addFakeRecord(){
        Faker faker = new Faker();
        enterName(faker.name().username()).
                enterAge(String.valueOf(faker.number().numberBetween(18, 60))).
                selectByByIndex(faker.number().numberBetween(1, 5)).
                clickAddRecords();
        return this;
    }
    public AddRecords multipleFakeRecords(int count){
        for (int i = 0; i < count; i++){
            addFakeRecord();
        }
        return this;
    }

}
