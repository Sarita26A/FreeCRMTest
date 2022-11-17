package com.crm.qa.testCases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public LoginTest(){
        super();
    }
    @BeforeMethod
    public void setUp()
    {
       initiallization();
       loginPage=new LoginPage();
    }
    @Test(priority=1)
    public void loginPageTitleTest() throws InterruptedException {
        String title= loginPage.validateLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.",title);
        Thread.sleep(2000);
    }
    @Test(priority=2)
    public void loginTest()
    {
        homePage= loginPage.getUsername(properties.getProperty("username"),properties.getProperty("password"));

    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
