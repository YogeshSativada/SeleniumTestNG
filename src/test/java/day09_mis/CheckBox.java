package day09_mis;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

    WebDriver driver;
                                                                                           //Get Attribute concept for 'checked' Attribute
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        driver = new ChromeDriver();
        driver.get("https://echoecho.com/htmlforms09.htm");
        driver.manage().window().maximize();
    }

    @Test
    public void waitsTest() throws IOException {
        // Assert checkbox states
        assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected(), "Milk checkbox is selected");
        assertTrue(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected(), "Butter checkbox is not selected");
        assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected(), "Cheese checkbox is selected");
    }

    @AfterMethod
    public void teardown() {
        // Quit the driver
        driver.quit();
    }
}
