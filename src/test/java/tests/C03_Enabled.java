package tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C03_Enabled {
    @Test
    void test01(){
        System.out.println("test01");
    }
    @Test(enabled = false)
    void test02(){
        System.out.println("test02");
    }
    @Test
    @Ignore
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
