package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[4]/td[1]/input")
	WebElement tableValue1;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[5]/td[1]/input")
	WebElement tableValue2;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement surName;
	
	@FindBy(xpath="//table/tbody/tr/td/input[2][@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this); //driver will initialize the all the web element - "this" will point to current class object
	}
	
	public void clickTableValue(){
		tableValue1.click(); 
	}

	public void clickMultipleTableValue(){
		tableValue1.click();
		tableValue2.click(); 
	}
	
	public  boolean verifyContactLabel(){
		boolean bol = contactsLabel.isDisplayed();
		return bol;
	}

	public void createNewContact(String title, String ftName, String ltName){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		this.firstName.sendKeys(ftName);
		this.surName.sendKeys(ltName);
		//input[@type='submit' and @class='button']
		saveBtn.click();
	}
	
}
