package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super ();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnContact();
	}
	
	
	@Test(priority=1)
	public void verifyContactPageTest(){
		Boolean bol = contactsPage.verifyContactLabel();
		Assert.assertTrue(bol, "label is missing");
	}
	
	@Test(priority=2)
	public void clickTableValueTest(){
		contactsPage.clickTableValue();
	}
	
	@Test(priority=3)
	public void clickMultipleTableValueTest(){
		contactsPage.clickMultipleTableValue();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstname, String lastname){
		homePage.clickOnNewCOntactsLink();
		contactsPage.createNewContact(title, firstname, lastname);
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}