package com.multicloud;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class CreateBucket extends baseClass{
	WebDriver driver;
	//create Bucket
	By CBucket=By.xpath("//div[@class='box12 boxClick storageBox']//img[@class='add_img']");
	By smartBucketName=By.xpath("//ng-form[@name='cloud']//input[@placeholder='Enter Bucket Name']");
	By RadioButton=By.xpath("//label[contains(text(),'Create Cloud Bucket')]");
	By cloudstorage=By.xpath("//div[@id='TAB_2']//div[2]//div[1]//div[1]//select[1]");
	By ProviderName=By.xpath("//div[@id='TAB_2']//div[3]//div[1]//div[1]//select[1]");
	By CloudBucketname=By.xpath("//input[@ng-model='bnbucket']");
	By savebutton=By.xpath("//div[@id='TAB_2']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]");
	
	public CreateBucket(WebDriver driver) {
		this.driver=driver; 
		
	}
	
//	  @Test()
//	  public void bucket() throws InterruptedException, IOException {
//	 System.out.println("Check created smart bucket displayed on notification page");
//	 driver.findElement(CBucket).click();
//	 Thread.sleep(3000);
//	 driver.findElement(RadioButton).click();
//	 driver.findElement(smartBucketName).sendKeys("aws-bucket-smart-1234");
//	// Actions action = new Actions(driver);
//	// action.doubleClick(ele).build().perform();
//	WebElement Storagetype= driver.findElement(cloudstorage);
//	Select select=new Select(Storagetype);
//	select.selectByIndex(1);
//    WebElement	providertype= driver.findElement(ProviderName);
//	 Select selstorage=new Select(providertype);
//	 selstorage.selectByIndex(3);
//	 driver.findElement(By.xpath("//input[@ng-model='bnbucket']")).sendKeys("cloudbucket-aws-2334");
//	 driver.findElement(savebutton).click();
//	 System.out.println("Smart bucket created successfully");
//	 driver.switchTo().alert().accept();
//	 String actual_msg=driver.findElement(By.id("emailId_err")).getText();
//
//	  }
	
//	 public void exit()
//	 {
//		  driver.quit();
//	  }
	  
	  @Test()
	  public void existingbucket() throws InterruptedException, IOException {
	 System.out.println("Check created existing bucket displayed on notification page");
	 driver.findElement(CBucket).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("aws-bucket-smart-1234");
	// Actions action = new Actions(driver);
	// action.doubleClick(ele).build().perform();
	WebElement Storagetype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[2]//div[1]//div[1]//select[1]"));
	Select select=new Select(Storagetype1);
	select.selectByIndex(1);
    WebElement	providertype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[3]//div[1]//div[1]//select[1]"));
	 Select selstorage=new Select(providertype1);
	 selstorage.selectByIndex(3);
	WebElement pr =driver.findElement(By.xpath("//div[@id='bucketModal']//div[4]//div[1]//div[1]//select[1]"));
	Select sels=new Select(pr);
	 sels.selectByIndex(3);
	 driver.findElement(savebutton).click();
	 System.out.println("Smart bucket created successfully");
	 driver.switchTo().alert().accept();
	 String actual_msg=driver.findElement(By.id("emailId_err")).getText();

	  }
	  
	}
