package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	public WebElement welcomeUser(WebDriver driver) {
		return driver.findElement(By.id("welcome"));
	}

	public List<WebElement> quickLaunchList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/descendant::span"));
	}

	public WebElement maintenanceTab(WebDriver driver) {
		return driver.findElement(By.id("menu_maintenance_purgeEmployee"));
	}

	public int dashboardFlow(WebDriver driver) throws InterruptedException {
//		WebDriverWait welcomeMsgWait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		welcomeMsgWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));

		String welcomeMsg = welcomeUser(driver).getText();
		System.out.println("Welcome Msg is: " + welcomeMsg);
		int actualQuickLaunchListCount=quickLaunchList(driver).size();
		for (WebElement e : quickLaunchList(driver)) {
			System.out.println("Element is: " + e.getText());
		}
		maintenanceTab(driver).click();
		Thread.sleep(2000);
		return actualQuickLaunchListCount;
	}
}
