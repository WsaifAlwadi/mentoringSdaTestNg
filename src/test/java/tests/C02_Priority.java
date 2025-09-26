package tests;

import org.testng.annotations.Test;

public class C02_Priority {
    @Test(priority = 3)
    void test01(){
        System.out.println("test01");
    }
    @Test(priority = 1)
    void test02(){
        System.out.println("test02");
    }
    @Test(priority =2 )
    void test03(){
        System.out.println("test03");

    }
    @Test(priority = -1)
    void test04(){
        System.out.println("test04");

    }
    @Test(priority = 4)
    void test05(){
        System.out.println("test05");

    }
}
