package com.tp.practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KsrtcCalendar {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.ksrtc.in/");
		
		WebElement from_ele = driver.findElement(By.id("fromCity"));
		Select select = new Select(from_ele);
		select.selectByVisibleText("ahh");
		
	}

}
