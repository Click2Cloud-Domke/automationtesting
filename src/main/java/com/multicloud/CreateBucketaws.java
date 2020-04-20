package com.multicloud;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateBucketaws {
	WebDriver driver;
	//create Bucket
	By CBucket=By.xpath("//div[@class='box12 boxClick storageBox']//img[@class='add_img']");
	By smartBucketName=By.xpath("//ng-form[@name='cloud']//input[@placeholder='Enter Bucket Name']");
	By RadioButton=By.xpath("//label[contains(text(),'Create Cloud Bucket')]");
	By cloudstorage=By.xpath("//div[@id='TAB_2']//div[2]//div[1]//div[1]//select[1]");
	By ProviderName=By.xpath("//div[@id='TAB_2']//div[3]//div[1]//div[1]//select[1]");
	By CloudBucketname=By.xpath("//input[@ng-model='bnbucket']");
	By savebutton=By.xpath("//div[@id='TAB_2']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]");
	
	public CreateBucketaws(WebDriver driver) {
		this.driver=driver; 
		
	}
	 @Test(priority=0)
	  public void bucketaws() throws InterruptedException, IOException {
	 System.out.println("Check created smart bucket displayed on notification page");
	 System.out.println("**********************");
	 driver.findElement(CBucket).click();
	 Thread.sleep(3000);
	 driver.findElement(RadioButton).click();
	 driver.findElement(smartBucketName).sendKeys("awsbucket-1000");
	// Actions action = new Actions(driver);
	// action.doubleClick(ele).build().perform();
	WebElement Storagetype= driver.findElement(cloudstorage);
	Select select=new Select(Storagetype);
	select.selectByIndex(1);
   WebElement	providertype= driver.findElement(ProviderName);
	 Select selstorage=new Select(providertype);
	 selstorage.selectByIndex(1);
WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("aws-cloud-100");
String text = element.getAttribute("value");
System.out.println("**********************");
System.out.println("Bucket name is"+text);
driver.findElement(savebutton).click();
	 Thread.sleep(3000);
	 //System.out.println("Smart bucket created successfully");
System.out.println( driver.switchTo().alert().getText());
	 driver.switchTo().alert().accept();
	 Thread.sleep(3000);
	 WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsbucket-1000')]"));
out.click();
driver.findElement(By.xpath("//img[@class='back_img']")).click();
//System.out.println(out+"aws bucket created successfully");
	  }
	
	  @Test(priority=1)
	  public void deleteaws() throws InterruptedException, IOException {
		//delete operation
			driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
			driver.findElement(By.xpath("//div[@class='actions open']//a[2]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			System.out.println("Bucket deleted successfully");
	  }
	  
	  @Test(priority=2)
	  public void uploadaws() throws InterruptedException, IOException {
		  
	 System.out.println("Check aws bucket is encrypted or decrypted functionality is working ");
	 System.out.println("**********************");
	 WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//	 System.out.println(encry.isEnabled()+": Bucket is not encrypted");
	 System.out.println("**********************");
	if(encry.isEnabled()) {
		System.out.println("aws Bucket is not encrypted");
		
	}else {
		System.out.println("aws Bucket is encrypted ");
		
	}
	
	System.out.println("Check Upload functionality is working ");
	//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsbucket-1000')]"));
	 out.click();
	 Thread.sleep(2000);
	 WebElement uploadElement= driver.findElement(By.xpath("//button[@name='uploadTab']"));
	 uploadElement.click();
	 Thread.sleep(1000);
	WebElement file =driver.findElement(By.xpath("//label[@class='file_upload_label']"));
	file.click();
	driver.switchTo() .activeElement().sendKeys("C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png");
	
	 Runtime.getRuntime().exec("C:\\Users\\puja.domke\\Documents\\puja\\autoit\\FileUpload.exe");
	 Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='btn mg_submit-btn-green'][contains(text(),'Upload')]")).click();
	Thread.sleep(3000);
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	//System.out.println("Object uploaded successfully ");
	}
	  
	  @Test(priority=3)
	  public void existingbucketaws() throws InterruptedException, IOException {
	 System.out.println("Check created existing aws bucket displayed on notification page");
	 driver.findElement(CBucket).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("awsexisting-0001");
	// Actions action = new Actions(driver);
	// action.doubleClick(ele).build().perform();
	WebElement Storagetype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[2]//div[1]//div[1]//select[1]"));
	Select select=new Select(Storagetype1);
	select.selectByIndex(1);
   WebElement	providertype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[3]//div[1]//div[1]//select[1]"));
	 Select selstorage=new Select(providertype1);
	 selstorage.selectByIndex(1);
	WebElement pr =driver.findElement(By.xpath("//div[@id='bucketModal']//div[4]//div[1]//div[1]//select[1]"));
	pr.click();
	Thread.sleep(3000);
//	Actions action = new Actions(driver);
//	 action.doubleClick(pr).build().perform();
	Select sels=new Select(pr);
	 sels.selectByIndex(1);
	
	 driver.findElement(By.xpath("//div[@id='TAB_1']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]")).click();
	 System.out.println("**********************");
	 System.out.println("Smart existing bucket created successfully");
	 System.out.println("**********************");
	
	 
	 Thread.sleep(5000);
	 System.out.println( driver.switchTo().alert().getText());
	 //System.out.println("Smart bucket created successfully");
	 driver.switchTo().alert().accept();
	 Thread.sleep(3000);
	 


	  }
	  @Test(priority=4)
	  public void deleteExistingaws() throws InterruptedException, IOException {
	  	  System.out.println("Check aws bucket is encrypted or decrypted functionality is working ");
	  		 System.out.println("**********************");
	  		 WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//	  		 System.out.println(encry.isEnabled()+": Bucket is not encrypted");
	  		 System.out.println("**********************");
	  		if(encry.isEnabled()) {
	  			System.out.println("aws Bucket is not encrypted");
	  			
	  		}else {
	  			System.out.println("aws Bucket is encrypted ");
	  		}//delete operation
	  		driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
	  		driver.findElement(By.xpath("//div[@class='actions open']//a[2]")).click();
	  		Thread.sleep(1000);
	  		System.out.println( driver.switchTo().alert().getText());
	  		driver.switchTo().alert().accept();
	  		driver.switchTo().alert().accept();
	  		//System.out.println("Bucket deleted successfully");
	  }
	  @Test(priority=5)
	  public void uploadExistingaws() throws InterruptedException, IOException {
		  
	 System.out.println("Check aws bucket is encrypted or decrypted functionality is working ");
	 System.out.println("**********************");
	 WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//	 System.out.println(encry.isEnabled()+": Bucket is not encrypted");
	 System.out.println("**********************");
	if(encry.isEnabled()) {
		System.out.println("aws Bucket is not encrypted");
		
	}else {
		System.out.println("aws Bucket is encrypted ");
	}
	
	
	System.out.println("Check Upload functionality is working ");
	//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsexisting-0001')]"));
	 out.click();
	 Thread.sleep(2000);
	 WebElement uploadElement= driver.findElement(By.xpath("//button[@name='uploadTab']"));
	 uploadElement.click();
	 Thread.sleep(1000);
	WebElement file =driver.findElement(By.xpath("//label[@class='file_upload_label']"));
	file.click();
	driver.switchTo() .activeElement().sendKeys("C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png");
	
	// Runtime.getRuntime().exec("C:\\Users\\puja.domke\\Documents\\puja\\autoit\\FileUpload.exe");
	 Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='btn mg_submit-btn-green'][contains(text(),'Upload')]")).click();
	Thread.sleep(3000);
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	//System.out.println("Object uploaded successfully ");
	
			
	  }



@Test(priority=6)
public void Encryptedbucketaws() throws InterruptedException, IOException {
	  System.out.println("**********************");
System.out.println("Check Encrypted smart bucket displayed on notification page");
System.out.println("**********************");
driver.findElement(CBucket).click();
Thread.sleep(3000);
driver.findElement(RadioButton).click();
driver.findElement(smartBucketName).sendKeys("awsencrypted-00011");
////Actions action = new Actions(driver);
////action.doubleClick(ele).build().perform();
WebElement Storagetype= driver.findElement(cloudstorage);
Select select=new Select(Storagetype);
select.selectByIndex(1);
WebElement	providertype= driver.findElement(ProviderName);
Select selstorage=new Select(providertype);
selstorage.selectByIndex(1);
WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("aws-cloud-0009");
String text = element.getAttribute("value");
System.out.println("**********************");
System.out.println("Bucket name is"+text);
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@id='TAB_2']//span[@class='slider round']")).click();
driver.findElement(savebutton).click();
Thread.sleep(3000);
//System.out.println("Smart bucket created successfully");
driver.switchTo().alert().accept();
Thread.sleep(3000);

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsencrypted-00011')]"));
//out.click();
//System.out.println(out+"aws Encrypted bucket created successfully");
}

