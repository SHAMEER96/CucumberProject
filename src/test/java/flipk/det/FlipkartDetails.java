package flipk.det;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartDetails {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHAMEER\\eclipse-workspace\\FlipkartD\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	//WebElement fe = driver.findElement(By.xpath("//button[text()='✕']"));
	if((driver.findElement(By.xpath("//button[text()='✕']"))).isDisplayed()) {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
	
	WebElement search=driver.findElement(By.xpath("//input[@type='text']"));
	search.sendKeys("redmi",Keys.ENTER);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//span[text()='Filters']")).click();
	List<WebElement> li = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	List<WebElement>li1=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

	
	File f = new File("C:\\Users\\SHAMEER\\Desktop\\Book1.xlsx");
	FileInputStream ff = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(ff);
	Sheet ws = wb.getSheet("shammeer");
	for (int i = 0; i <li.size(); i++)
	{
			
	Row r = ws.createRow(i);
	Cell c = r.createCell(0);
	Cell c1 =r.createCell(1);
	WebElement s = li.get(i);
	c.setCellValue(s.getText());
	System.out.println(s.getText());
	WebElement t = li1.get(i);
	System.out.println(t.getText());
	c1.setCellValue(t.getText());
	}
	FileOutputStream fff = new FileOutputStream(f);
	wb.write(fff);
	Thread.sleep(4000);
	driver.quit();
	
	}

}
