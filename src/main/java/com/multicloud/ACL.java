package com.multicloud;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ACL {
	static WebDriver driver;

	public ACL(WebDriver driver) {
		this.driver=driver; 
}
	

	@Test()
	public void aclread() throws InterruptedException {
		driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
		driver.findElement(By.xpath("//div[@class='actions open']//ul[@id='tcodrop']//a[1]")).click();
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='aclModal']//div[@class='row']//div[1]//div[1]//label[1]//span[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='aclModal']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]")).click();
	  driver.switchTo().alert().accept();

}
	@Test()
	public void aclwrite() throws InterruptedException {
		driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
		driver.findElement(By.xpath("//div[@class='actions open']//ul[@id='tcodrop']//a[1]")).click();
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='aclModal']//div[@class='row']//div[1]//div[1]//label[1]//span[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='aclModal']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]")).click();
	  driver.switchTo().alert().accept();
	}
	@Test()
	public void aclboth() throws InterruptedException {
		driver.findElement(By.xpath("//body/div[@id='center_div']/div[@class='container-fluid C2C_Container CDNoListNav container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@class='row C2CRowMain1 max-height']/div[@class='col-md-12 C2CTaskbar max-height']/div[@id='main-content']/div[@class='col-md-12 C2C_Middle_12']/div[@id='StorageID']/div/div[@class='container-pf-nav-pf-vertical container-pf-nav-pf-vertical-with-sub-menus']/div[@id='main-content']/div[@class='col-md-12']/div[@class='top_header']/div[@class='row']/div[@class='col-md-12 col-xs-12 col-sm-12']/div[@class='row']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='TAB1']/div[@class='row']/div[@class='col-md-12']/div[@class='storage_container']/div[@class='row']/div[@class='storage_container_main']/div[@class='col-md-10 col-sm-10 col-xs-10 RightSection storageCreation']/div[@class='storage_container_right']/div[@class='row']/div[@class='storage_box_container']/div[@class='storage_box_parent cust_box_parent']/div[1]/div[1]/div[2]/div[4]/a[1]")).click();
		driver.findElement(By.xpath("//div[@class='actions open']//ul[@id='tcodrop']//a[1]")).click();
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='aclModal']//div[@class='row']//div[1]//div[1]//label[1]//span[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='aclModal']//button[@class='btn mg_submit-btn-green'][contains(text(),'Save')]")).click();
	  driver.switchTo().alert().accept();
	}
	}
