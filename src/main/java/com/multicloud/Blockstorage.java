package com.multicloud;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.WebDriver;

public class Blockstorage {
	static WebDriver driver;

	public Blockstorage(WebDriver driver) {
		this.driver=driver; 
		
	}
	public void volume() {

		    WebElement Storage = driver.findElement(By.xpath("//*[@id='maintab']/li[5]/a/span[2]"));


		    new Actions(driver).moveToElement(Storage).perform();


		    WebElement BlockStorage = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_item_storage_management']/a/span")));
		    BlockStorage.click();


		    }    
		    @Test(priority = 2)
		    public static void AddStorage() throws InterruptedException
		    {
		        
//		    driver.findElement(By.xpath("//div[@id='s1']/div/div/div/div/div[3]/div/div/div/div/select")).click();
//		    driver.findElement(By.xpath("//select[@id='sel1']")).click();
		    Select drpstorage = new Select(driver.findElement(By.xpath("//*[@id='sel1']"))); 
		    drpstorage.selectByIndex(1);
		    
		    driver.findElement(By.xpath("//*[@id='exampleModalLongInfo']/div/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    //Add volume in Ceph
		    driver.findElement(By.xpath("//i/img")).click();
		    
		    }
		    
		    
		
		 









	}


