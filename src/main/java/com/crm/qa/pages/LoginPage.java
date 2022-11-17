package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(name="username")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
    public String validateLoginPageTitle()
    {
        return driver.getTitle();
    }
    public HomePage getUsername(String uname,String pwd)
    {

        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();

    }

}
