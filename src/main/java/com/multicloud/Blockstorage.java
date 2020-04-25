package com.multicloud;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

 

public class Blockstorage extends baseClass{
	
	 public Blockstorage(WebDriver driver) {
		  this.driver=driver; 
		}

     
    @Test(alwaysRun = true,priority = 2)
    public  void AddStorage() throws InterruptedException
        {  Thread.sleep(2000);
     WebElement storage = driver.findElement(By.xpath("//select[@id='storageTypeDropdown1']"));
            storage.click();
    		 Select drpstorage = new Select(storage); 
            Thread.sleep(2000);
            drpstorage.selectByIndex(1);
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
        }
    @Test(alwaysRun=true,priority = 3)
    public  void AddVolume() throws InterruptedException
        {
           driver.findElement(By.xpath("//i[@id='addVolumeBtn']")) .click();
    	  Thread.sleep(1000);
           driver.findElement(By.xpath("//*[@id='volume-name']")).sendKeys("create-volume712");
            System.out.println("Enter Volume Name");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='volume-size']")).sendKeys("5");
            System.out.println("Enter Volume Size");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[17]/div/input[1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='exampleModalLongSuccess']//div//div//div//button[contains(text(),'OK')]")).click();
            Thread.sleep(3000);
        }
    @Test(alwaysRun=true,priority = 4)
    public  void EditVolume() throws InterruptedException
        {
            driver.findElement(By.xpath("//*[@id='volume-name']")).sendKeys("volume-test1");
            System.out.println("Enter Volume Name");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='volume-size']")).sendKeys("5");
            System.out.println("Enter Volume Size");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[17]/div/input[1]")).click();
            System.out.println("Click on Add button");
            Thread.sleep(1000);
           System.out.println(driver.switchTo().alert().getText());    
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//*[@id='v-account']")).click();
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li[2]/div/div[1]/lable")).click();
            System.out.println("Select volume");
            
            driver.findElement(By.xpath("//*[@id='v-account']")).click();
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li/div/div[2]/div/i[1]/img")).click();
            System.out.println("Click on Edit Icon");
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='volume-size']")).clear();
            driver.findElement(By.xpath("//*[@id='volume-size']")).sendKeys("6");
            System.out.println("Edit volume size");
            
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[17]/div/input[1]")).click();
            System.out.println("Click on Save button");
            Thread.sleep(5000);
            System.out.println(driver.switchTo().alert().getText());  
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
                        
        }
    @Test(alwaysRun = true,priority = 4)
    public  void DeleteVolume() throws InterruptedException
        {
        driver.findElement(By.xpath("//*[@id='v-account']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li[2]/div/div[1]/lable")).click();
        System.out.println("Select volume");
        
        driver.findElement(By.xpath("//*[@id='v-account']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li/div/div[2]/div/i[2]/img")).click();
        System.out.println("Click on Delete Icon");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='exampleModalLongMigrate']/div/div/div[2]/button[2]")).click();
        System.out.println("Accecpt popup");
        
        System.out.println(driver.switchTo().alert().getText()); 
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        }


    @Test(alwaysRun = true,priority = 5)
    public  void snapshot() throws InterruptedException
        {
            driver.findElement(By.xpath("//*[@id='mig_menus']/li[2]/a")).click();
            System.out.println("Go to snapshot tab");
            Thread.sleep(1000);
//            driver.switchTo().alert().getText();    
//            driver.switchTo().alert().accept();
//            Thread.sleep(5000);
           WebElement type=driver.findElement(By.xpath("//select[@id='sel3']"));
           type.click();
           Select sc=new Select(type);
           sc.selectByIndex(1);
            driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Test-Snapshot221");
            System.out.println("Enter snapshot name");
            Thread.sleep(2000);
            
        driver.findElement(By.xpath("//*[@id='s2']/div/div/div/div[1]/div[3]/div[5]/div/button")).click();
        Thread.sleep(5000);
       WebElement   submit = driver.findElement(By.xpath("//div[@id='exampleModalLongSuccess']//div//div//div//button[contains(text(),'OK')]"));
       submit.getText();
       submit.click();
         Thread.sleep(1000);   
        }
    
    @Test(alwaysRun = true,priority = 6)
    public  void DeleteSnapshot() throws InterruptedException
        {
            driver.findElement(By.xpath("//*[@id='mig_menus']/li[2]/a")).click();
            System.out.println("Go to snapshot tab");
            driver.switchTo().alert().getText();    
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Test-Snapshot541");
            System.out.println("Enter snapshot name");
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='s2']/div/div/div/div[1]/div[3]/div[5]/div/button")).click();
            System.out.println("Click on Create Snapshot button");
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//*[@id='s2']/div/div/div/div[3]/div/div/div/div/div[1]/img")).click();
        }
    @Test(alwaysRun = true,priority = 7)
    public  void createhost() throws InterruptedException
        {
    Thread.sleep(3000);
          driver.findElement(By.xpath("//a[contains(text(),'Host')]")).click();
          driver.findElement(By.xpath("//button[@id='hostCreateBtn']")).click();
          Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='hostFormName']")).sendKeys("Ceph-host32");
    WebElement os = driver.findElement(By.xpath("//select[@id='hostOS']"));
      Select sc=new Select(os);
      sc.selectByIndex(1);
      driver.findElement(By.xpath("//input[@id='hostIpAddress']")).sendKeys("192.168.1.232");
      driver.findElement(By.xpath("//input[@placeholder='Port Name']")).sendKeys("iqn.1993-08.org.debian:01:87308fbedf5c");
   WebElement initiator =driver.findElement(By.xpath("//select[@id='hostPortSelect']"));
       Select sc1=new Select(initiator);
       sc1.selectByIndex(1);
       driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
       Thread.sleep(2000);
       System.out.println(driver.switchTo().alert().getText());
       driver.switchTo().alert().accept();
        }
    @Test(alwaysRun=true,priority = 8)
    public  void attach() throws InterruptedException
        {
    	  Thread.sleep(1000);
    	driver.findElement(By.xpath("//a[contains(text(),'Storage +')]")).click();
    	Thread.sleep(2000);
    	 WebElement storage = driver.findElement(By.xpath("//select[@id='storageTypeDropdown1']"));
         storage.click();
 		 Select drpstorage = new Select(storage); 
         Thread.sleep(2000);
         drpstorage.selectByIndex(1);
         Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@id='s1']//div//div//div//div//div//div//div//div//div//button[contains(text(),'Attach')]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//div[@id='attachModal']//div//div//div//button[contains(text(),'Attach')]")).click();
    	Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
    	driver.switchTo().alert().accept();
    	
        }
    @Test(alwaysRun=true,priority = 8)
    public  void detach() throws InterruptedException
        {
    	Thread.sleep(1000);
  	  driver.findElement(By.xpath("//div[@id='s1']//div//div//div//div//div//div//div//div//div//button[contains(text(),'Detach')]")).click();
  	  Thread.sleep(2000);
   	 WebElement vol = driver.findElement(By.xpath("//select[@id='detachVolume']"));
        vol.click();
		 Select drpstorage = new Select(vol); 
		 drpstorage.selectByIndex(1);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@id='detachModal']//div//div//div//button[contains(text(),'Detach')]")).click();
		 Thread.sleep(4000);
		 driver.switchTo().alert().accept();
		 Thread.sleep(1000);
  		 
    }
    @Test(alwaysRun = true,priority = 2)
    public  void AddStoragelvm() throws InterruptedException
        {  Thread.sleep(2000);
     WebElement storage = driver.findElement(By.xpath("//select[@id='storageTypeDropdown1']"));
            storage.click();
    		 Select drpstorage = new Select(storage); 
            Thread.sleep(2000);
            drpstorage.selectByIndex(0);
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
        }
    @Test(alwaysRun=true,priority = 3)
    public  void AddVolumelvm() throws InterruptedException
        {
           driver.findElement(By.xpath("//i[@id='addVolumeBtn']")) .click();
    	  Thread.sleep(1000);
           driver.findElement(By.xpath("//*[@id='volume-name']")).sendKeys("create-volume712");
            System.out.println("Enter Volume Name");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='volume-size']")).sendKeys("5");
            System.out.println("Enter Volume Size");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[17]/div/input[1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='exampleModalLongSuccess']//div//div//div//button[contains(text(),'OK')]")).click();
            Thread.sleep(3000);
        }
    @Test(alwaysRun=true,priority = 4)
    public  void EditVolumelvm() throws InterruptedException
        {
            driver.findElement(By.xpath("//*[@id='volume-name']")).sendKeys("volume-test1");
            System.out.println("Enter Volume Name");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='volume-size']")).sendKeys("5");
            System.out.println("Enter Volume Size");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[17]/div/input[1]")).click();
            System.out.println("Click on Add button");
            Thread.sleep(1000);
           System.out.println(driver.switchTo().alert().getText());    
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//*[@id='v-account']")).click();
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li[2]/div/div[1]/lable")).click();
            System.out.println("Select volume");
            
            driver.findElement(By.xpath("//*[@id='v-account']")).click();
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li/div/div[2]/div/i[1]/img")).click();
            System.out.println("Click on Edit Icon");
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='volume-size']")).clear();
            driver.findElement(By.xpath("//*[@id='volume-size']")).sendKeys("6");
            System.out.println("Edit volume size");
            
            driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[17]/div/input[1]")).click();
            System.out.println("Click on Save button");
            Thread.sleep(5000);
            System.out.println(driver.switchTo().alert().getText());  
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
                        
        }
    @Test(alwaysRun = true,priority = 4)
    public  void DeleteVolumelvm() throws InterruptedException
        {
        driver.findElement(By.xpath("//*[@id='v-account']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li[2]/div/div[1]/lable")).click();
        System.out.println("Select volume");
        
        driver.findElement(By.xpath("//*[@id='v-account']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id='s1']/div/div/div[1]/div/div[13]/div/div/div/div/ul/li/div/div[2]/div/i[2]/img")).click();
        System.out.println("Click on Delete Icon");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='exampleModalLongMigrate']/div/div/div[2]/button[2]")).click();
        System.out.println("Accecpt popup");
        
        System.out.println(driver.switchTo().alert().getText()); 
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        }


    @Test(alwaysRun = true,priority = 5)
    public  void snapshotlvm() throws InterruptedException
        {
            driver.findElement(By.xpath("//*[@id='mig_menus']/li[2]/a")).click();
            System.out.println("Go to snapshot tab");
            Thread.sleep(1000);
//            driver.switchTo().alert().getText();    
//            driver.switchTo().alert().accept();
//            Thread.sleep(5000);
           WebElement type=driver.findElement(By.xpath("//select[@id='sel3']"));
           type.click();
           Select sc=new Select(type);
           sc.selectByIndex(0);
            driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Test-Snapshot221");
            System.out.println("Enter snapshot name");
            Thread.sleep(2000);
            
        driver.findElement(By.xpath("//*[@id='s2']/div/div/div/div[1]/div[3]/div[5]/div/button")).click();
        Thread.sleep(5000);
       WebElement   submit = driver.findElement(By.xpath("//div[@id='exampleModalLongSuccess']//div//div//div//button[contains(text(),'OK')]"));
       submit.getText();
       submit.click();
         Thread.sleep(1000);   
        }
    
    @Test(alwaysRun = true,priority = 6)
    public  void DeleteSnapshotlvm() throws InterruptedException
        {
            driver.findElement(By.xpath("//*[@id='mig_menus']/li[2]/a")).click();
            System.out.println("Go to snapshot tab");
            driver.switchTo().alert().getText();    
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Test-Snapshot541");
            System.out.println("Enter snapshot name");
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='s2']/div/div/div/div[1]/div[3]/div[5]/div/button")).click();
            System.out.println("Click on Create Snapshot button");
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//*[@id='s2']/div/div/div/div[3]/div/div/div/div/div[1]/img")).click();
        }
    @Test(alwaysRun = true,priority = 7)
    public  void createhostlvm() throws InterruptedException
        {
    
          driver.findElement(By.xpath("//a[contains(text(),'Host')]")).click();
          driver.findElement(By.xpath("//button[@id='hostCreateBtn']")).click();
          Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='hostFormName']")).sendKeys("lvm-host32");
    WebElement os = driver.findElement(By.xpath("//select[@id='hostOS']"));
      Select sc=new Select(os);
      sc.selectByIndex(1);
      driver.findElement(By.xpath("//input[@id='hostIpAddress']")).sendKeys("192.168.1.232");
      driver.findElement(By.xpath("//input[@placeholder='Port Name']")).sendKeys("iqn.1993-08.org.debian:01:87308fbedf5c");
   WebElement initiator =driver.findElement(By.xpath("//select[@id='hostPortSelect']"));
       Select sc1=new Select(initiator);
       sc1.selectByIndex(1);
       driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
       Thread.sleep(2000);
       System.out.println(driver.switchTo().alert().getText());
       driver.switchTo().alert().accept();
        }
    @Test(alwaysRun=true,priority = 8)
    public  void attachlvm() throws InterruptedException
        {
    	  Thread.sleep(1000);
    	driver.findElement(By.xpath("//a[contains(text(),'Storage +')]")).click();
    	Thread.sleep(2000);
    	 WebElement storage = driver.findElement(By.xpath("//select[@id='storageTypeDropdown1']"));
         storage.click();
 		 Select drpstorage = new Select(storage); 
         Thread.sleep(2000);
         drpstorage.selectByIndex(0);
         Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@id='s1']//div//div//div//div//div//div//div//div//div//button[contains(text(),'Attach')]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//div[@id='attachModal']//div//div//div//button[contains(text(),'Attach')]")).click();
    	Thread.sleep(2000);
    	 System.out.println(driver.switchTo().alert().getText());
    	driver.switchTo().alert().accept();
    	
        }
    @Test(alwaysRun=true,priority = 8)
    public  void detachlvm() throws InterruptedException
        {
    	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//div[@id='s1']//div//div//div//div//div//div//div//div//div//button[contains(text(),'Detach')]")).click();
    	  Thread.sleep(2000);
     	 WebElement vol = driver.findElement(By.xpath("//select[@id='detachVolume']"));
          vol.click();
  		 Select drpstorage = new Select(vol); 
  		 drpstorage.selectByIndex(1);
  		 Thread.sleep(1000);
  		 driver.findElement(By.xpath("//div[@id='detachModal']//div//div//div//button[contains(text(),'Detach')]")).click();
  		 Thread.sleep(4000);
  		 driver.switchTo().alert().accept();
    }
    @Test(alwaysRun=true,priority = 8)
    public  void Appdeployment() throws InterruptedException
        {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//div[@id='main-content']//li[4]//a[1]yy)"));
        }
    
    }