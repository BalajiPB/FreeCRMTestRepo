/*
 * @author Balaji B
 * 
 */
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage = new LoginPage();
	}
	
	

	@Test(priority=1)
	public void loginPageTitletest(){
		String title = loginpage.validateLoginPageTitle();
//		System.out.println(title);
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean logo = loginpage.validateCRMImage();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
