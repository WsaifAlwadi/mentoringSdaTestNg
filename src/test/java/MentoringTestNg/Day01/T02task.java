package MentoringTestNg.Day01;

import org.testng.annotations.Test;

public class T02task {
    /*
    Requirements: Create a class called AttributePracticeTest Create 5 test methods with different priorities (1, 3, 2, 5, 4)
    Create one test method with enabled = false Create a test method with
     timeout of 3 seconds that includes Thread.sleep(2000)
      Create a test method with timeout of 1 second that includes Thread.sleep(2000)
      6 Add meaningful descriptions to all test methods
      Create test methods with groups: "smoke" , "regression" , "api"
*/

    @Test(priority = 1, description = "Priority 1", groups = {"smoke"})
    public void testPriority1() {
        System.out.println("Priority 1 'Smoke group'");
    }
    @Test(priority = 3, description = "Priority 3", groups = {"regression"})
    public void testPriority3() {
        System.out.println("Priority 3 'Regression group'");
    }

    @Test(priority = 2, description ="Priority 2", groups = {"api"})
    public void testPriority2() {
        System.out.println("Priority 2 'API group'");
    }
    @Test(priority = 5, description = "Priority 5", groups = {"smoke", "regression"})
    public void testPriority5() {
        System.out.println("Priority 5 'Smoke & Regression group'");
    }

    @Test(priority = 4, description = "Priority 4", groups = {"api"})
    public void testPriority4() {
        System.out.println("Priority 4 'API group");
    }
    @Test(enabled = false, description = "Test is disabled")
    public void disabledTest() {
        System.out.println(" Test is disabled");
    }

    @Test (timeOut = 3000, description = "Timeout of 3 seconds and sleep of 2 seconds", groups = {"smoke"})
    public void testWithTimeoutPass() throws InterruptedException {
        System.out.println("3s timeout & sleeping 2s");
        Thread.sleep(2000);
    }

    @Test(timeOut = 1000, description = "Timeout of 1 second and sleep of 2 seconds", groups = {"regression"})
    public void testWithTimeoutFail() throws InterruptedException {
        System.out.println("1s timeout & sleeping 2s");
        Thread.sleep(2000);
    }

}
