package com.multicloud;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class blockstorage {
	By i=By.xpath("//i[@class='fa fa-chevron-down']");
	By uname=By.id("user_name");
	By pass=By.id("user_password");
	By Lbutton=By.id("login");
	//add cloud provider
	By provider=By.xpath("//a[contains(text(),'Storage')]");
	By Storage=By.xpath("//a[@class='sidemenuanchor active ignore-click']//span[@class='list-group-item-value'][contains(text(),'Storage')]");
	By ObjectStorage=By.xpath("//span[contains(text(),'Object Storage')]");
	By CBucket=By.xpath("//div[@class='box12 boxClick boxClick1']");
	//cloud provider
	By AWS=By.xpath("//div[@id='Storagediv1']//i[@class='fa fa-plus-square-o fa-lg fonticon']");
	By aName=By.xpath("//*[@id=\'form_account_name\']");
	By Akey=By.xpath("//input[@id='form_access_key']");
	By Skey=By.xpath("//input[2]");
	By region=By.xpath("//select[@id='form_destination_region']");
	By validate=By.xpath("//button[@class='btn mg_validate-btn mg_margin-r-5']");
	
	 @BeforeTest
	  public void setup() {
		 WebDriver driver;
		  System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
		  driver = new ChromeDriver();
		 // driver.get("192.168.3.235:30510");
		  Thread.sleep(2000);
		//	driver.get("http://192.168.3.235:30010/");
		driver.get("http://192.168.3.9:3000/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  }
  @Test()
	  public void Login(String UN,String PS) throws InterruptedException {
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
	      Thread.sleep(3000);
	      driver.findElement(uname).sendKeys(UN);
		  driver.findElement(pass).sendKeys(PS);
		  driver.findElement(Lbutton).click();
		  Thread.sleep(3000);
		  System.out.println("Login successfully");
		  System.out.println("Dashboard title is"+ driver.getTitle());
		      Thread.sleep(2000);
	  }
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
