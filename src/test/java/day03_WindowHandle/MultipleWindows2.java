package day03_WindowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows2 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void multipleWindowsTest() throws InterruptedException {

		String homeWindowId = driver.getWindowHandle();

		/*
		 * new Actions(driver).moveToElement(driver.findElement(By.
		 * xpath("//a[text()='Sell on Pepperfry']")))
		 * .click(driver.findElement(By.xpath("//a[text()='Sell on Pepperfry']")))
		 * .build() .perform();
		 */

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,11500);");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='Sell on Pepperfry']")).click();

		Set<String> windowIds = driver.getWindowHandles();

		for (String handle : windowIds) {
            if (!handle.equals(homeWindowId)) {
                // Switch to the new window
                driver.switchTo().window(handle);

                // Perform operations on the new window
                System.out.println("New Window Title: " + driver.getTitle());
            }
            }
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Reyaz");

		Thread.sleep(3000);

		driver.switchTo().window(homeWindowId);

		Thread.sleep(3000);

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