//public void exit()
//{
//	  driver.quit();
//}
@Test(priority=7)
public void deleteEncryptedbucketaws() throws InterruptedException, IOException {
	//delete operation
		driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
		driver.findElement(By.xpath("//div[@class='actions open']//a[2]")).click();
		Thread.sleep(1000);
		System.out.println( driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		System.out.println("Bucket deleted successfully");
}
@Test(priority=8)
public void encrypteduploadaws() throws InterruptedException, IOException {
	  
System.out.println("Check aws bucket is encrypted or decrypted functionality is working ");
System.out.println("**********************");
WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//System.out.println(encry.isEnabled()+": Bucket is not encrypted");
System.out.println("**********************");
if(encry.isEnabled()) {
	System.out.println("aws Bucket is  encrypted");
	
}else {
	System.out.println("aws Bucket is not encrypted ");
}
//WebElement out = driver.findElement(By.xpath("//div[contains(text(),'aws-00010')]"));
//out.click();
Thread.sleep(2000);
WebElement uploadElement= driver.findElement(By.xpath("//button[@name='uploadTab']"));
uploadElement.click();
Runtime.getRuntime().exec("C:\\Users\\puja.domke\\Documents\\puja\\autoit\\FileUpload.exe");
Thread.sleep(3000);

System.out.println( driver.switchTo().alert().getText());
//driver.findElement(By.xpath("//button[@class='btn mg_submit-btn-green'][contains(text(),'Upload')]")).click();
}

@Test(priority=9)
public void encryptedExistingbucketaws() throws InterruptedException, IOException {
System.out.println("Check created existing aws bucket displayed on notification page");
driver.findElement(CBucket).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("awsenexisting-002");
//Actions action = new Actions(driver);
//action.doubleClick(ele).build().perform();
WebElement Storagetype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[2]//div[1]//div[1]//select[1]"));
Select select=new Select(Storagetype1);
select.selectByIndex(1);
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
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@id='TAB_2']//span[@class='slider round']")).click();
driver.findElement(savebutton).click();
System.out.println("**********************");
Thread.sleep(1000);
System.out.println( driver.switchTo().alert().getText());
//System.out.println("encrypted aws Smart bucket created successfully");
System.out.println("**********************");



//System.out.println("Smart bucket created successfully");
driver.switchTo().alert().accept();
Thread.sleep(3000);

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsenexisting-002')]"));
out.click();
System.out.println(out+"aws bucket created successfully");

}
@Test(priority=10)
public void deleteEncryptedExistingaws() throws InterruptedException, IOException {
	//delete operation
		driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
		driver.findElement(By.xpath("//div[@class='actions open']//a[2]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		System.out.println( driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println("Bucket deleted successfully");
}
@Test(priority=11)
public void uploadEncryptedExistingaws() throws InterruptedException, IOException {  
System.out.println("Check aws bucket is encrypted or decrypted functionality is working ");
System.out.println("**********************");
WebElement encry=driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']//div[@class='storage_container_right']//div[2]//div[1]//div[3]//div[2]//div[1]"));
//System.out.println(encry.isEnabled()+": Bucket is not encrypted");
System.out.println("**********************");
if(encry.isEnabled()) {
	System.out.println("aws Bucket is not encrypted");
	
}else {
	System.out.println("aws Bucket is encrypted ");
}

System.out.println("Check Upload functionality is working ");
//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsenexisting-002')]"));
out.click();
Thread.sleep(2000);
WebElement uploadElement= driver.findElement(By.xpath("//button[@name='uploadTab']"));
uploadElement.click();
Thread.sleep(1000);
WebElement file =driver.findElement(By.xpath("//label[@class='file_upload_label']"));
file.click();
driver.switchTo() .activeElement().sendKeys("C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png");

//Runtime.getRuntime().exec("C:\\Users\\puja.domke\\Documents\\puja\\autoit\\FileUpload.exe");
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@class='btn mg_submit-btn-green'][contains(text(),'Upload')]")).click();
Thread.sleep(3000);
System.out.println(driver.switchTo().alert().getText());
driver.switchTo().alert().accept();
//System.out.println("Object uploaded successfully ");
}



}




