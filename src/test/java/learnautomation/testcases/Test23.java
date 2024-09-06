package learnautomation.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import learnautomation.pages.BaseClass;
import learnautomation.pages.LoginPage;

public class Test23 extends BaseClass{
	
	
	 @Test
	    public void Test1() 
	{ 
		String title = driver.getTitle();
		System.out.print("Title: "+title);
		String getCurrentURL = driver.getCurrentUrl();
		System.out.print("\ngetcurrentURL: "+getCurrentURL);
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement se = driver.findElement(By.xpath("//select[@id='dropdown']"));
		
		Select x = new Select(se);
		
		x.selectByVisibleText("Option 1");
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='dropdown']")));
		
		FluentWait<WebDriver> w = new FluentWait<WebDriver>(driver) ;
		w.withTimeout(Duration.ofSeconds(4));
		w.pollingEvery(Duration.ofSeconds(10));
		w.ignoring(Throwable.class);
	}

}