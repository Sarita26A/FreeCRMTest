package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {
    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactLabel;
    @FindBy(xpath = "//input[@value='52897781']")
    WebElement firstContactList;
    @FindBy(name="first_name")
    WebElement firstName;
    @FindBy(name = "title")
    WebElement titleField;
    @FindBy(name="surname")
    WebElement lastName;
    @FindBy(name="client_lookup")
    WebElement company;
    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveButton;
    public ContactsPage(){

        PageFactory.initElements(driver,this);
    }

    public boolean verifyContactLabel(){
       return contactLabel.isDisplayed();
    }
    public void clickfirstContactList()
    {
        firstContactList.click();
    }
    public void createNewContacts(String str, String fname,String lname, String compName){
        Select select =new Select(titleField);
        select.selectByVisibleText(str);
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        company.sendKeys(compName);
        saveButton.click();
    }


}
