package com.appiumtest.todoist;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TodoistTest {
	
	public DesiredCapabilities dc;
	public AndroidDriver<AndroidElement> driver;
	
	public WebDriver chDriver;
	
	@BeforeClass
	public void setup() {
		
		 dc = new DesiredCapabilities();
	      dc.setCapability("deviceName", "emulator-5554");
	      dc.setCapability("platformName","android");
	      dc.setCapability("appPackage", "com.todoist");
	      dc.setCapability("appActivity", ".activity.HomeActivity");

	      try {
			 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
  

  @Test
  public void loginToMobileApp() throws InterruptedException {
	  
	  
	  MobileElement el1 = (MobileElement) driver.findElementById("com.todoist:id/btn_welcome_email");
	  el1.click();
	  MobileElement el2 = (MobileElement) driver.findElementById("com.todoist:id/email_exists_input");
	  el2.sendKeys("a.shivakumar@yahoo.com");
	  MobileElement el3 = (MobileElement) driver.findElementById("com.todoist:id/btn_continue_with_email");
	  el3.click();
	  MobileElement el4 = (MobileElement) driver.findElementById("com.todoist:id/log_in_password");
	  el4.sendKeys("Password@123");
	  MobileElement el5 = (MobileElement) driver.findElementById("com.todoist:id/btn_log_in");
	  el5.click();
	  MobileElement el6 = (MobileElement) driver.findElementById("android:id/button2");
	  el6.click();


	  
	  driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Change the current view\"]")).click();
	  
  }
  
  @AfterClass
  public void closeDriver() {
	  
	  driver.close();
	  driver.quit();
	  
  }
}
