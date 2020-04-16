package com.multicloud;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass implements ITestListener {
	static ExtentHtmlReporter htmlreport;
	static ExtentTest test;
	static ExtentReports report;
	public ExtentReports extent;
	static WebDriver driver;
  @BeforeMethod
  public void baseclass() throws InterruptedException, IOException {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
	  driver = new ChromeDriver();
	 // driver.get("192.168.3.235:30510");
	  Thread.sleep(2000);
	//	driver.get("http://192.168.3.235:30010/");
	driver.get("http://192.168.3.9:3000/");
	
	  driver.manage().window().maximize();
	
	  HomePage multi=new HomePage(driver);
     // multi.Login("tester", "Newuser@123");
	  multi.Login("developer", "Click2cloud");
  //  multi.dashboard();
      multi.storage();
//      Blockstorage bs = new Blockstorage(driver);
//      bs.volume();
     // call CreateBucket
        CreateBucket	bucket=  new  CreateBucket(driver);
        bucket.EncryptedbucketCeph();
      //  bucket.bucketCeph();
       // bucket.deleteCeph();
      //  bucket.uploadCeph();
        
        
        bucket.bucketIBM();
        bucket.uploadIBM();
      bucket.existingbucketCeph();
        bucket.deleteExistingCeph();
      bucket.uploadExistingCeph();
      bucket.existingbucketIBM();
        
      //  bucket.exit();
          
           //call Migration
//          Migration mg=new Migration(driver);         
//         mg.ImmediateMigration();
        
        ACL acl=new ACL(driver);
          
       
	  }
	  @Test
	  public void testclass() throws InterruptedException{
	  }
      @BeforeClass(enabled=true)
  	public void extend() {
  		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReportResults.html");
  		htmlreport.config().setDocumentTitle("Automation report");
  		htmlreport.config().setReportName("Test");
  		  
  		htmlreport.config().setTheme(Theme.DARK);
  		  
  		  extent = new ExtentReports();
  		  extent.attachReporter(htmlreport);
  		  
  		  // Passing General information
  		  extent.setSystemInfo("Host name", "localhost");
  		  extent.setSystemInfo("Environemnt", "QA");
  		  extent.setSystemInfo("user", "pavan");
  		 }

//  		 @AfterTest
//  		 public void endReport() {
//  		  extent.flush();
  		 //}
  		 @AfterMethod(enabled=true)
		 public void tearDown(ITestResult result) throws IOException {
		  if (result.getStatus() == ITestResult.FAILURE) {
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
		   String screenshotPath = baseClass.getScreenshot(driver, result.getName());
		   test.addScreenCaptureFromPath("//.png");// adding screen shot
		  } else if (result.getStatus() == ITestResult.SKIP) {
		   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		  }
		  else if (result.getStatus() == ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		  }
		  driver.quit();
		 }
		 
		 public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/test-output/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
  		
  		
		 }}
		
       
  
	  
	

  
	





