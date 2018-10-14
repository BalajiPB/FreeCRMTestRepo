package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/a")
	WebElement contactsLink;
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[5]/a")
	WebElement dealsLink;
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[6]/a")
	WebElement tasksLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this); //driver will initialize the all the web element - "this" will point to current class object
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

	public boolean verifyUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContact(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals(){
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasks(){
		tasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewCOntactsLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		driver.findElement(By.xpath("//a[text()='New Contact']")).click();
//		return ContactsPage;
	}

}
