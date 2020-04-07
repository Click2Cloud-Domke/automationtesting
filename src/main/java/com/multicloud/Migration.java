package com.multicloud;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Migration extends baseClass{
	WebDriver driver;
	By addtab=By.xpath("//div[@class='box12 boxClick migrationBox']//img[@class='add_img']");
	By Create=By.xpath("//div[@class='tab_container mg_tab_container']//button[@class='btn btn_blue'][contains(text(),'Create')]");
//	By PlanName=By.xpath();
//	By SourceSmartBucket=By.xpath();
	public Migration(WebDriver driver) {
		this.driver=driver; 
		
	}
	
  @Test
  public void ImmediateMigration() throws InterruptedException {
	  driver.findElement(addtab).click();
	  driver.findElement(Create).click();
	  Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@class='form-control mg_input ng-pristine ng-valid ng-empty ng-touched']")).sendKeys("migration");
	WebElement dr= driver.findElement(By.xpath("//div[@class='modal-body mg_modal-body lifeCycleBody mig_body']//div[2]//div[1]//div[1]//select[1]"));
	  Select sc=new Select(dr);
	  sc.deselectByIndex(2);
	  driver.findElement(By.xpath("//input[@class='form-control mg_input ng-pristine ng-valid ng-empty ng-touched']")).sendKeys("migration");
		WebElement des1= driver.findElement(By.xpath("//div[@id='createModal']//div[3]//div[1]//div[1]//select[1]"));
		  Select sc1=new Select(des1);
		  sc.deselectByIndex(2);
		  
		  
		  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}

