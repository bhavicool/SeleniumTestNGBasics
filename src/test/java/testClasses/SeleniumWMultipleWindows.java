package testClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

public class SeleniumWMultipleWindows {

    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();

        //Getting parent window
        String parentWindow=driver.getWindowHandle();
        System.out.println("Parent Window is: "+parentWindow);
        WebDriverWait welcomeMsgWait=new WebDriverWait(driver,10);
        welcomeMsgWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@name='MNCs']/descendant::a[text()='MNCs']")));
        driver.findElement(By.xpath("//span[@name='MNCs']/descendant::a[text()='MNCs']")).click();
        Thread.sleep(2000);

        //Getting all windows, navigating to child window and closing it
        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println("Total Window Size is: "+windowHandles.size());
        for(String window:windowHandles)
        {
            if(!parentWindow.equals(window))
            {
                driver.switchTo().window(window);
                System.out.println("Child window title is:"+driver.switchTo().window(window).getTitle());
                driver.close();
            }
        }

        //Switching back to parent window and closing it
        driver.switchTo().window(parentWindow);
        driver.close();
        Thread.sleep(3000);
    }
}
