package com.multicloud;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomePage extends baseClass {
	WebDriver driver;
	//Login
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
	public HomePage(WebDriver driver) {
		this.driver=driver; 
		}
  @Test(priority=0)
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
 @Test(priority=1)
  public void storage() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(Storage).click();
	  WebElement ele=driver.findElement(ObjectStorage);
		Actions act=new Actions(driver);
	    Thread.sleep(5000);
	    act.moveToElement(ele).click().perform();
	    Thread.sleep(3000);
	    
  }
 @Test(priority=2)
  public void dashboard() {
	  System.out.println("Tc_01: Check added cloud provider displayed according to selected cloud tab properly ");
	  driver.findElement(provider).click();
	  driver.findElement(AWS).click();
	 // String myWindowHandle = driver.getWindowHandle();
	 // driver.switchTo().window(myWindowHandle);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(aName).sendKeys("AWSstorage");
	  driver.findElement(Akey).sendKeys("AKIAWVTLFQG5E5YONZ5G");
	  driver.findElement(Skey).sendKeys("NOfMxvuPRj6iV5Sb2LKBDGg5UowZytWatxD55+Fe");
	  Select reg = new Select( driver.findElement(region));
	   reg.selectByIndex(2);
	   driver.findElement(validate).click();

	
	
  }

  
  
   

}
