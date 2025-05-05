package com.tp.practise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class HotStar {
	public static void main(String args[]) throws InterruptedException, IOException {
		 String movieName = "Frozen";
			
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	
		driver.get("https://www.hotstar.com/in/home");
		
		
		driver.findElement(By.xpath("//button[@class='_1hU3TdoXFJGL0DTrPda9SF']")).click();
		
		
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        // Print total number of links
        System.out.println("Total links: " + allLinks.size());

        // Print the href for each link
        for (WebElement link : allLinks) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                System.out.println(url);
            }
        }
        
        List<WebElement> images = driver.findElements(By.tagName("img"));

        // Print total number of images
        System.out.println("Total images: " + images.size());

        // Loop through and print the src of each image
        for (WebElement img : images) {
            String imageSrc = img.getAttribute("src");
            System.out.println(imageSrc);
        }
        
    	
		WebElement movie_elmt = driver.findElement(By.xpath("(//span[@class='LHDmaByQeS8uy1wgLgxz_'])[4]"));
	
		Actions action = new Actions(driver);
		action.moveToElement(movie_elmt).perform();
		
		movie_elmt.click();
		
		Thread.sleep(2000);
	
		JavascriptExecutor jse = (JavascriptExecutor)driver; {
			jse.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(By.xpath("//img[@alt='Spider-Man']"))); 	
				
			
		};
		driver.findElement(By.xpath("//p[text()='Search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchBar")).sendKeys(movieName,Keys.ENTER);
		
		
		WebElement elmt = driver.findElement(By.xpath("//p[text()='"+movieName+"']/../../..//img"));
				//driver.findElement(By.xpath("//img[@alt='Spider-Man: Homecoming']"));
		action.moveToElement(elmt).doubleClick().perform();
		Thread.sleep(10000);
      //  elmt.click();
        TakesScreenshot tks = (TakesScreenshot)driver;
       File src = tks.getScreenshotAs(OutputType.FILE);
       File image = new File("./screenShot/sample2.png");
       FileHandler.copy(src, image);
       Thread.sleep(2000);
       driver.quit();
//		List<WebElement> links = driver.findElements(By.xpath("//a"));
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
	
	}
}
