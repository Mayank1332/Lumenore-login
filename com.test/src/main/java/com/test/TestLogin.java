package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	WebDriver driver;
	  WebDriverWait wait;

//	public static void main(String[] args) throws InterruptedException {
	@BeforeMethod
	public  void setUp() {
		WebDriverManager.chromedriver().setup(); 
		// create a new instance of chrome driver class
		driver=new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://insights.lumenore.com/testautomate/#/");
		
		driver.manage().window().maximize();
	}
		//find user name
		
		@Test
		public void testLogin()  {
			
			// create a new instance of chrome driver class
			//Thread.sleep(5000);
			
			WebElement users=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
			users.sendKeys("fouzanj@netlink.com");
	//	driver.findElement(By.id("userName")).sendKeys("fouzanj@netlink.com");
	
		//find password
			WebElement pass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			pass.sendKeys("Testing@1234");
			
			//driver.findElement(By.id("password")).sendKeys("Testing@1234");
		
		// find login button
			
			WebElement bat=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn lumenore-btn login-form-button ant-btn-primary ant-btn-block']")));
		      bat.click();
			//Thread.sleep(5000);
		
	//	driver.findElement(By.xpath("//button[@class='ant-btn lumenore-btn login-form-button ant-btn-primary ant-btn-block']")).click();
		//Thread.sleep(5000);
		
		String expectedUsername= "Greetings";
		//Thread.sleep(5000);
		WebElement greet =wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("greet-text")));
	   String actualUsername= greet.getText();
	  // String actualUsername= driver.findElement(By.className("greet-text")).getText();
	  Assert.assertEquals(actualUsername,expectedUsername,"Login failed");
		}
	  
	@AfterMethod
	    public void tearDown() {
		 
			 {
			    driver.close();
			}
	}
	
}

		

		// verify login or not
//		
	
//public class TestDashboard {
//
////	public static void main(String[] args) throws InterruptedException {
//	@Test
//	public  void dashBtestCase() throws InterruptedException {
//		WebDriverManager.chromedriver().setup(); 
//		// create a new instance of chrome driver class
//		WebDriver driver = new ChromeDriver();
//
//
//		String expectedUsername= "Greetings";
//		Thread.sleep(7000);
//	   String actualUsername= driver.findElement(By.className("greet-text")).getText();
//	   
//	  Assert.assertEquals(actualUsername,expectedUsername,"Login failed");
////		
//		
//		Thread.sleep(8000);
//		driver.findElement(By.xpath("//div[@id='dashboardtab']")).click();
//		Thread.sleep(10000);
//		//driver.findElement(By.xpath("//input[@placeholder='Search here.']")).click();
//	
//		 WebElement search= driver.findElement(By.xpath("//input[@placeholder='Search here.']"));
//		 Thread.sleep(2000);
//		 search.sendKeys("2Testdashboard",Keys.RETURN);
//		 driver.findElement(By.className("landing-preview-image")).click();
//		 Thread.sleep(5000);
//		 String e1="Current selection";
//		 Thread.sleep(2000);
//		 String a1 = driver.findElement(By.className("curr_infowrapp")).getText();
//		 Assert.assertEquals(a1,e1,"Login failed");
//		 Thread.sleep(5000);
//		driver.close();
//		 }
//
//	}

