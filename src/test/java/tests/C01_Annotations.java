package tests;
import org.testng.annotations.*;

public class C01_Annotations {
    @BeforeSuite
    void beforeSuite(){
        System.out.println("@BeforeSuite");
    }
    @AfterSuite
    void AfterSuite(){
        System.out.println("@AfterSuite");
    }
    @BeforeTest
    void BeforeTest(){
        System.out.println("@BeforeTest");
    }
    @BeforeClass
    void BeforeClass(){
        System.out.println("@BeforeClass");
    }
    @AfterTest
    void  AfterTest(){
        System.out.println("@AfterTest");
    }
    @AfterClass
    void  AfterClass(){
        System.out.println("@AfterClass");
    }
    @BeforeMethod
    void  BeforeMethod(){
        System.out.println("@BeforeMethod");
    }
    @AfterMethod
    void  AfterMethod(){
        System.out.println("@AfterMethod");
    }
    @BeforeGroups
    void  BeforeGroups(){
        System.out.println("@BeforeGroups");
    }
    @AfterGroups
    void  AfterGroups(){
        System.out.println("@AfterGroups");
    }

    @Test
    void test01(){
        System.out.println("test01");
    }
    @Test
    void test02(){
        System.out.println("test02");
    }
    @Test
    void test03(){
        System.out.println("test03");

    }
    @Test
    void test04(){
        System.out.println("test04");

    }
    @Test
    void test05(){
        System.out.println("test05");

    }

}
