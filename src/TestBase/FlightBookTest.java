package TestBase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import TestCase.Login;
import junit.framework.TestCase;



public class FlightBookTest extends TestCase {
	
	WebDriver driver;
	 
	@Test
public  void loginpage () throws Exception
{
	

	System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	
	ChromeOptions co=new ChromeOptions();
	
	
	co.setBinary("C:\\Users\\akash\\Downloads\\chrome-win64\\chrome.exe");
	 driver = new ChromeDriver(co);
	
	 JavascriptExecutor js= (JavascriptExecutor)driver;
	
	 js.executeScript("window.scrollBy(0,1000)");
	 
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String fileWithPath = null;
	 File DestFile=new File(fileWithPath);
	
	FileUtils.copyFile(src, DestFile);
	 


	 
	 
	System.out.println("ask");
//	driver.wait(2000);
	driver.get("http://www.google.com");
	
     
	
     
     
	driver.manage().window().maximize();
	
	Set<String>countpop=driver.getWindowHandles();
	String ss=driver.getWindowHandle();
	System.out.println(countpop.size());
	
	WebElement ifra=driver.findElement(By.xpath("//iframe[@role='presentation']"));
	
	driver.switchTo().frame(ifra);
	driver.findElement(By.xpath("//button[@class='M6CB1c rr4y5c']")).click();
	driver.switchTo().defaultContent();
	WebElement search=driver.findElement(By.xpath("//*[@title='Search']"));
	search.click();
	
	search.sendKeys("MMT");
	search.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//a[@class='sVXRqc']")).click();
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebDriverWait wait= new WebDriverWait(driver,30);
	List<WebElement> allopt=driver.findElements(By.xpath("//span[@class='headerIconWrapper'][1]"));
	wait.until(ExpectedConditions.visibilityOfAllElements(allopt));
	
	List<WebElement> cities=driver.findElements(By.xpath("//span[@class='truncate airPortName ']"));
	System.out.println(cities.size());
	Iterator<WebElement> it= cities.iterator();
	
	for( it=cities.iterator();it.hasNext();)
	{
			
		WebElement e=it.next();
		e.getSize();
		e.click();
		WebElement ce=driver.findElement(By.xpath("//input[@placeholder='From']"));
		ce.sendKeys("varanasi");
		List<WebElement> listcity= driver.findElements(By.xpath("//ul[@role='listbox']"));
		//wait.until(ExpectedConditions.visibilityOfAllElements(listcity));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		ce.sendKeys(Keys.ARROW_DOWN);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		ce.sendKeys(Keys.ENTER);
		
		
		while(it.hasNext())
		{
			WebElement cf=driver.findElement(By.xpath("//input[@id='toCity']"));
			cf.click();
			WebElement cfrom=driver.findElement(By.xpath("//input[@placeholder='To']"));
			
			cfrom.sendKeys("pune");
			
			Robot rob = new Robot();
			rob.keyPress(KeyEvent.VK_DOWN);
		
			rob.keyPress(KeyEvent.VK_DELETE);
			rob.keyRelease(KeyEvent.VK_DELETE);
			//swait.until(ExpectedConditions.visibilityOfAllElements(listcity));
			cfrom.sendKeys(Keys.ARROW_DOWN);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			cfrom.sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			it.next();
			
			
		}
		
		
	}
	
	
	
	
	
}

	@BeforeTest
	  public void beforeMethod() {

	      System.out.println("Before Test");
	  }
	
	@AfterTest()
	public void logout()
	{
		
		driver.quit();
		
		
	}
	
  
}
