package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestUtil extends TestBase {
    public static long implicit_wait = 10;
    public static long page_load_timeout = 20;

    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }
    public void takeScreenShots() throws IOException {
        String screenshotPath=System.getProperty("user.dir")+"\\Screenshots";
        String timeStamp= new SimpleDateFormat("YYYY:MM:DD:HH:mm:ss").format(new Date());
        TakesScreenshot ts= (TakesScreenshot) driver;
        File srcFile=ts.getScreenshotAs(OutputType.FILE);
        File targetFile=new File(screenshotPath+timeStamp);
        FileUtils.copyFile(srcFile,targetFile);


    }


}






