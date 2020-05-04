package com.multicloud;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;

public class MigrationTest {
	WebDriver driver;
	By addtab=By.xpath("//div[@class='box12 boxClick migrationBox']//img[@class='add_img']");
	By Create=By.xpath("//div[@class='tab_container mg_tab_container']//button[@class='btn btn_blue'][contains(text(),'Create')]");
//	By PlanName=By.xpath();
//	By SourceSmartBucket=By.xpath();
	//static WebDriver driver;
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
	  public void Objectstoragemig() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.findElement(Storage).click();
		  WebElement ele=driver.findElement(ObjectStorage);
			Actions act=new Actions(driver);
		    Thread.sleep(5000);
		    act.moveToElement(ele).click().perform();
		    Thread.sleep(3000);
	 }
	
  @Test(alwaysRun = true,priority=26,description="immediatemigration")
  public void ImmediateMigrationofbuckets() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(addtab).click();
	  driver.findElement(Create).click();
	  Thread.sleep(3000);
	 // driver.findElement(By.xpath("//div[@class='modal-body mg_modal-body lifeCycleBody mig_body']")).click();
	 driver.findElement(By.xpath("//input[@name='migName']")).sendKeys("testnewmigrationcti-04");
	WebElement dr= driver.findElement(By.xpath("//body//div[@id='createModal']//div//div//div//div[2]//div[1]//div[1]//select[1]"));
	  dr.click();
	  Select selectBox = new Select(dr);
	  selectBox.selectByIndex(3);
	  Thread.sleep(1000);
//	    int selectOptions = selectBox.getOptions().size();
//	    selectBox.selectByIndex(selectOptions - 1);
	
	//  driver.findElement(By.xpath("//input[@class='form-control mg_input ng-pristine ng-valid ng-empty ng-touched']")).sendKeys("migration");
		WebElement des1= driver.findElement(By.xpath("//div[@id='createModal']//div[3]//div[1]//div[1]//select[1]"));
		des1.click();
		Select selectBox1 = new Select(des1);
		selectBox1.selectByIndex(3);
//		    int selectOptions1 = selectBox1.getOptions().size();
//		    selectBox1.selectByIndex(selectOptions1 - 1);
		Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[contains(text(),'Migrate')]")).click();
		 Thread.sleep(2000);
		 System.out.println( driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 JavascriptExecutor js = (JavascriptExecutor) driver;     		
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		 WebElement	text=driver.findElement(By.xpath("//div[contains(text(),'newmigrationcti-01')])"));
//	     System.out.println(text);
	     driver.findElement(By.xpath("//div[contains(text(),'testnewmigrationcti-04')]")).click();
		  
	  
  }
 // @Test(alwaysRun = true)
  public void ImmediateMigration() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(addtab).click();
	  driver.findElement(Create).click();
	  Thread.sleep(3000);
	 // driver.findElement(By.xpath("//div[@class='modal-body mg_modal-body lifeCycleBody mig_body']")).click();
	 driver.findElement(By.xpath("//input[@name='migName']")).sendKeys("newmigrationitc");
	WebElement dr= driver.findElement(By.xpath("//div[@class='modal-body mg_modal-body lifeCycleBody mig_body']//div[2]//div[1]//div[1]//select[1]"));
	  dr.click();
	Select sc=new Select(dr);
	  sc.selectByIndex(19);
	//  driver.findElement(By.xpath("//input[@class='form-control mg_input ng-pristine ng-valid ng-empty ng-touched']")).sendKeys("migration");
		WebElement des1= driver.findElement(By.xpath("//div[@id='createModal']//div[3]//div[1]//div[1]//select[1]"));
		  Select sc1=new Select(des1);
		  sc1.selectByIndex(18);
		  
		 driver.findElement(By.xpath("//button[contains(text(),'Migrate')]")).click();
		 Thread.sleep(2000);
		 System.out.println( driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@class='box12 boxClick managementBox']//div[@class='space5']")).click();
		 WebElement out = driver.findElement(By.xpath("//div[contains(text(),'awsbucket-1000')]"));
		 out.click();
		 Thread.sleep(2000);
		}
  @BeforeClass
  public void beforeClass() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
