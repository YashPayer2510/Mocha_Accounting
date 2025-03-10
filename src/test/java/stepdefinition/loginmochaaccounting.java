package stepdefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginmochaaccounting {
	WebDriver driver;

    @Given("Browser is open")
    public void browser_is_open() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Yash\\eclipse\\chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.uat.mochaaccounting.com/login");
        Thread.sleep(3000);
    }


    
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
    	//assertTrue(driver.getTitle().contains("Login to your Mocha account"));
        //throw new io.cucumber.java.PendingException();
    	//WebElement Logintitle=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/div[1]/h5/p"));
    	//String Logintitletext= Logintitle.getText();
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/div[1]/h5/p")).getText(), "Login to your Mocha account"); 
    }

    @When("User enters the {string} and {string}")
    public void user_enters_the_email_id_and_password(String emailID, String password) {
    	WebElement emailField = driver.findElement(By.id("email"));  // Replace with actual ID or locator
        emailField.sendKeys(emailID);  
        
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/form/div[2]/div/input"));  // Replace with actual ID or locator
        passwordField.sendKeys(password);
    
    }

    @When("User clicks on the Login button")
    public void user_clicks_on_the_login_button() {
    	WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/form/div[3]/div[2]/button"));  // Replace with actual ID or locator
        loginButton.click();
       // throw new io.cucumber.java.PendingException();
    }
    

@Then("User should see {string}")
public void user_should_see_message(String expectedMessage) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    WebElement messageElement = wait.until(
//        ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/p"))  // Replace with actual ID or locator
//    );
//    
//    String actualMessage = messageElement.getText();
//  //  throw new io.cucumber.java.PendingException();
//    
//    assertTrue(actualMessage.contains(expectedMessage));
//    driver.quit();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Check if the expected message is related to the Dashboard
    if (expectedMessage.equalsIgnoreCase("Dashboard")) {
        // Wait for the page to load and check if the URL contains 'dashboard' (or any part of the URL that indicates dashboard)
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // Assert that the user has been redirected to the dashboard
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl, currentUrl.contains("dashboard"));
    } 
    // If expected message is related to an error (Invalid username/password)
    else {
        // Wait for the error message to be visible
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/p")));  
        
        // Get the actual error message
        String actualErrorMessage = errorMessage.getText();
        
        // Assert that the actual error message matches the expected error message
        Assert.assertTrue(actualErrorMessage, actualErrorMessage.contains(expectedMessage));
    }
}
}

	

