package com.multicloud;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;

public class CreateBucketawsTest {
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
	By CBucket1=By.xpath("//div[@class='box12 boxClick storageBox']//img[@class='add_img']");
	By smartBucketName=By.xpath("//ng-form[@name='cloud']//input[@placeholder='Enter Bucket Name']");
	By RadioButton=By.xpath("//label[contains(text(),'Create Cloud Bucket')]");
	By cloudstorage=By.xpath("//div[@id='TAB_2']//div[2]//div[1]//div[1]//select[1]");
	By ProviderName=By.xpath("//div[@id='TAB_2']//div[3]//div[1]//div[1]//select[1]");
	By CloudBucketname=By.xpath("//input[@ng-model='bnbucket']");
	By savebutton=By.xpath("//div[@id='TAB_2']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]");
	
  static WebDriver driver;
	 @BeforeTest
	  public void setup() throws InterruptedException {
		

		  System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
		  driver = new ChromeDriver();
		 // driver.get("192.168.3.235:30510");
		  Thread.sleep(2000);
			driver.get("http://192.168.3.235:30010/");
		//driver.get("http://192.168.3.9:3000/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.id("user_name")).sendKeys("tester");
		  driver.findElement(By.id("user_password")).sendKeys("Newuser@123");
		  driver.findElement(Lbutton).click();
		  Thread.sleep(3000);
		  System.out.println("Login successfully");
		  System.out.println("Dashboard title is"+ driver.getTitle());
		      Thread.sleep(2000);
	 }
	 @Test(alwaysRun=true,priority=1,description = "object storage navigation")
	  public void storage() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.findElement(Storage).click();
		  WebElement ele=driver.findElement(ObjectStorage);
			Actions act=new Actions(driver);
		    Thread.sleep(5000);
		    act.moveToElement(ele).click().perform();
		    Thread.sleep(3000);
		    
	  }
	 @Test(priority=2, description = "aws bucket creating")
	  public void bucketaws() throws InterruptedException, IOException {
	 System.out.println("Check created smart bucket displayed on notification page");
	 System.out.println("**********************");
	 driver.findElement(CBucket1).click();
	 Thread.sleep(3000);
	 driver.findElement(RadioButton).click();
	 driver.findElement(smartBucketName).sendKeys("aawsbucket-7898");
	// Actions action = new Actions(driver);
	// action.doubleClick(ele).build().perform();
	WebElement Storagetype= driver.findElement(cloudstorage);
	Select select=new Select(Storagetype);
	select.selectByIndex(1);
  WebElement	providertype= driver.findElement(ProviderName);
	 Select selstorage=new Select(providertype);
	 selstorage.selectByIndex(1);
WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("aws-cloud-4012");
String text = element.getAttribute("value");
System.out.println("**********************");
System.out.println("Bucket name is"+text);
driver.findElement(savebutton).click();
	 Thread.sleep(3000);
	 //System.out.println("Smart bucket created successfully");
System.out.println( driver.switchTo().alert().getText());
	 driver.switchTo().alert().accept();
	 Thread.sleep(3000);
//	 WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsbucket-7898')]"));
//out.click();
//driver.findElement(By.xpath("//img[@class='back_img']")).click();
//System.out.println(out+"aws bucket created successfully");
	  }
	
	 // @Test(priority=1)
	  public void deleteaws() throws InterruptedException, IOException {
		//delete operation
			driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
			driver.findElement(By.xpath("//div[@class='actions open']//a[2]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			System.out.println("Bucket deleted successfully");
	  }
	  
	  @Test(priority=3, description = "upload  object in aws bucket")
	  public void uploadaws() throws InterruptedException, IOException {
		  
	
	System.out.println("Check Upload functionality is working ");
	//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsbucket-7898')]"));
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
	  
	  @Test(priority=5 , description = "existing bucket")
	  public void existingbucketaws() throws InterruptedException, IOException {
	 System.out.println("Check created existing aws bucket displayed on notification page");
	 driver.findElement(CBucket1).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("awsexisting-1003");
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
	 // @Test(priority=4)
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
	  @Test(priority=6, description = "upload object in existing bucket")
	  public void uploadExistingaws() throws InterruptedException, IOException {
	
	
	System.out.println("Check Upload functionality is working ");
	//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsexisting-1003')]"));
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



@Test(priority=7, description = "encrypted bucket")
public void Encryptedbucketaws() throws InterruptedException, IOException {
	  System.out.println("**********************");
System.out.println("Check Encrypted smart bucket displayed on notification page");
System.out.println("**********************");
driver.findElement(CBucket1).click();
Thread.sleep(3000);
driver.findElement(RadioButton).click();
driver.findElement(smartBucketName).sendKeys("awsencrypted-00014");
////Actions action = new Actions(driver);
////action.doubleClick(ele).build().perform();
WebElement Storagetype= driver.findElement(cloudstorage);
Select select=new Select(Storagetype);
select.selectByIndex(1);
WebElement	providertype= driver.findElement(ProviderName);
Select selstorage=new Select(providertype);
selstorage.selectByIndex(1);
WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("aws-cloud-1109");
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

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsencrypted-00012')]"));
//out.click();
//System.out.println(out+"aws Encrypted bucket created successfully");
}

//public void exit()
//{
//	  driver.quit();
//}
//@Test(priority=7)
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
@Test(priority=8 ,description = "upload object in encrypted bucket")
public void encrypteduploadaws() throws InterruptedException, IOException {

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'aws-00011')]"));
out.click();
Thread.sleep(2000);
WebElement uploadElement= driver.findElement(By.xpath("//button[@name='uploadTab']"));
uploadElement.click();
Thread.sleep(2000);
Runtime.getRuntime().exec("C:\\Users\\puja.domke\\Documents\\puja\\autoit\\FileUpload.exe");
Thread.sleep(3000);
System.out.println( driver.switchTo().alert().getText());
driver.switchTo().alert().accept();
driver.findElement(By.xpath("//button[@class='btn mg_submit-btn-green'][contains(text(),'Upload')]")).click();
}

@Test(priority=9, description = "create encrypted existing bucket for aws")
public void encryptedExistingbucketaws() throws InterruptedException, IOException {
System.out.println("Check created existing aws bucket displayed on notification page");
driver.findElement(CBucket1).click();
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
//@Test(priority=10)
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
@Test(priority=10, description = "upload object in encrypted existing bucket")
public void uploadEncryptedExistingaws() throws InterruptedException, IOException {  

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




  @AfterSuite
  public void afterSuite() {
  }

}
