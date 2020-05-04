package com.multicloud;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class CreateBucketawsTest {
	By html=By.xpath("//body/div[@id='center_div']/div/div/div/div[@id='main-content']/div/div[@id='StorageID']/div/div/div[@id='main-content']/div/div/div/div/div/div/div/div[@id='TAB1']/div/div/div/di"
			+ "v/div/div[1]/div[1]");
	By addtab=By.xpath("//div[@class='box12 boxClick migrationBox']//img[@class='add_img']");
	By Create=By.xpath("//div[@class='tab_container mg_tab_container']//button[@class='btn btn_blue'][contains(text(),'Create')]");
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
	By CBucket2=By.xpath("//div[@class='box12 boxClick storageBox']//img[@class='add_img']");
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
		 DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE); 
			
		 driver = new ChromeDriver();
		 // driver.get("192.168.3.235:30510");
		  Thread.sleep(2000);
		//	driver.get("http://192.168.3.235:30010/");
		driver.get("http://192.168.3.9:3000/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.id("user_name")).sendKeys("developer");
		  driver.findElement(By.id("user_password")).sendKeys("Click2cloud");
		  driver.findElement(Lbutton).click();
		  Thread.sleep(3000);
		  System.out.println("Login successfully");
		  System.out.println("Dashboard title is"+ driver.getTitle());
		      Thread.sleep(2000);
		      }
	 @Test(alwaysRun=true,priority=11,description = "object storage navigation")
	  public void Objectstorage() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.findElement(Storage).click();
		  WebElement ele=driver.findElement(ObjectStorage);
			Actions act=new Actions(driver);
		    Thread.sleep(5000);
		    act.moveToElement(ele).click().perform();
		    Thread.sleep(3000);
		    
	  }
	 @Test(priority=12, description = "aws bucket creating")
	  public void bucketaws() throws InterruptedException, IOException {
	 System.out.println("Check created smart bucket displayed on notification page");
	 System.out.println("**********************");
	String window=driver.getWindowHandle();
	 driver.findElement(CBucket1).click();
	 Thread.sleep(3000);
	 driver.findElement(RadioButton).click();
	 driver.findElement(smartBucketName).sendKeys("aawsbucket-117");
	// Actions action = new Actions(driver);
	// action.doubleClick(ele).build().perform();
	WebElement Storagetype= driver.findElement(cloudstorage);
	Select select=new Select(Storagetype);
	select.selectByIndex(1);
    WebElement	providertype= driver.findElement(ProviderName);
    providertype.click();
    Select selectBox = new Select(providertype);
    int selectOptions = selectBox.getOptions().size();
    selectBox.selectByIndex(selectOptions - 1);
   WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("aws-cloud-test1031");
String text = element.getAttribute("value");
System.out.println("**********************");
System.out.println("Bucket name is"+text);
driver.findElement(savebutton).click();
	 Thread.sleep(3000);
	 //System.out.println("Smart bucket created successfully");
System.out.println( driver.switchTo().alert().getText());
	 driver.switchTo().alert().accept();
	 Thread.sleep(3000);
driver.switchTo().window(window);

	  }
	
	//  @Test(priority=13)
	  public void deleteaws() throws InterruptedException, IOException {
		//delete operation
			driver.findElement(By.id("createBucketId")).click();
			driver.findElement(By.xpath("//body//div[@id='TAB1']//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[4]//ul[1]//li[1]//a[2]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			System.out.println("Bucket deleted successfully");
	    }
	  
	  @Test(priority=17, description = "upload  object in aws bucket")
	  public void uploadaws() throws InterruptedException, IOException {
		  
	Thread.sleep(3000);
	System.out.println("Check Upload functionality is working ");
	//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'aawsbucket-117')]"));
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
	WebElement myButton=driver.findElement(By.xpath("//button[@class='btn mg_submit-btn-green'][contains(text(),'Upload')]"));
	myButton.click();
	Thread.sleep(4000);

	System.out.println(driver.switchTo().alert().getText());
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	System.out.println("Object uploaded successfully ");
	}
	  
	 
	@Test(priority=13 , description = "existing bucket")
	  public void existingbucketalibaba() throws InterruptedException, IOException, SikuliException {
		  Thread.sleep(5000);
		  driver.findElement(html)
		 .click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//body//div[@id='main-content']//div//div[3]//div[1]//img[2]")).click();;
		  Thread.sleep(5000);
	 System.out.println("Check created existing aws bucket displayed on notification page");
  WebElement action1= driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div[2]//div[1]//img[2]"));
  action1.click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("alibabaexisting-33");
	// Actions action = new Actions(driver);
	// action.doubleClick(ele).build().perform();
	WebElement Storagetype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[2]//div[1]//div[1]//select[1]"));
	Select select=new Select(Storagetype1);
	select.selectByIndex(7);
  WebElement	providertype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[3]//div[1]//div[1]//select[1]"));
  providertype1.click();
  Select selectBox = new Select(providertype1);
    int selectOptions = selectBox.getOptions().size();
    selectBox.selectByIndex(selectOptions - 1);
    Thread.sleep(3000);
	WebElement pr =driver.findElement(By.xpath("//div[@id='bucketModal']//div[4]//div[1]//div[1]//select[1]"));
	pr.click();
    Select sels=new Select(pr);
	 sels.selectByIndex(3);
	Thread.sleep(3000);
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
		  Thread.sleep(3000);
		  driver.findElement(By.id("createBucketId")).click();
			driver.findElement(By.xpath("//body//div[@id='TAB1']//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[4]//ul[1]//li[1]//a[2]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			System.out.println("Bucket deleted successfully");
	  		//System.out.println("Bucket deleted successfully");
	  }
	 // @Test(priority=18, description = "upload object in existing bucket")
	  public void uploadExistingaws() throws InterruptedException, IOException {
	
		  Thread.sleep(3000);
	System.out.println("Check Upload functionality is working ");
	 driver.findElement(By.xpath("//div[@class='box12 boxClick managementBox boxClick1']//img[@class='add_img']")).click();
	//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
	WebElement out = driver.findElement(By.xpath("//div[contains(text(),'alibabaexisting-33')]"));
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


@Test(priority=14, description = "encrypted bucket")
public void Encryptedbucketaws() throws InterruptedException, IOException {
	 Thread.sleep(5000);
	  driver.findElement(html)
	 .click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//body//div[@id='main-content']//div//div[3]//div[1]//img[2]")).click();;
	  Thread.sleep(5000);
System.out.println("Check created existing aws bucket displayed on notification page");
WebElement action1= driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div[2]//div[1]//img[2]"));
action1.click();
Thread.sleep(3000);
//Thread.sleep(3000);
driver.findElement(RadioButton).click();
driver.findElement(smartBucketName).sendKeys("awsencrypted-1212");
////Actions action = new Actions(driver);
////action.doubleClick(ele).build().perform();
WebElement Storagetype= driver.findElement(cloudstorage);
Select select=new Select(Storagetype);
select.selectByIndex(1);
WebElement	providertype= driver.findElement(ProviderName);
providertype.click();
Select selectBox = new Select(providertype);
  int selectOptions = selectBox.getOptions().size();
  selectBox.selectByIndex(selectOptions - 1);
WebElement	element= driver.findElement(By.xpath("//input[@ng-model='bnbucket']"));
element.sendKeys("aws-cloud-4000");
String text = element.getAttribute("value");
System.out.println("**********************");
System.out.println("Bucket name is"+text);
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@id='TAB_1']//div//div//div//div//label//span")).click();
driver.findElement(savebutton).click();
Thread.sleep(3000);
//System.out.println("Smart bucket created successfully");
driver.switchTo().alert().accept();
Thread.sleep(3000);

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsencrypted-1212')]"));
//out.click();
//System.out.println(out+"aws Encrypted bucket created successfully");
}

//public void exit()
//{
//	  driver.quit();
//}
//@Test(priority=7)
public void deleteEncryptedbucketaws() throws InterruptedException, IOException {
	 Thread.sleep(3000);
	 driver.findElement(By.id("createBucketId")).click();
		driver.findElement(By.xpath("//body//div[@id='TAB1']//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[4]//ul[1]//li[1]//a[2]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		System.out.println("Bucket deleted successfully");
}
@Test(priority=19 ,description = "upload object in encrypted bucket")
public void encrypteduploadaws() throws InterruptedException, IOException {
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@class='box12 boxClick managementBox boxClick1']//img[@class='add_img']")).click();

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsencrypted-1212')]"));
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

@Test(priority=15, description = "create encrypted existing bucket for aws")
public void encryptedExistingbucketalibaba() throws InterruptedException, IOException {
	Thread.sleep(5000);
	  driver.findElement(html)
	 .click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//body//div[@id='main-content']//div//div[3]//div[1]//img[2]")).click();;
	  Thread.sleep(5000);
System.out.println("Check created existing encrypted alibaba bucket displayed on notification page");
WebElement action1= driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div[2]//div[1]//img[2]"));
action1.click();
Thread.sleep(3000);
driver.findElement(By.xpath("//ng-form[@name='pass']//input[@placeholder='Enter Bucket Name']")).sendKeys("alibabaenexisting-002");
//Actions action = new Actions(driver);
//action.doubleClick(ele).build().perform();
WebElement Storagetype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[2]//div[1]//div[1]//select[1]"));
Select select=new Select(Storagetype1);
select.selectByIndex(7);
WebElement	providertype1= driver.findElement(By.xpath("//div[@id='TAB_1']//div[3]//div[1]//div[1]//select[1]"));
providertype1.click();
Select selectBox = new Select(providertype1);
  int selectOptions = selectBox.getOptions().size();
  selectBox.selectByIndex(selectOptions - 1);
  Thread.sleep(4000);
WebElement pr =driver.findElement(By.xpath("//div[@id='bucketModal']//div[4]//div[1]//div[1]//select[1]"));
pr.click();
Thread.sleep(30000);
Actions action = new Actions(driver);
action.doubleClick(pr).build().perform();
Select sels=new Select(pr);
sels.selectByIndex(3);
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@id='TAB_1']//div//div//div//div//label//span")).click();
driver.findElement(savebutton).click();
System.out.println("**********************");
Thread.sleep(1000);
System.out.println( driver.switchTo().alert().getText());
//System.out.println("encrypted aws Smart bucket created successfully");
System.out.println("**********************");



//System.out.println("Smart bucket created successfully");
driver.switchTo().alert().accept();
Thread.sleep(3000);

WebElement out = driver.findElement(By.xpath("//div[contains(text(),'alibabaenexisting-002')]"));
out.click();
System.out.println(out+"aws bucket created successfully");

}
//@Test(priority=10)
public void deleteEncryptedExistingaws() throws InterruptedException, IOException {
	 Thread.sleep(3000);
	 driver.findElement(By.id("createBucketId")).click();
		driver.findElement(By.xpath("//body//div[@id='TAB1']//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[4]//ul[1]//li[1]//a[2]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		System.out.println("Bucket deleted successfully");
}
//@Test(priority=16, description = "upload object in encrypted existing bucket")
public void uploadEncryptedExistingalibaba() throws InterruptedException, IOException {  
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@class='box12 boxClick managementBox boxClick1']//img[@class='add_img']")).click();
System.out.println("Check Upload functionality is working ");
//String FilePath="C:\\Users\\puja.domke\\Desktop\\Screenshot_1.png";
WebElement out = driver.findElement(By.xpath("//div[contains(text(),'alibabaenexisting-002')]"));
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




 // @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
