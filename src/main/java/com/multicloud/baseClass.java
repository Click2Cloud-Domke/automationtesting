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
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class baseClass  {
	
	static WebDriver driver;
  @Test(alwaysRun = true)
  public void baseclass() throws InterruptedException, IOException, FindFailed {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
	  driver = new ChromeDriver();
	 // driver.get("192.168.3.235:30510");
	  Thread.sleep(2000);
	//	driver.get("http://192.168.3.235:30010/");
	driver.get("https://192.168.3.9:3000/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  Screen screen= new Screen();
		 //Pattern create1= new Pattern("C:\\Users\\puja.domke\\Documents\\puja\\snippingcapture\\login.png");
		 //screen.wait(create1, 2000);
		if(screen.exists("C:\\Users\\puja.domke\\Documents\\puja\\snippingcapture\\login.png")!=null)
		{
            screen.click("C:\\Users\\puja.domke\\Documents\\puja\\snippingcapture\\login.png");
         }
		
  }	  
}            