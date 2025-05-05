 package com.tp.practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAppQspidersTest {

	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		List<WebElement> itemName = driver.findElements(By.xpath("//th[text()='Item name']/../../..//th[@scope='row']"));

		List<WebElement> price = driver.findElements(By.xpath("//th[text()='Price']/../../..//td[4]"));


		FileInputStream fis = new FileInputStream("C:\\Users\\mailm\\OneDrive\\Desktop\\Java\\Eclipse_Projects\\com.tp.practise\\testData\\demoData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");

		for(int i=0;i<itemName.size();i++) {

			WebElement ele = itemName.get(i);
			WebElement e = price.get(i);

			Row r = sheet.createRow(i);
			Cell c = r.createCell(0,CellType.STRING);
			c.setCellValue(ele.getText());
			Cell c1 = r.createCell(1,CellType.STRING);
			c1.setCellValue(e.getText());


			System.out.println(ele.getText()+"\t"+e.getText());

		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\mailm\\OneDrive\\Desktop\\Java\\Eclipse_Projects\\com.tp.practise\\testData\\demoData.xlsx");	
		wb.write(fos);
		wb.close();

		driver.quit();

	}

}

