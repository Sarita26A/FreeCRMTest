package com.crm.qa.util;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class WebDriverEvent implements ITestListener {
    public static ExtentReports extentReporter;
    public static ExtentTest extentTest;
    public static ExtentHtmlReporter extentHtmlReporter;
    TestUtil testUtil;
    @Override
    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "\\Report\\";
        String timeStamp = new SimpleDateFormat("YYYY:MM:DD:HH:mm:ss").format(new Date());
        extentReporter = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(reportPath + timeStamp + ".html");
        extentReporter.attachReporter(extentHtmlReporter);

    }
    public void onTestFailure(ITestResult result) {
        extentTest = extentReporter.createTest(result.getMethod().getMethodName());
        extentTest.fail("Test Failed with some problem");
        try {
            testUtil.takeScreenShots();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
        @Override
        public void onFinish(ITestContext context) {

        extentReporter.flush();
    }








}








