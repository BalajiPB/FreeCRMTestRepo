package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase; //ctrl+shift+o - shortcut to import
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super ();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String Title = homePage.verifyHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO", "Home Page title not matched");
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		boolean bol = homePage.verifyUserName();
		Assert.assertTrue(bol);
	}
	
	@Test(priority=3)
	public void clickContactsPageTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContact();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
