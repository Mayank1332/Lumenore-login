package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDashboard {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public  void setUp() {
		WebDriverManager.chromedriver().setup(); 
		// create a new instance of chrome driver class
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,10);
		driver.get("https://insights.lumenore.com/testautomate/#/");
		
		driver.manage().window().maximize();
	//	Thread.sleep(5000);
	//	driver.findElement(By.id("userName")).sendKeys("fouzanj@netlink.com");
		WebElement users=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		users.sendKeys("fouzanj@netlink.com");
		//find password
		//driver.findElement(By.id("password")).sendKeys("Testing@1234");
		WebElement pass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		pass.sendKeys("Testing@1234");
		
		// find login button
		//driver.findElement(By.xpath("//button[@class='ant-btn lumenore-btn login-form-button ant-btn-primary ant-btn-block']")).click();
		WebElement buttons=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn lumenore-btn login-form-button ant-btn-primary ant-btn-block']")));
	      buttons.click();
		
	}
	@Test
	public  void dashBtestCase() {
		
    //	Thread.sleep(7000);
		 WebElement das= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dashboardtab']")));
		 das.click();
	//	driver.findElement(By.xpath("//div[@id='dashboardtab']")).click();
	//  Thread.sleep(10000);
		
	
		 WebElement search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search here.']")));
		// Thread.sleep(2000);
		 search.sendKeys("2Testdashboard",Keys.RETURN);
		 
		WebElement img= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("landing-preview-image")));
		img.click();
		// Thread.sleep(5000);
		 String e1="Current selection";
		// Thread.sleep(2000);
		 WebElement very= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("curr_infowrapp")));
	     String a1 =very.getText();
		 Assert.assertEquals(a1,e1,"Login failed");
		
		 }
	@AfterMethod
	public void tearDown() {
		
            driver.close();
		}
        
    }

	


