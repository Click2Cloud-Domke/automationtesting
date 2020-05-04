package com.multicloud;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LifecycleTest {
  
static WebDriver driver;
By html=By.xpath("//body/div[@id='center_div']/div/div/div/div[@id='main-content']/div/div[@id='StorageID']/div/div/div[@id='main-content']/div/div/div/div/div/div/div/div[@id='TAB1']/div/div/div/di"
		+ "v/div/div[1]/div[1]");
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

 @BeforeTest
  public void setup() throws InterruptedException {
	

	  System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
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
 @Test(alwaysRun=true,priority=20,description = "object storage navigation")
  public void Objectstoragelifecycle() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(Storage).click();
	  WebElement ele=driver.findElement(ObjectStorage);
		Actions act=new Actions(driver);
	    Thread.sleep(5000);
	    act.moveToElement(ele).click().perform();
	    Thread.sleep(3000);
	    
  }
  @Test(priority=21)
  public void lifecycle() throws InterruptedException, IOException {
	  Thread.sleep(3000);
	driver.findElement(By.xpath("//div[contains(text(),'aawsbucket-117')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'LifeCycle')]")).click();
	Thread.sleep(1000);
	}
	//@Test(priority=22)
	  public void lifecyclecreate() throws InterruptedException, IOException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div//div//div//li[2]//a[1]")).click();
		Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='tab_container']//div[@class='col-md-6 col-xs-12 col-sm-12']//button[@class='btn btn_blue']")).click();
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//div[@id='lifeCycleModal']//div[@class='modal-content mg_modal-content']")).click();
	driver.findElement(By.xpath("//input[@id='ruleId']")).sendKeys("transitionrule2 for bucket");

	driver.findElement(By.xpath("//input[@id='prefixId']")).sendKeys("prifix2");
driver.findElement(By.xpath("//div[@id='lifeCycleModal']//div[3]//div[1]//div[1]//label[1]//span[1]")).click();
driver.findElement(By.xpath("//div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageManagement']//div[4]//div[1]//div[1]//div[1]//label[1]//span[1]")).click();

driver.findElement(By.xpath("//div[@id='lifeCycleModal']//button[2]")).click();
Thread.sleep(1000);
driver.switchTo().alert().getText();
driver.switchTo().alert().accept();
}
@Test(priority=25)
  public void deleteobject() throws InterruptedException, IOException {
	Thread.sleep(1000);
driver.findElement(By.xpath("//a[contains(text(),'Object')]")).click();
driver.findElement(By.xpath("//a[@id='deleteObjectID']")).click();
driver.findElement(By.xpath("//div[@class='actions open']//a[contains(text(),'Delete')]")).click();
Thread.sleep(3000);
driver.switchTo().alert().accept();
Thread.sleep(2000);
driver.switchTo().alert().accept();
Thread.sleep(2000);
driver.switchTo().alert().accept();
//driver.findElement(By.xpath("//img[@class='back_img']")).click();

}
@Test(priority=24)
  public void lifecycledeleteobject() throws InterruptedException, IOException {
	// Thread.sleep(3000);
	 Thread.sleep(5000);
	  driver.findElement(html)
	 .click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//body//div[@id='main-content']//div//div[3]//div[1]//img[2]")).click();;
	  Thread.sleep(5000);
System.out.println("Check created existing aws bucket displayed on notification page");
//WebElement action1= driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div[2]//div[1]//img[2]"));
//action1.click();
	driver.findElement(By.xpath("//div[contains(text(),'aawsbucket-117')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'LifeCycle')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='tab_container']//button[@class='btn btn_blue'][contains(text(),'Create')]")).click();
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//div[@id='lifeCycleModal']//div[@class='modal-content mg_modal-content']")).click();
	driver.findElement(By.xpath("//div[@class='col-md-8 col-sm-8 col-xs-8']//input[@class='form-control mg_input ng-pristine ng-untouched ng-valid ng-empty']")).sendKeys("transitionrule_for_bucket");

	driver.findElement(By.xpath("//div[@class='col-md-4 col-sm-4 col-xs-4 pad_left_5']//input[@class='form-control mg_input ng-pristine ng-untouched ng-valid ng-empty']")).sendKeys("prifix");

driver.findElement(By.xpath("//div[6]//div[1]//div[1]//label[1]//span[1]")).sendKeys("1");
driver.findElement(By.xpath("//input[@name='deleteDaysAfter']"));
driver.findElement(By.xpath("//div[@id='lifeCycleModal']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]")).click();
}
//@Test(priority=23)
  public void lifecycledelete() throws InterruptedException, IOException {
	  Thread.sleep(5000);
	  driver.findElement(html)
	 .click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//body//div[@id='main-content']//div//div[3]//div[1]//img[2]")).click();;
	  Thread.sleep(5000);
System.out.println("Check created existing aws bucket displayed on notification page");
//WebElement action1= driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div[2]//div[1]//img[2]"));
//action1.click();
	driver.findElement(By.xpath("//div[contains(text(),'aawsbucket-117')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'LifeCycle')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//body/div[@id='center_div']/div/div/div/div[@id='main-content']/div/div[@id='StorageID']/div/div/div[@id='main-content']/div/div/div/div/div/div/div/div[@id='TAB1']/div/div/div/div/div/div/div/div/div/div/div/div[@id='tab_lifecycle']/div/div/div/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/a[1]")).click();
	driver.findElement(By.xpath("//body//div[@id='tab_lifecycle']//div//div//div//div[1]//div[1]//div[2]//div[1]//div[2]//div[4]//ul[1]//li[1]//a[1]")).click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	
	
}
}
