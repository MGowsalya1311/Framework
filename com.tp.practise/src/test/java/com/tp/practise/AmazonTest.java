package com.tp.practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTest {

	
		public static void main(String[] args) throws InterruptedException
		{
		 //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
			AmazonPOM ap = new AmazonPOM(driver);

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().window().maximize();
		 driver.get("https://www.flipkart.com/");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//span[text()='Electronics']")).click();
		 List<WebElement> menuitems = ap.getMenuItem1(); 
		 Actions a = new Actions(driver);		
		 System.out.println("Menu Items:");
	        for (WebElement menuItem : menuitems)
	            System.out.println(menuItem.getText());
	        for (int ii=0;ii<menuitems.size();ii++){
	            a.moveToElement(menuitems.get(ii)).perform();
	            Thread.sleep(3000);
	            
	            List<WebElement> menuitems2 = driver.findElements(By.xpath("//div[@class='_1UgUYI _2eN8ye']/descendant::div[@class='_31z7R_']"));
	            		//ap.getMenuItem2();
	            if(menuitems2.size()!=0) {	
	            	for(int i=0;i<menuitems2.size();i++) {
		            	System.out.println(menuitems2.get(i).getText());
		            }	
	            	System.out.println("==============================");
	            }}
	            
	            
	        
	        driver.quit();
		}
	}
