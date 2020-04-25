package com.multicloud;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cloudbrain extends baseClass {
	WebDriver driver;

	public cloudbrain(WebDriver driver) {
		this.driver=driver; 
	}
	@Test(alwaysRun = true,priority=0)



	public void url() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/puja.domke/Downloads/chromedriver_win32_new/chromedriver.exe");
		  driver = new ChromeDriver();
		 // driver.get("192.168.3.235:30510");
		  Thread.sleep(2000);
			driver.get("http://192.168.3.235:30010/");
		//driver.get("http://192.168.3.9:3000/");
		  driver.manage().window().maximize();
		// TODO Auto-generated method stub
		
	}}
