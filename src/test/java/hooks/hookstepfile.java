package hooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.createProductPage;
import Utilities.ProductExcelReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class hookstepfile {
    private WebDriver driver;
    private createProductPage createProduct;
    private List<Map<String, String>> testData; // To store test data from Excel

    @SuppressWarnings("deprecation")
	@Before
    public void setUp() throws InterruptedException, IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        // Load test data from Excel
        loadTestData();

        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Yash\\eclipse\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        // Navigate to the login page
        driver.get("https://main.mochaaccounting.com/login");
        Thread.sleep(3000); // Wait for the page to load

        // Perform login
        driver.findElement(By.id("email")).sendKeys("payeryash10@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/form/div[2]/div/input"))
                .sendKeys("Password@1234");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/form/div[3]/div[2]/button"));
        loginButton.click();
        
        //Thread.sleep(9000);

        // Initialize the createProductPage object
        createProduct = new createProductPage(driver);
    }

    @After
    public void tearDown() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Logout and close the browser
    	
    	
       // Thread.sleep(3000); // Wait for actions to complete
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/ul[3]/li/a/div"))).click(); // Click on the user menu
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/ul[3]/li/ul/li[2]/a")).click(); // Click on logout
        driver.quit(); // Close the browser
    }

    public WebDriver getDriver() {
        return driver;
    }

    public createProductPage getCreateProductPage() {
        return createProduct;
    }

    public List<Map<String, String>> getTestData() {
        return testData;
        
    }

    // Method to load test data from Excel
    public void loadTestData() throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        String filePath = "C:\\Users\\Yash Payer\\CreateExcelSheet\\CreateProduct.xlsx";  // Set the path to your Excel file
        testData = ProductExcelReader.readExcelDataWithHeaders(filePath);  // Read data from Excel into testData list
    }
    
    
}