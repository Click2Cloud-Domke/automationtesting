package com.multicloud;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;

public class MigrationTest {
	WebDriver driver;
	By addtab=By.xpath("//div[@class='box12 boxClick migrationBox']//img[@class='add_img']");
	By Create=By.xpath("//div[@class='tab_container mg_tab_container']//button[@class='btn btn_blue'][contains(text(),'Create')]");
//	By PlanName=By.xpath();
//	By SourceSmartBucket=By.xpath();
	
	
  @Test(alwaysRun = true)
  public void ImmediateMigrationCephtoIBM() throws InterruptedException {
	  driver.findElement(addtab).click();
	  driver.findElement(Create).click();
	  Thread.sleep(3000);
	 // driver.findElement(By.xpath("//div[@class='modal-body mg_modal-body lifeCycleBody mig_body']")).click();
	 driver.findElement(By.xpath("//input[@name='migName']")).sendKeys("newmigrationcti-01");
	WebElement dr= driver.findElement(By.xpath("//div[@class='modal-body mg_modal-body lifeCycleBody mig_body']//div[2]//div[1]//div[1]//select[1]"));
	  dr.click();
	  Select selectBox = new Select(dr);
	    int selectOptions = selectBox.getOptions().size();
	    selectBox.selectByIndex(selectOptions - 1);
	
	//  driver.findElement(By.xpath("//input[@class='form-control mg_input ng-pristine ng-valid ng-empty ng-touched']")).sendKeys("migration");
		WebElement des1= driver.findElement(By.xpath("//div[@id='createModal']//div[3]//div[1]//div[1]//select[1]"));
		 Select selectBox1 = new Select(dr);
		    int selectOptions1 = selectBox1.getOptions().size();
		    selectBox1.selectByIndex(selectOptions1 - 1);
		 
		 	  
		 driver.findElement(By.xpath("//button[contains(text(),'Migrate')]")).click();
		 Thread.sleep(2000);
		 System.out.println( driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 JavascriptExecutor js = (JavascriptExecutor) driver;     		
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 
	WebElement	text=driver.findElement(By.xpath("//div[contains(text(),'newmigrationcti-01')])"));
	System.out.println(text);
	driver.findElement(By.xpath("//div[contains(text(),'newmigrationcti-01')]")).click();
		  
	  
  }
  @Test(alwaysRun = true)
  public void ImmediateMigrationIbmtoCeph() throws InterruptedException {
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
