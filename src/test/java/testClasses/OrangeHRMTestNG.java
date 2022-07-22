package testClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.HomePage;
import page.MaintenancePage;


public class OrangeHRMTestNG {

    private WebDriver driver;
    HomePage homePage = new HomePage();
    DashboardPage dashboardPage = new DashboardPage();
    MaintenancePage maintenancePage = new MaintenancePage();

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Step to navigate to the application url
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        // Step to maximize browser window
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @Test
    public void testCase1() throws InterruptedException {
        homePage.loginFunctionality(driver);
        Thread.sleep(2000);

        int actualQuickLaunchListCount=dashboardPage.dashboardFlow(driver);
        Assert.assertEquals(actualQuickLaunchListCount,5);

        maintenancePage.maintenanceFlow(driver);
        Thread.sleep(3000);
    }
}
