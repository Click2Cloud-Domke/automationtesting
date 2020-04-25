package com.multicloud;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Lifecycle extends baseClass {
	public Lifecycle(WebDriver driver) {
		this.driver=driver; 
		
	}
	@Test(priority=0)
	  public void lifecycle() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//div[contains(text(),'aws')]")).click();
		Thread.sleep(1000);
	//	driver.findElement(By.xpath("//a[contains(text(),'LifeCycle')]")).click();
		//Thread.sleep(1000);
		}
		@Test(priority=0)
		  public void lifecyclecreate() throws InterruptedException, IOException {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//body//div[@id='main-content']//div[@id='main-content']//div//div//div//div//div//div//li[2]//a[1]")).click();
			Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='tab_container']//button[@class='btn btn_blue'][contains(text(),'Create')]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@id='lifeCycleModal']//div[@class='modal-content mg_modal-content']")).click();
		driver.findElement(By.xpath("//body//div[@id='lifeCycleModal']//div//div//div//div[2]//div[1]//div[1]//input[1]")).sendKeys("transitionrule2 for bucket");
	
		driver.findElement(By.xpath("//body//div[@id='lifeCycleModal']//div//div//div//div//div[2]//div[1]//input[1]")).sendKeys("prifix2");
	driver.findElement(By.xpath("//div[@id='lifeCycleModal']//div[3]//div[1]//div[1]//label[1]//span[1]")).click();
	driver.findElement(By.xpath("//div[@id='lifeCycleModal']//div[4]//div[1]//div[1]//div[1]//label[1]//span[1]")).click();
	
	driver.findElement(By.xpath("//div[@id='lifeCycleModal']//button[2]")).click();
	Thread.sleep(1000);
	driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	}
	@Test(priority=1)
	  public void deleteobject() throws InterruptedException, IOException {
		Thread.sleep(1000);
    driver.findElement(By.xpath("//a[contains(text(),'Object')]")).click();
	driver.findElement(By.xpath("//a[@id='deleteObjectID']")).click();
	driver.findElement(By.xpath("//div[@class='actions open']//a[contains(text(),'Delete')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//img[@class='back_img']")).click();
	}
	@Test(priority=2)
	  public void lifecycledeleteobject() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//div[contains(text(),'aws')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'LifeCycle')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='tab_container']//button[@class='btn btn_blue'][contains(text(),'Create')]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@id='lifeCycleModal']//div[@class='modal-content mg_modal-content']")).click();
		driver.findElement(By.xpath("//input[@name='ruleLifecycle']")).sendKeys("transitionrule for bucket");
	
		driver.findElement(By.xpath("//input[@name='prefixLifecycle']")).sendKeys("prifix");
	
	driver.findElement(By.xpath("//div[6]//div[1]//div[1]//label[1]//span[1]")).sendKeys("1");
	driver.findElement(By.xpath("//input[@name='deleteDaysAfter']"));
	driver.findElement(By.xpath("//div[@id='lifeCycleModal']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]")).click();
}
	@Test(priority=2)
	  public void lifecycledelete() throws InterruptedException, IOException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='lifeCycleDelete']")).click();
		driver.findElement(By.xpath("//div[@id='tab_lifecycle']//div//div//div//div//div//div//div//div//div//ul[@id='tcodrop']//a")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		
}}
