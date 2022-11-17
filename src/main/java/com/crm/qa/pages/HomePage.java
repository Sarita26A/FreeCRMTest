package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//td[contains(text(),'User: Sarita Kumari')]")
    WebElement usernameLabel;
    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactLink;
    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealLink;
    @FindBy(xpath ="//a[contains(text(),'Tasks')]")
    WebElement taskLink;
    @FindBy(xpath = "//a[@title='New Contact']")
    WebElement newContact;
    public HomePage()
    {

        PageFactory.initElements(driver,this);
    }
    public String verifyTitle(){
        String str =driver.getTitle();
        return str;
    }
    public boolean verifyUserName(){
        return usernameLabel.isDisplayed();
    }
    public ContactsPage clickContactsLink()
    {

        contactLink.click();
        return new ContactsPage();
    }
    public DealsPage clickDealLink()
    {
        dealLink.click();
        return new DealsPage();
    }
    public TaskPage clickTaskLink()
    {
        taskLink.click();
        return new TaskPage();
    }
    public void clickOnNewContactPage(){
        Actions actions= new Actions(driver);
        actions.moveToElement(contactLink).build().perform();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",newContact);
       // newContact.click();
    }

}
