package day05_AlertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling2 {

	
	// getting error check after sometime
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
	}

	@Test
	public void alertTest() throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.name("//input[@name='uid']")).sendKeys("mngr604770");
		driver.findElement(By.name("//input[@name='password']")).sendKeys("nehAtej");
		driver.findElement(By.name("//input[@name='btnLogin']")).click();

		driver.findElement(By.xpath("//a[text()='Delete Account']")).click();
		
		driver.findElement(By.name("//input[@name='accountno']")).sendKeys("12345");
		driver.findElement(By.name("//input[@name='AccSubmit']")).click();

		Thread.sleep(3000);

		// switch to alert

		Alert al = driver.switchTo().alert();

		Assert.assertEquals(al.getText(), "Do you really want to delete this Account?");

		// to click OK on alert

		al.accept();
		
		Alert al2 =driver.switchTo().alert();
		Assert.assertEquals(al2.getText(), "Account does not exist");

		// to click OK on alert

		al2.accept();
		

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
