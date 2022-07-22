package testClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NaukriTest {

    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();
        WebDriverWait welcomeMsgWait=new WebDriverWait(driver,10);
        welcomeMsgWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@name='MNCs']/descendant::a[text()='MNCs']")));
        driver.findElement(By.xpath("//span[@name='MNCs']/descendant::a[text()='MNCs']")).click();
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
    }
}
