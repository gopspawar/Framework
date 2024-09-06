package learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     WebDriver driver;

    @FindBy(name = "email")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath="//a[@href='/login']")
    WebElement loginLink;

    @FindBy(xpath="//a[@href='/logout']")
    WebElement logoutButton;
    
    @FindBy(xpath="//a[@href='/products']")
    WebElement Productlink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void logout() {
        logoutButton.click();
    }
    public void clickonproduct() {
    	Productlink.click();
    }
    public void pass(String username1) 
    {
    	usernameField.sendKeys();
    }
   public void getTitle() {
	   String title = driver.getTitle();
		System.out.println("Title: "+title);
   }
   public void getcurrentURL() {
	   String currenturl= driver.getCurrentUrl();
	   System.out.println("CurrentUrl: "+currenturl);
   }
   }
