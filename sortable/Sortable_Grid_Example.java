package com.demoqaInteractions.sortable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sortable_Grid_Example {

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
			//ClickOn_Sortable
			driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[1]")).click();
			Thread.sleep(2000);
			//Finding All WebElements
			driver.findElement(By.linkText("Grid")).click();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action']"));
			
			for(int i=1;i<list.size();i++) {
				
				WebElement element = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action']["+ i +"]"));
			
				WebElement destination9 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][9]"));
				WebElement destination8 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][8]"));
				WebElement destination7 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][7]"));
				WebElement destination6 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][6]"));
				WebElement destination5 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][5]"));
				WebElement destination4 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][4]"));
				WebElement destination3 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][3]"));
				WebElement destination2 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][2]"));
				WebElement destination1 = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action'][1]"));
			
				Actions action = new Actions(driver);
				
				if(element != null) {
				action.dragAndDrop(element, destination9).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination8).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination7).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination6).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination5).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination4).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination3).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination2).perform();
				Thread.sleep(2000);
				action.dragAndDrop(element, destination1).perform();
				break;
				}
			}
			
			
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






