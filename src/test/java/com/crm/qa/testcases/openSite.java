package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class openSite
{
	WebDriver driver;
	
	@BeforeMethod
	public void openMain()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/HP/workspace/driver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://vtu.ac.in/");
	}
	@Test
	//Clicking on the first link on the page
	public void aboutVTU()
	{
		driver.findElement(By.id("menu-item-323")).click();
	}
	@Test
	//clicking on the 2nd link in the page
	public void Institutes()
	{
		driver.findElement(By.id("menu-item-325")).click();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}