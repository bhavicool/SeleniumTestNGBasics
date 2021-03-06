package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupingDemo {

    @Test(groups = {"Smoke"})
    public void testCase1() {
        System.out.println("in test case 1 of Smoke Group");
    }

    @Test(groups = {"Smoke"})
    public void testCase2() {
        System.out.println("in test case 2 of Smoke Group");
    }

    @Test(groups = {"Regression"})
    public void testCase4() {
        System.out.println("in test case 4 of Regression Group");
    }

    @Test(groups = {"Regression"})
    public void testCase5() {
        System.out.println("in test case 5 of Regression Group");
    }

    @Test
    public void testCase3() {
        System.out.println("in test case 3");
        Assert.assertEquals(2,3);
    }
}
