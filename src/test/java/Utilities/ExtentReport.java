package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReport implements ITestListener
{
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    @Override
    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                .format(new Date());

        repName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

        sparkReporter.config().setDocumentTitle("Opencart Automation Report");
        sparkReporter.config().setReportName("Opencart Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Customers");
        extent.setSystemInfo("Sub Module", "Regression");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName());

        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.PASS,
                result.getName() + " got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName());

        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL,
                result.getName() + " got failed");

        test.log(Status.INFO,
                result.getThrowable().getMessage());

        try
        {
            BaseClass bs = new BaseClass();
        	
        	String imgPath =
                   bs.captureScreen(result.getName());

            test.addScreenCaptureFromPath(imgPath);

        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName());

        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.SKIP,
                result.getName() + " got skipped");

        test.log(Status.INFO,
                result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext testContext)
    {
        extent.flush();

        String pathOfExtentReport =System.getProperty("user.dir")
                       + "\\reports\\"
                        + repName;

        File extentReport = new File(pathOfExtentReport);

        try
        {
            Desktop.getDesktop().browse(extentReport.toURI());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        
        
        /*
        
        try {
        	URL url = new URL()
        //create the email message
        ImageHtmlEmail	 email = new ImageHtmlEmail();		
        	email.
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        }
        
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         
        
        
        
    }
    
    
    
}