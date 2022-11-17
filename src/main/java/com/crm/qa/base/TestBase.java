package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverEvent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties properties;
    public static WebDriver driver;
    public static EventFiringDecorator eventFiringDecorator;
    public static WebDriverListener webDriverListener;
    public TestBase()
    {
        properties=new Properties();
        try {
            FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\FreeCRMAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
            properties.load(fis);
        }
        catch (FileNotFoundException e)
        {
         e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void initiallization()
    {
        String browserName = properties.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        if(browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        if(browserName.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.page_load_timeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
        driver.get(properties.getProperty("url"));
    }

}
