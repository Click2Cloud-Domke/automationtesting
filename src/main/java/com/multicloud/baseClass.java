package com.multicloud;

import org.testng.Assert;
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
import com.google.common.base.Verify;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass extends ExtentReporterNG {
	
	static WebDriver driver;
  @Test(alwaysRun = true)
  public void baseclass() throws InterruptedException, IOException {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
	  driver = new ChromeDriver();
	 // driver.get("192.168.3.235:30510");
	  Thread.sleep(2000);
	//	driver.get("http://192.168.3.235:30010/");
	driver.get("http://192.168.3.9:3000/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  HomePage hp=new HomePage(driver);
	  hp.Login("developer", "Click2cloud");
	// hp.Login("tester", "Newuser@123");
//	  cloudbrain cbl=new cloudbrain(driver);
	 
	   CreateBucketceph cb=new CreateBucketceph(driver);
	  IBMbucket cbi=new IBMbucket(driver);
	  Migration mg=new Migration(driver);
	  CreateBucketaws cbaws=new CreateBucketaws(driver);
	  Alibaba cbali=new Alibaba(driver);
	  Createbucketgcp cbgcp=new Createbucketgcp(driver);
	  Lifecycle lifecycle=new Lifecycle(driver);
//	  lifecycle.lifecycle();
//	  lifecycle.lifecycledelete();
	  
	  
//	  //blockstorage creation
	  Blockstorage bs=new Blockstorage(driver);
	   hp.blockstorage(); 
	   bs.AddStorage();
	   bs.AddVolume();
	   bs.snapshot();
	   bs.createhost();
  //   bs.DeleteSnapshot();
	   bs.attach();
	 //  bs.detach();
//	   driver.close();;
	   
	  
	   
	   //openstorage creation
//	   System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
//		  driver = new ChromeDriver();
//		 // driver.get("192.168.3.235:30510");
//		  Thread.sleep(2000);
//			//driver.get("http://192.168.3.235:30010/");
//		driver.get("http://192.168.3.9:3000/");
//		  driver.manage().window().maximize();
//		 // driver.navigate().refresh();
//		  HomePage hp1=new HomePage(driver);
//		  hp1.Login("developer", "Click2cloud");
//		// hp1.Login("tester", "Newuser@123");
//	  
//	  hp1.storage();
	//  driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div[2]//div[1]//img[2]")).click();
//	  cb.bucketCeph();
//	  cb.uploadCeph();
	  Thread.sleep(2000);
	  cbaws.bucketaws();
	  cbaws.uploadaws();
	  Thread.sleep(2000);
	 // lifecycle.lifecycle();
	 lifecycle.lifecyclecreate();
	 lifecycle.lifecycledelete();
	   driver.close();
	  
	   System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
		  driver = new ChromeDriver();
		 // driver.get("192.168.3.235:30510");
		  Thread.sleep(2000);
			//driver.get("http://192.168.3.235:30010/");
		driver.get("http://192.168.3.9:3000/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  HomePage hp2=new HomePage(driver);
		  hp2.Login("developer", "Click2cloud");
		// hp2.Login("tester", "Newuser@123");
		  hp2.storage();
		  
	  mg.ImmediateMigrationCephtoIBM();

//	  lifecycle.deleteobject();
//	  cb.deleteCeph();
//	  cbi.existingbucketIBM();
//	  cb.existingbucketCeph();
//	  cb.uploadExistingCeph();
//	  mg.ImmediateMigrationCephtoIBM();
//	  cbali.bucketalibaba();
//	  cbaws.bucketaws();
//	  cbaws.uploadaws();
//	  mg.ImmediateMigrationCephtoIBM();
	 // mg.ImmediateMigrationCephtoIBM();

  
        
        
          
       
	  }
	 }
		
       
  
	  
	

  
	





