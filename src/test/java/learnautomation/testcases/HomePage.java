package learnautomation.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import learnautomation.pages.BaseClass;
import learnautomation.pages.LoginPage;

public class HomePage extends BaseClass {

    @Test
    public void testLogin() throws IOException {
       
            // Initialize LoginPage
            LoginPage loginPage = new LoginPage(driver);
            
            // Perform login
            loginPage.login("rajvarma@gmail.com", "rajvarma");
            Reporter.log("Login attempt with username: rajvarma@gmail.com");

            // Take screenshot after login
            takeScreenshot("loginPage");

            // Click on product (ensure this method exists in LoginPage class)
            loginPage.clickonproduct();
            
            // Perform logout
            loginPage.logout();

            // Take screenshot after logout
            takeScreenshot("logoutPage");
            
            
           
          
          
       
    }
    
    // Method to take a screenshot with a unique filename
    public void takeScreenshot(String filename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        
        // Create a unique filename using a timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File destFile = new File("C:\\Users\\LENOVO\\eclipse-workspace\\lavatech\\src\\AutomationQA\\framework\\Screenshot\\" + filename + "_" + timestamp + ".png");
        
        // Copy the screenshot to the destination
        FileUtils.copyFile(srcFile, destFile);

        Reporter.log("Screenshot taken and saved at: " + destFile.getAbsolutePath());
    }
    //
}
