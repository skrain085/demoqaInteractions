package com.demoqaInteractions.resizable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Resizable_Example {

WebDriver driver;
	
	@BeforeMethod
	public void driverInitialize() {
		try {
			
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   driver.get("https://demoqa.com/");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void FunctionMethod() {
		try {
			//scrollDown
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(7000);
			//ClickOn_Interactions	
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div/div[3]")).click();
			Thread.sleep(2000);
			//scrollDown
			JavascriptExecutor js1 = (JavascriptExecutor) driver;  
			js1.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(4000);
			//ClickOn_Resizable
			driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[3]")).click();
			Thread.sleep(2000);
			//ClickOn_Resizable_Box_Within_Restriction
			WebElement resizable_element = driver.findElement(By.id("resizableBoxWithRestriction"));
			Actions actions = new Actions(driver);
			actions.moveToElement(resizable_element, 200, 200).perform();
			actions.dragAndDropBy(resizable_element, 500, 300).perform();
			
			//scrollDown
			JavascriptExecutor js2 = (JavascriptExecutor) driver;  
			js2.executeScript("window.scrollBy(0,250)", "");
			
			//ClickOn_Resizable
			driver.findElement(By.linkText("Resizable")).click();
		    WebElement resizable_element1 = driver.findElement(By.xpath("//div[@id='resizable']"));
			actions.dragAndDropBy(resizable_element1, 100, 50).perform();
			Thread.sleep(2000);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	@AfterMethod
	public void closeApplication() {
		//Closing the Application
		driver.quit();
	}
}




