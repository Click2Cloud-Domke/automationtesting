package com.multicloud;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;

public class BlockstorageTest {
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
  @Test()
  public void  blockstorage() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//a[@class='sidemenuanchor active ignore-click']//span[@class='list-group-item-value'][contains(text(),'Storage')]")).click();
	WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'Block Storage')]"));
		Actions act=new Actions(driver);
	    Thread.sleep(5000);
	    act.moveToElement(ele).click().perform();
	    Thread.sleep(3000);
	  
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
          driver.findElement(By.xpath("//*[@id='volume-name']")).sendKeys("volume-test3");
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
 // @Test(alwaysRun = true,priority = 4)
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
//          driver.switchTo().alert().getText();    
//          driver.switchTo().alert().accept();
//          Thread.sleep(5000);
         WebElement type=driver.findElement(By.xpath("//select[@id='sel3']"));
         type.click();
         Select sc=new Select(type);
         sc.selectByIndex(1);
          driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Test-Snapshot321");
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
          
          driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Test-Snapshot21");
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
  driver.findElement(By.xpath("//input[@name='hostFormName']")).sendKeys("Ceph-host52");
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
  @Test(alwaysRun=true,priority = 9)
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
  @Test(alwaysRun=true,priority = 10)
  public  void appdeployment() throws InterruptedException
      {
	  driver.findElement(By.xpath("//a[contains(text(),'App Deployment')]")).click();
      driver.findElement(By.xpath("//button[@id='clusterAddBtn']")).click();
    Thread.sleep(4000);  
    driver.findElement(By.xpath("//input[@id='clusterNameTab1']")).sendKeys("new-cluster");
    driver.findElement(By.xpath("//textarea[@name='clusterFileTab1']")).sendKeys("apiVersion: v1\n" + 
    		"clusters:\n" + 
    		"- cluster:\n" + 
    		"    certificate-authority-data: LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUN5RENDQWJDZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRc0ZBREFWTVJNd0VRWURWUVFERXdwcmRXSmwKY201bGRHVnpNQjRYRFRJd01ERXhOREExTkRRME5Wb1hEVE13TURFeE1UQTFORFEwTlZvd0ZURVRNQkVHQTFVRQpBeE1LYTNWaVpYSnVaWFJsY3pDQ0FTSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnRVBBRENDQVFvQ2dnRUJBTUpXCjNxYkxqOWxDUXJweDFQZTNramJJOVJSN20vc09xK1BZNUZjdXp3NkJDTFczSllPUFhoOTkvVWsrTy9qNjdhcGwKekU2WFRCa1BNRUlxU3lmSDRlZUxRN1lUQjkzNGxYeU1DaFVsWEJFS1JxZXpkUmI0ek91L0VkeXkwNmlmVE9tRApLZUlEUi9jNlg0a2FyUlE2Ym1YUTRqWkJaUG9NZUI5Sm1BcW82dVFoUGdZKzlnd0pyOGRSK0s5VlJsOTJKbSt1Ck5RN2xFN25SUisxM3lMR0RHQm14TlZmWTFRT3VwOHNDTnVFV0ZvRjFGdFU0V2RzYy9xcFNHcjhJbUNYMW9RY3kKNGZnWFA1cTR3ZXlPcFY3UkFJUXZuK0xIZ0p5WnFDdWx1a3ZiUFVINGlGS2FxMHdhMkMzblAwbmFWbUMrYVRDawpJd0E2aGpuYXFWSnJjd1hmRXNNQ0F3RUFBYU1qTUNFd0RnWURWUjBQQVFIL0JBUURBZ0trTUE4R0ExVWRFd0VCCi93UUZNQU1CQWY4d0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFBRGNSSTBBQlRrRW5iWUt3d3hwYlorZlFhbE8KcnNVc0ZIZTBYbDE3dGxOdUdUTGJvV0prYjVqVEd2dmxuYjUzRzA1TWJtTkF6TTJPRHhCNHp0cm9MbWtXTGZrTQphUkppb3lyd1BrRjZUQUxQNEQ4RHhqTjNhNGoweEU4TmpPSkpGY09xbkFBQU5lWE44ZzhXSFpTeGpTL0NDdEROClM3cm96MDFUTExIM1AydXR2RE5iWDUxTkZvdXB0SEN6eTV2ZEhjR1pkL1RIUmlCeEZ2VWhEd0YzWjZKT3hYdSsKNVpVMndVd2p3Vkk0SFBFSjd1akFnakxoUjROUWovNFFMRmZ2UmMrOW1TT0lBMzNFQ1lSRGZLclQ0bnRxVWVwMAorY045RCt3c0syTS9sbENwMERNZDU3WjRxMlIvMjV6UUlaeHFUa1AxeENjbjRwdlQwMUxTc3lpSnVlbz0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=\n" + 
    		"    server: https://192.168.3.79:6443\n" + 
    		"  name: kubernetes\n" + 
    		"contexts:\n" + 
    		"- context:\n" + 
    		"    cluster: kubernetes\n" + 
    		"    user: kubernetes-admin\n" + 
    		"  name: kubernetes-admin@kubernetes\n" + 
    		"current-context: kubernetes-admin@kubernetes\n" + 
    		"kind: Config\n" + 
    		"preferences: {}\n" + 
    		"users:\n" + 
    		"- name: kubernetes-admin\n" + 
    		"  user:\n" + 
    		"    client-certificate-data: LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM4akNDQWRxZ0F3SUJBZ0lJY25LWW1LenJJRGN3RFFZSktvWklodmNOQVFFTEJRQXdGVEVUTUJFR0ExVUUKQXhNS2EzVmlaWEp1WlhSbGN6QWVGdzB5TURBeE1UUXdOVFEwTkRWYUZ3MHlNVEF4TVRNd05UUTBORGhhTURReApGekFWQmdOVkJBb1REbk41YzNSbGJUcHRZWE4wWlhKek1Sa3dGd1lEVlFRREV4QnJkV0psY201bGRHVnpMV0ZrCmJXbHVNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQXZ2TkxWdTAzU0lta2hMdUUKRTVkbXU3eVNYMkNCZmRzb1NWaGxjcHVoMWZPK3BZSS9vcFI0SjNFN1RXNGx2VHo1RE03VEk3NzRuQUtRZmhoZwpzbkZCN3A4OEEyeVpQWjJ1RjRyS0E5UlFXS1daU0lYeTVNS29oOERkVTVRM3JHRG85ZC9mRzJ0NkxsVEtwMEp0ClZKOUg2T0ZTS1VxaEk4NUFQdTB3WkZ4L1RNWlc3VEVweVpJdmVTOVpSRklYRkpFV0xpN1gvZVZUa1gxUEdSUGMKWEdWUTQwcVVwSVJIV3E1Y0Jtdi9qR0Y1Mjh0Mkx2S1Y4RVA1d3NRcE12QmVGckt4dGRtS0NSNnUyalZLbll0RApWVllYUXZkTEhEcUJrbjg3QWpxSGVEU2NsVDIwWGRMVVZOeHJFUmxrYjlUOE5IUVRFeDFTVGpIa2I2Wm1wK3hUCjViK2tRUUlEQVFBQm95Y3dKVEFPQmdOVkhROEJBZjhFQkFNQ0JhQXdFd1lEVlIwbEJBd3dDZ1lJS3dZQkJRVUgKQXdJd0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFFV0M3M0FYTWJtWTNnYmZSVVFOajJhVkNYcEJDbWd1S0RjSgpJMHB5NWpjMWtjalZEWGlUTk1POGpzQkI5S0M5eHpwTlNKQXdFK0lKWm5kc1M0YmRETE9jMU9vMHZjRkVxU1JTCm9sTFNnZ294bnJja2hPa0tMa29lZTFYTGVQRnliWHVKdzI0K2tlelNUTC81SXVHQlp4QUg3V0xvTklnQmY0eXgKeDdMRFhxNWE0NitZVWdQbWU3b2xwSmJkMHhiQnpYVjFpVkxwWVl4Ulh0Q0JRK0ppMUk0dGVpOGJoZjVVWDVQZQpzek5oaEdzaFFJOUtzaHlTZzdlaDJRN1paTzk1TktNeGRuanZHZU9JdGZGc1pRay9PTmlPLzRkYVdFR2s0bXNCCk1GV3JabWhuVkNEcTdNQk93dkxCUHordVo1YTdNWTZlYTZzWERud3BtNXMzSGYreEs3RT0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=\n" + 
    		"    client-key-data: LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQpNSUlFcEFJQkFBS0NBUUVBdnZOTFZ1MDNTSW1raEx1RUU1ZG11N3lTWDJDQmZkc29TVmhsY3B1aDFmTytwWUkvCm9wUjRKM0U3VFc0bHZUejVETTdUSTc3NG5BS1FmaGhnc25GQjdwODhBMnlaUFoydUY0cktBOVJRV0tXWlNJWHkKNU1Lb2g4RGRVNVEzckdEbzlkL2ZHMnQ2TGxUS3AwSnRWSjlINk9GU0tVcWhJODVBUHUwd1pGeC9UTVpXN1RFcAp5Wkl2ZVM5WlJGSVhGSkVXTGk3WC9lVlRrWDFQR1JQY1hHVlE0MHFVcElSSFdxNWNCbXYvakdGNTI4dDJMdktWCjhFUDV3c1FwTXZCZUZyS3h0ZG1LQ1I2dTJqVktuWXREVlZZWFF2ZExIRHFCa244N0FqcUhlRFNjbFQyMFhkTFUKVk54ckVSbGtiOVQ4TkhRVEV4MVNUakhrYjZabXAreFQ1YitrUVFJREFRQUJBb0lCQUh3NXM2M2RyYldYTmx6VAowVjBkaGt4a3BhVS9GMzlWY0tRbXlma0Jud3VlQTAyUnF1eU9RbzBHY1ZveWFvTHVnK2Y5TmdkdldqWEV4VlFECmNBVW5BWW5JTmpiVUUrMnVBM0IxYm0rSFZLNFhMZDJzcHhTRVB6ZnlGUXNteGdGekdwdTdCVjdGVVR1TEZqd3kKVHdaYWlXSE1GTE9nUmEwUnBXSksxTXkyRUd0VkRQdVFGTkZPUkIrOS9YblV1TTQ0aUtaS2h2SWJ4V2d3YmF6bQpGUDZwZCtnSUNpQXgzMkxQVDRneE5rL3lJVXRkUHdsaUxFS0hqZEo2cC9td3krU1B1RkduUjdCOFFmRnA3YTM2CnZqdUpxdzJveVRQUDhDbkloZTdXaGxwMWJvKzg0aXlhbW13ZzBreS9rRmFMU0NsYzdCdHBSUjJzUDNUMnQvUGgKZ2FQb1BERUNnWUVBN3Fka1dabDQ4OXZSdS94QlM0UFhKTGZzVnNkT2lXVzBlTDJoL0YwSFB1cTVHWVJHcVYrVAp0eVU1MmxvY285bVdLcW54NFVvZTV4TUpxOHZIaXN2T2FhK253V3htN1d3ckdjUUw0anZGeFNyZVdvMzZFN3VTCllpY1Z4V3BUcTRlMEN5ZGUxWnhOMHVhSzAwTmR1VEZ4QVRHUVlwbzRDVjhiQlVtRy9YdUJZUThDZ1lFQXpOUkoKdjY0QXA1V1NSdVI2RWk2MEw1UGd4V1Q1WEFjeCtVVTB6ODR3ZUZMVFVzYUpSaVZKUllLV1lOa3BoVm1GQ3JxcwprRFhweTlqcVN5SDhNUmlIcERmZFZMVE9zNVg3TmFFc3I4UkhiODY1eEI3QnR0RlROZHJOK2Z3SS93eEVwZDJKCldpbUo2NlFNamh4Z1o3VE9KcWRycFM4T2FGLzdBYy85SGhZSEJhOENnWUVBc0ZZdTU2Vm1vWWpDcDh2ejB3QlAKYjJvV3p1ZmxOOUJXVVFDTk9CTGt6N0JQcEhNQVl4V2o1NmN4NEF6RkxLd1JNT1R4UEMyd043enhZR2Jwd2J4bApmK0d5YWxEV25JZFlNV21SL2s5OENmdHE0QzRYb1l6dTFHZGN4c21SbVNSaisvblRNTEtWTGtmNk82K0RDTnRuClRDSjdOT0FPbDU0V01RbnJIRkN0Z0RFQ2dZQXc0TXZFZ09wSkUyazNuNWY5dE1Wc3dSWVhKTFJZb0tMdFAvV04KVFQvRnhzWUU3N21jVXBOOGtkLyt0bk94RFo2dzQ4RUFITTF3eG8rS1pFN0JESUI1MEpieGVzQUVuTnE0Zm9DaQpaTzFESWdxMFlUNkt1TUxwakJBeEFsTEhRZzh6b1gwQVZmOUNpd0F2L1ZlSUI5NVYzUWZVQURtbzhKWitaVHFhCnJsajRvd0tCZ1FDQmFUVzBhRDM5bmVnQmtDSXdMWkt0SVpZSzBVamNlWnp5U0k3RHRRNEh4aHJEVVpibVlRV3kKZkwyYXdRM2VsU0d2YkdVV1RZVnlFM0ZMOC9zYmFRNmZPQ3VkWDB4dy94UWkvb3VqL1pBQ1pOQThLR2l5Z0VPaQpYUUQxTHhKcGNBdURVbzRSMXVRdXp4N3laV2doV1lDTEx6RnJGbUl0b3BaZmJPVGxCbHdBRXc9PQotLS0tLUVORCBSU0EgUFJJVkFURSBLRVktLS0tLQo=\n" + 
    		"");
      }

  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
