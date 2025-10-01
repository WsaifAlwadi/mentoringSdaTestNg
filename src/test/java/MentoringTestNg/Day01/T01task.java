package MentoringTestNg.Day01;

import org.testng.annotations.*;

public class T01task {
    //Task 1: Basic TestNG Setup and Annotations
    //Objective: Create a TestNG class demonstrating annotation hierarchy
    //Requirements:
    //Create a TestNG class called AnnotationHierarchyTest
    //Implement all TestNG annotations (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod,
    //@Test, @AfterMethod, @AfterClass, @AfterTest, @AfterSuite)
    //Add print statements in each method to observe execution order
    //Create  test methods
    //Run the test and analyze console output
    @BeforeSuite
    public void beforeSuite() {
        System.out.println(" before all the suite");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @Test
    public void testMethod1() {
        System.out.println("Test01");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test02");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
    }
}
