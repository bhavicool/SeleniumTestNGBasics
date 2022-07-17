package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnotationAttributes {

    //Default priority is 0 and if many test cases have same priority then
    // they are executed alphabetically
    @Test(description = "First random test case", priority = 2)
    public void testCase1() {
        System.out.println("in test case 1");
    }
    // test case 2
    @Test(priority = 1)
    public void testCase2() {
        System.out.println("in test case 2");
    }

    @Test
    public void testCase3() {
        System.out.println("in test case 3");
        Assert.assertEquals(2,3);
    }

    @Test(dependsOnMethods = "testCase3")
    public void testCase4() {
        System.out.println("in test case 4");
    }

    @Test(enabled = false)
    public void testCase5() {
        System.out.println("in test case 5");
    }
}
