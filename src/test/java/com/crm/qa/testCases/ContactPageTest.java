package com.crm.qa.testCases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.DataUtil;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    DataUtil dataUtil;
    ContactsPage contactsPage;
    //String xFile="D:\\IdeaProjects\\FreeCRMAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\FREECRM_TestData.xlsx";
    String sheet="Contacts";
    public ContactPageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initiallization();
        loginPage=new LoginPage();
        homePage=new HomePage();
        testUtil=new TestUtil();
        contactsPage=new ContactsPage();
        homePage=loginPage.getUsername(properties.getProperty("username"),properties.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage=homePage.clickContactsLink();

    }
    @Test(priority=1)
    public void verifyContactPageLabel(){
        Assert.assertTrue(contactsPage.verifyContactLabel(),"Contact Label is missing on the Page");

    }
    @Test(priority=2)
    public void verifyContactListChecked(){
        contactsPage.clickfirstContactList();

    }

   @DataProvider
    public Object[][] getCustomerInfo() throws IOException {
           Object[][] data= dataUtil.getData(sheet);
           return data;

    }
    @Test(priority = 3,dataProvider = "getCustomerInfo")

    public void validateCreateNewContacts(String title, String fname, String lname, String company) {
        homePage.clickOnNewContactPage();
        contactsPage.createNewContacts(title,fname,lname,company);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
