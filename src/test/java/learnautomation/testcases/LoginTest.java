package learnautomation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import learnautomation.pages.BaseClass;
import learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void testLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait time

        try {
            // Initialize LoginPage
            LoginPage loginPage = new LoginPage(driver);
            
            // Perform login
            loginPage.login("rajvarma@gmail.com", "rajvarma");
            Reporter.log("Login attempt with username: rajvarma@gmail.com");
            
            // Wait for a specific element that indicates a successful login
            WebElement someLoggedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//some-logged-in-element")));
            Assert.assertTrue(someLoggedInElement.isDisplayed(), "Login failed.");
            
            //scrollI

            // Perform logout
            loginPage.logout();
            Reporter.log("Logout attempt");

            // Wait for a specific element that indicates a successful logout
            WebElement someLoggedOutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//some-logged-out-element")));
            Assert.assertTrue(someLoggedOutElement.isDisplayed(), "Logout failed.");
            
        } catch (Exception e) {
            Reporter.log("Exception occurred: " + e.getMessage());
            Assert.fail("Test failed due to an exception.");
        }
    }
}
