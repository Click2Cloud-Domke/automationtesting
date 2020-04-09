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
	
	  @Test()
	  public void bucketCeph() throws InterruptedException, IOException {
		  System.out.println("**********************");
	 System.out.println("Check created smart bucket displayed on notification page");
	 System.out.println("**********************");
	 driver.findElement(CBucket).click();
	 Thread.sleep(3000);
	 driver.findElement(RadioButton).click();
	 driver.findElement(smartBucketName).sendKeys("ceph-0002");
//	// Actions action = new Actions(driver);
//	// action.doubleClick(ele).build().perform();
	WebElement Storagetype= driver.findElement(cloudstorage);
	Select select=new Select(Storagetype);
	select.selectByIndex(3);
    WebElement	providertype= driver.findElement(ProviderName);
	 Select selstorage=new Select(providertype);
	 selstorage.selectByIndex(1);
WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("ceph-cloud-0002");
String text = element.getAttribute("value");
System.out.println("**********************");
System.out.println("Bucket name is"+text);
driver.findElement(savebutton).click();
	 Thread.sleep(5000);
	 //System.out.println("Smart bucket created successfully");
	 driver.switchTo().alert().accept();
	 Thread.sleep(3000);
	 
 WebElement out = driver.findElement(By.xpath("//div[contains(text(),'ceph-0002')]"));
 out.click();
 System.out.println(out+"Ceph bucket created successfully");
	  }
	
//	 public void exit()
//	 {
//		  driver.quit();
//	  }
	  @Test()
	  public void uploadCeph() throws InterruptedException, IOException {
		  
	 System.out.println("Check Ceph bucket is encrypted or decrypted functionality is working ");
	 System.out.println("**********************");
	 WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//	 System.out.println(encry.isEnabled()+": Bucket is not encrypted");
	 System.out.println("**********************");
	if(encry.isEnabled()) {
		System.out.println("Ceph Bucket is not encrypted");
		
	}else {
		System.out.println("Ceph Bucket is encrypted ");
	}
	
	
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'ceph-02')]"));
	 out.click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@class='btn btn_blue'][contains(text(),'Upload')]")).click();
//	Thread.sleep(3000);
//	 WebElement uploadElement= driver.findElement(By.xpath("//label[@class='file_upload_label']"));
//			uploadElement.click();
//	 uploadElement.sendKeys("C:\\Users\\puja.domke\\Desktop\\allTest.java");
	}
	  
	  @Test()
	  public void existingbucketCeph() throws InterruptedException, IOException {
	 System.out.println("Check created existing Ceph bucket displayed on notification page");
	 driver.findElement(CBucket).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("ceph-002");
	// Actions action = new Actions(driver);
	// action.doubleClick(ele).build().perform();
	WebElement Storagetype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[2]//div[1]//div[1]//select[1]"));
	Select select=new Select(Storagetype1);
	select.selectByIndex(3);
    WebElement	providertype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[3]//div[1]//div[1]//select[1]"));
	 Select selstorage=new Select(providertype1);
	 selstorage.selectByIndex(1);
	WebElement pr =driver.findElement(By.xpath("//div[@id='bucketModal']//div[4]//div[1]//div[1]//select[1]"));
	pr.click();
	Thread.sleep(30000);
	Actions action = new Actions(driver);
	 action.doubleClick(pr).build().perform();
	Select sels=new Select(pr);
	 sels.selectByIndex(1);
	 driver.findElement(savebutton).click();
	 System.out.println("**********************");
	 System.out.println("Smart bucket created successfully");
	 System.out.println("**********************");
	
	 
	 Thread.sleep(5000);
	 //System.out.println("Smart bucket created successfully");
	 driver.switchTo().alert().accept();
	 Thread.sleep(3000);
	 
 WebElement out = driver.findElement(By.xpath("//div[contains(text(),'ceph-002')]"));
 out.click();
 System.out.println(out+"Ceph bucket created successfully");

	  }
	  @Test()
	  public void uploadExistingCeph() throws InterruptedException, IOException {
		  
	 System.out.println("Check Ceph bucket is encrypted or decrypted functionality is working ");
	 System.out.println("**********************");
	 WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//	 System.out.println(encry.isEnabled()+": Bucket is not encrypted");
	 System.out.println("**********************");
	if(encry.isEnabled()) {
		System.out.println("Ceph Bucket is not encrypted");
		
	}else {
		System.out.println("Ceph Bucket is encrypted ");
	}
	
	
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'ceph-002')]"));
	 out.click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@class='btn btn_blue'][contains(text(),'Upload')]")).click();
