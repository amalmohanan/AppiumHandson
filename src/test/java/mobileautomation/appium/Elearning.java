package mobileautomation.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class Elearning {
	@Test
	public void testUserList() throws MalformedURLException, InterruptedException {
		
		ChromeOptions chrome = new ChromeOptions();
		chrome.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		chrome.setCapability(MobileCapabilityType.DEVICE_NAME, "Amal");
        WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), chrome);
        
        driver.get("http://elearning.upskills.in/index.php");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin@123");
        driver.findElement(By.xpath("//button[@name='submitAuth']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'User list')])[1]")).click();
        
        Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table table-bordered data_table']")).isDisplayed());
        
      
	}

}
