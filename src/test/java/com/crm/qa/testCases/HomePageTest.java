package com.crm.qa.testCases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initiallization();
        loginPage=new LoginPage();
        homePage=loginPage.getUsername(properties.getProperty("username"), properties.getProperty("password") );
        testUtil=new TestUtil();

    }
    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homePageTitle= homePage.verifyTitle();
        Assert.assertEquals(homePageTitle,"CRMPRO","HomePage Title is not same");

    }
    @Test(priority = 2)
    public void verifyUserNameTest() throws InterruptedException {
        Thread.sleep(1000);
        testUtil.switchToFrame();
        boolean flag= homePage.verifyUserName();
        Assert.assertTrue(homePage.verifyUserName());
    }
    @Test(priority = 3)
    public void verifyContactLinkTest(){
        testUtil.switchToFrame();
        contactsPage=homePage.clickContactsLink();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