//	Thread.sleep(3000);
//	 WebElement uploadElement= driver.findElement(By.xpath("//label[@class='file_upload_label']"));
//			uploadElement.click();
//	 uploadElement.sendKeys("C:\\Users\\puja.domke\\Desktop\\allTest.java");
	}

@Test()
public void bucketIBM() throws InterruptedException, IOException {
	  System.out.println("**********************");
System.out.println("Check created smart bucket displayed on notification page");
System.out.println("**********************");
driver.findElement(CBucket).click();
Thread.sleep(3000);
driver.findElement(RadioButton).click();
driver.findElement(smartBucketName).sendKeys("ibm-0002");
//// Actions action = new Actions(driver);
//// action.doubleClick(ele).build().perform();
WebElement Storagetype= driver.findElement(cloudstorage);
Select select=new Select(Storagetype);
select.selectByIndex(4);
WebElement	providertype= driver.findElement(ProviderName);
Select selstorage=new Select(providertype);
selstorage.selectByIndex(1);
WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("ibm-0002");
String text = element.getAttribute("value");
System.out.println("**********************");
System.out.println("Bucket name is"+text);
driver.findElement(savebutton).click();
Thread.sleep(5000);
//System.out.println("Smart bucket created successfully");
driver.switchTo().alert().accept();
Thread.sleep(3000);

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'ibm-0002')]"));
out.click();
System.out.println(out+"bucket created successfully");
}
@Test()
public void uploadIBM() throws InterruptedException, IOException {
	  
System.out.println("Check IBM bucket is encrypted or decrypted functionality is working ");
System.out.println("**********************");
WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//System.out.println(encry.isEnabled()+": Bucket is not encrypted");
System.out.println("**********************");
if(encry.isEnabled()) {
	System.out.println("Ibm Bucket is not encrypted");
	
}else {
	System.out.println("Ibm Bucket is encrypted ");
}


WebElement out = driver.findElement(By.xpath("//div[contains(text(),'ibm-02')]"));
out.click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@class='btn btn_blue'][contains(text(),'Upload')]")).click();
//Thread.sleep(3000);
//WebElement uploadElement= driver.findElement(By.xpath("//label[@class='file_upload_label']"));
//		uploadElement.click();
//uploadElement.sendKeys("C:\\Users\\puja.domke\\Desktop\\allTest.java");
}

//public void exit()
//{
//	  driver.quit();
//}

@Test()
public void existingbucketIBM() throws InterruptedException, IOException {
System.out.println("Check created existing bucket displayed on notification page");
driver.findElement(CBucket).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("ibm-01");
// Actions action = new Actions(driver);
// action.doubleClick(ele).build().perform();
WebElement Storagetype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[2]//div[1]//div[1]//select[1]"));
Select select=new Select(Storagetype1);
select.selectByIndex(6);
WebElement	providertype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[3]//div[1]//div[1]//select[1]"));
Select selstorage=new Select(providertype1);
selstorage.selectByIndex(1);
WebElement pr =driver.findElement(By.xpath("//div[@id='bucketModal']//div[4]//div[1]//div[1]//select[1]"));
pr.click();
Thread.sleep(30000);
Actions action = new Actions(driver);
action.doubleClick(pr).build().perform();
Select sels=new Select(pr);
sels.selectByIndex(3);
driver.findElement(savebutton).click();
System.out.println("**********************");
System.out.println("Smart bucket created successfully");
System.out.println("**********************");
driver.switchTo().alert().accept();


}
@Test()
public void uploadexistingIBM() throws InterruptedException, IOException {
	  
System.out.println("Check IBM bucket is encrypted or decrypted functionality is working ");
System.out.println("**********************");
WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//System.out.println(encry.isEnabled()+": Bucket is not encrypted");
System.out.println("**********************");
if(encry.isEnabled()) {
	System.out.println("Ibm Bucket is not encrypted");
	
}else {
	System.out.println("Ibm Bucket is encrypted ");
}


WebElement out = driver.findElement(By.xpath("//div[contains(text(),'ibm-01')]"));
out.click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@class='btn btn_blue'][contains(text(),'Upload')]")).click();
//Thread.sleep(3000);
//WebElement uploadElement= driver.findElement(By.xpath("//label[@class='file_upload_label']"));
//		uploadElement.click();
//uploadElement.sendKeys("C:\\Users\\puja.domke\\Desktop\\allTest.java");
}}

