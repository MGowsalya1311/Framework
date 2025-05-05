package com.tp.practise;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPOM {
	public AmazonPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='_1BJVlg']")
	private List<WebElement> menuItem1;

@FindBy(xpath = "//a[@class='_3490ry']")
	private List<WebElement> menuItem2;

	public List<WebElement> getMenuItem2() {
		return menuItem2;
	}

	public List<WebElement> getMenuItem1() {
		return menuItem1;
	}
	
}
