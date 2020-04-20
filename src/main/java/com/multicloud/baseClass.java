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
	
	static WebDriver driver;
  @Test()
  public void baseclass() throws InterruptedException, IOException {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
	  driver = new ChromeDriver();
	 // driver.get("192.168.3.235:30510");
	  Thread.sleep(2000);
		driver.get("http://192.168.3.235:30010/");
	//driver.get("http://192.168.3.9:3000/");
	  driver.manage().window().maximize();
	  HomePage multi=new HomePage(driver);
      multi.Login("tester", "Newuser@123");
	 // multi.Login("developer", "Click2cloud");
      // multi.dashboard();
        multi.storage();
   //  Blockstorage bs = new Blockstorage(driver);
       // bs.volume();
     // call CreateBucket
       CreateBucketceph	bucket=  new  CreateBucketceph(driver);
        bucket.bucketCeph();
        
        bucket.uploadCeph();
       // bucket.deleteCeph();
        Migration mg=new Migration(driver);         
        
     //   mg.ImmediateMigrationIbmtoCeph();

        
       // Extendreport ex=new Extendreport();
//        bucket.existingbucketCeph();
      //  bucket.deleteExistingCeph();
     // bucket.uploadExistingCeph();
     // mg.ImmediateMigrationCephtoIBM();
     // bucket.existingbucketIBM();
//        bucket.encryptedExistingbucketCeph();
//        bucket.EncryptedbucketCeph();
        
      //  bucket.exit();
          
           //call Migration
                  
        ACL acl=new ACL(driver);
        IBMbucket IB=new IBMbucket(driver);
      //  Alibaba alibaba=new Alibaba(driver);
      //  alibaba.bucketalibaba();
        CreateBucketaws	aws=  new  CreateBucketaws(driver);
        Createbucketgcp gcp=new Createbucketgcp(driver);
      //  gcp.bucketgcp();
       // gcp.uploadgcp();
        //gcp.deletegcp();
        
        
        
        
          
       
	  }
	 }
		
       
  
	  
	

  
	





