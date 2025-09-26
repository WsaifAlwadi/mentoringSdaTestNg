package tests;

import org.testng.annotations.Test;

public class T04_TimeOut {

    @Test(timeOut = 3000)
    void loginTest() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("loginTest");
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
