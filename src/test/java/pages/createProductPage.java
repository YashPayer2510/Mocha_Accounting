package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createProductPage {
    WebDriver driver;
    
    By btn_submodSales = By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]/div[2]/div/div/div/li[3]/a");
    By btn_submodProductService = By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]/div[2]/div/div/div/li[3]/ul/li[4]/a");
    By btn_newProductService = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/button[1]");
    By inptxt_PrdudctServiceName = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[1]/div/div/input");
    By dd_ProductUnit = By.id("react-select-2-input");
    By dd_ProductType = By.id("react-select-3-input");
    By dd_InventoryAccount = By.id("react-select-4-input");
    By inpnum_Quantityonhand = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[4]/div[2]/div/div/input");
    By datep_AsofDate = By.className("react-datepicker__input-container");
    By inptxt_SKU = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[5]/div/div/input");
    By dd_HSNcode = By.id("react-select-5-input");
    By dd_ProductCategory = By.id("react-select-6-input");
    By dd_ProducIncomeAccount = By.id("react-select-7-input");
    By inpnum_SalePrice = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[9]/div/div/input");
    By dd_ProductExpenseAccount = By.id("react-select-8-input");
    By inpnum_CostPrice = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[11]/div/div/input");
    By dd_Tag = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[12]/div/div/div/div");
    By inptext_ProductDescription = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[13]/div/div/textarea");
    By attachment_ProductAttachments = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[14]/div/div/div");
    By btn_ProductCancel = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div[1]/button[1]");
    By btn_ProductClear = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div[1]/button[2]");
    By btn_ProductSaveandClose = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div[2]/button[1]");
    By btn_ProductSaveandNew = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div[2]/button[2]");
    
	public createProductPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void scrollToElement(WebElement  element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element );
	    try {
	        Thread.sleep(500);  // Add a small delay to allow the scroll action to complete
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void submodSales() {
		WebElement elesubmodsale = driver.findElement(btn_submodSales);
		scrollToElement(elesubmodsale);
		elesubmodsale.click();
		
		}
	public void submodProductService() {
		WebElement elesubmodProductService = driver.findElement(btn_submodProductService);
		scrollToElement(elesubmodProductService);
		elesubmodProductService.click();
		
		}
	public void newProductService() {
		WebElement elenewProductService = driver.findElement(btn_newProductService);
		scrollToElement(elenewProductService);
		elenewProductService.click();
	
	}
	public void PrdudctServiceName (String productServiceName) {
		WebElement elePrdudctServiceName = driver.findElement(inptxt_PrdudctServiceName);
		scrollToElement(elePrdudctServiceName);
		elePrdudctServiceName.sendKeys(productServiceName);
	
	}
	public void ProductUnit(String productUnit) throws InterruptedException {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement unitDropdown = driver.findElement(dd_ProductUnit);
	    scrollToElement(unitDropdown);

	    // Click on the dropdown input field
	    unitDropdown.click();
	    
	    // Type the product unit into the input field
	    unitDropdown.sendKeys(productUnit);

	    // Wait for the dropdown options to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'option')]")));
	    // Capture all the options in the dropdown
	    List<WebElement> unitOptions = driver.findElements(By.xpath("//div[contains(@class, 'option')]"));

	    // Iterate through the options to find a match
	    for (WebElement option : unitOptions) {
	    	 if (option.getText().trim().equalsIgnoreCase(productUnit)) {
	             option.click(); // Select the matched option
	             break;
	        }
	    }
	}

	public void ProductType(String productType) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement productTypeDropdown = driver.findElement(dd_ProductType);
	    scrollToElement(productTypeDropdown);

	    // Click on the dropdown input field
	    productTypeDropdown.click();
	    
	    // Type the product unit into the input field
	    productTypeDropdown.sendKeys(productType);

	    // Wait for the dropdown options to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'option')]")));
	    // Capture all the options in the dropdown
	    List<WebElement> typeOptions = driver.findElements(By.xpath("//div[contains(@class, 'option')]"));

	    // Iterate through the options to find a match
	    for (WebElement option : typeOptions) {
	    	 if (option.getText().trim().equalsIgnoreCase(productType)) {
	             option.click(); // Select the matched option
	             break;
	        }
	    }
	
	}
	
	public void InventoryAccount(String inventoryAccount) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement inventoryAccountDropdown = driver.findElement(dd_InventoryAccount);
	    scrollToElement(inventoryAccountDropdown);

	    // Click on the dropdown input field
	    inventoryAccountDropdown.click();
	    
	    // Type the product unit into the input field
	    inventoryAccountDropdown.sendKeys(inventoryAccount);

	    // Wait for the dropdown options to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'option')]")));
	    // Capture all the options in the dropdown
	    List<WebElement> inventoryaccountOptions = driver.findElements(By.xpath("//div[contains(@class, 'option')]"));

	    WebElement bestMatch = null;
	    
	    for (WebElement option : inventoryaccountOptions) {
	        String optionText = option.getText().trim();
	        
	        // Check if the option contains the desired text
	        if (optionText.toLowerCase().contains(inventoryAccount.toLowerCase())) {
	            bestMatch = option; // Store the best match
	            break;
	        }
	    }

	    // Click the best match if found
	    if (bestMatch != null) {
	        bestMatch.click();
	     
	    }
	}
	
	public void Quantityonhand(String quantityOnHand) {
		WebElement eleQuantityonhand = driver.findElement(inpnum_Quantityonhand);
		eleQuantityonhand.sendKeys(quantityOnHand);
		}
	

	public void AsofDate(String asofDate) throws InterruptedException {
//		 // Split the input string into MonthYear and FullDate
//	    String[] parts = asofDate.split(", ");
//	    String Months_Year = parts[0];   // Desired month and year in MMMM YYYY
//	    String dateToSelect = parts[1];   // Desired date to select in MMMM DD,YYYY
//        // Click on the date picker input field
//	    WebElement eleAsofDate =  driver.findElement(datep_AsofDate);
//	    eleAsofDate.click();
//        // Get the current month and year from the date picker
//        String CurrentMonth_Year = driver.findElement(By.className("react-datepicker__current-month")).getText();
//       // String Months_Year = MonthYear;    // Desired month and year in MMMM YYYY
//        //String dateToSelect = FullDate; // Desired date to select in MMMM DD,YYYY
//
//        // Check if the current month and year match the desired month and year
//        if(!CurrentMonth_Year.equalsIgnoreCase(Months_Year)) {
//            // If the desired month is in the future
//            if (isFutureDate(CurrentMonth_Year, Months_Year)) {
//                // Click next month button until the desired month is displayed
//                do {
//                    driver.findElement(By.className("react-datepicker__navigation react-datepicker__navigation--next")).click(); // Next month button
//                } while (!driver.findElement(By.className("react-datepicker__current-month")).getText().trim().equalsIgnoreCase(Months_Year));
//            }
//            // If the desired month is in the past
//            else {
//                // Click previous month button until the desired month is displayed
//                do {
//                    driver.findElement(By.className("react-datepicker__navigation react-datepicker__navigation--previous")).click(); // Previous month button
//                } while (!driver.findElement(By.className("react-datepicker__current-month")).getText().trim().equalsIgnoreCase(Months_Year));
//            }
//        }
//
//        // Wait for the date picker to settle (you can use WebDriverWait instead of Thread.sleep)
//        Thread.sleep(3000); // Can be replaced by WebDriverWait for better performance
//
//        // Select the desired date
//        String xpath = String.format("//div[contains(@aria-label, '%s')]", dateToSelect);
//        WebElement dayToSelect = driver.findElement(By.xpath(xpath));
//        dayToSelect.click();
//    }
//
//    // Method to check if the target month is in the future compared to the current month
//		public boolean isFutureDate(String currentMonthYear, String targetMonthYear) {
//			SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
//			try {
//				Date currentDate = sdf.parse(currentMonthYear);
//				Date targetDate = sdf.parse(targetMonthYear);
//				return targetDate.after(currentDate); // Return true if target date is in the future
//			} catch (ParseException e) {
//				e.printStackTrace();
//				return false;
//			}
		 // Split the input string into MonthYear and FullDate
	    String[] parts = asofDate.split(", ");
	    String Months_Year = parts[0];   // Desired month and year in "MMMM YYYY"
	    String dateToSelect = parts[1];  // Desired date to select in "MMMM DD, YYYY"

	    // Click on the date picker input field
	    WebElement eleAsofDate = driver.findElement(datep_AsofDate);
	    eleAsofDate.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Get the current month and year from the date picker
	    String CurrentMonth_Year = driver.findElement(By.className("react-datepicker__current-month")).getText().trim();

	    // Navigate to the correct month
	    while (!CurrentMonth_Year.equalsIgnoreCase(Months_Year)) {
	        if (isFutureDate(CurrentMonth_Year, Months_Year)) {
	            driver.findElement(By.className("react-datepicker__navigation--next")).click(); // Next month button
	        } else {
	            driver.findElement(By.className("react-datepicker__navigation--previous")).click(); // Previous month button
	        }
	        Thread.sleep(500); // Allow time for transition
	        CurrentMonth_Year = driver.findElement(By.className("react-datepicker__current-month")).getText().trim();
	    }

	    // Wait for the correct month to be displayed
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("react-datepicker__current-month"), Months_Year));

	    // Select the desired date
	    String xpath = String.format("//div[contains(@aria-label, '%s')]", dateToSelect);
	    WebElement dayToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	    dayToSelect.click();
	}

	// Method to check if the target month is in the future compared to the current month
	public boolean isFutureDate(String currentMonthYear, String targetMonthYear) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
	    try {
	        Date currentDate = sdf.parse(currentMonthYear);
	        Date targetDate = sdf.parse(targetMonthYear);
	        return targetDate.after(currentDate); // Return true if target date is in the future
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return false;
	    }
		}
    
    public void SKU (String sku) {
		driver.findElement(inptxt_SKU).sendKeys(sku);
		}
    
    
    public void HSNcode (String hsnCode) throws InterruptedException {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement hsnDropdown = driver.findElement(dd_HSNcode);
	    scrollToElement(hsnDropdown);

	    // Click on the dropdown input field
	    hsnDropdown.click();
	    
	    // Type the product unit into the input field
	    hsnDropdown.sendKeys(hsnCode);
	    
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select__menu-list > div.select__option")));

	   //Thread.sleep(5000);
//	    
//	    driver.findElement(By.xpath("//*[@id=\"react-select-5-listbox\"]")).click();
//	    Thread.sleep(3000);
	   
//
//	    // Wait for the dropdown options to be visible
//	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-5-listbox")));
//	    // Capture all the options in the dropdown
	    List<WebElement> hsnOptions = driver.findElements(By.cssSelector(".select__menu-list > div.select__option"));
//
//	    WebElement bestMatch = null;
//	    
//	    
	    for (WebElement option :hsnOptions) {
//	    	String optionText = option.getText().trim();
	    	 if (option.getText().toLowerCase().contains(hsnCode.toLowerCase())) {
	    		 //Thread.sleep(5000);
	    		 wait.until(ExpectedConditions.elementToBeClickable(option));
	    		 option.click();
	        }
	    }
//	    
//	 // Click the best match if found
//	    if (bestMatch != null) {
//	    	
//	        bestMatch.sendKeys(Keys.ENTER);
//	    }
	}
    
    public void ProductCategory (String productCategory) throws InterruptedException {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement productCategoryDropdown = driver.findElement(dd_ProductCategory);
	    scrollToElement(productCategoryDropdown);

	    // Click on the dropdown input field
	    productCategoryDropdown.click();
	    
	    // Type the product unit into the input field
	    productCategoryDropdown.sendKeys(productCategory);

	    // Wait for the dropdown options to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'option')]")));
	    // Capture all the options in the dropdown
	    List<WebElement> productCategoryOptions = driver.findElements(By.xpath("//div[contains(@class, 'option')]"));

	    // Iterate through the options to find a match
	    for (WebElement option :productCategoryOptions) {
	    	 if (option.getText().trim().equalsIgnoreCase(productCategory)) {
	             option.click(); // Select the matched option
	             break;
	        }
	    }
	}
    
    public void ProducIncomeAccount (String incomeAccount) throws InterruptedException {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement incomeAccountDropdown = driver.findElement(dd_ProducIncomeAccount);
	    scrollToElement(incomeAccountDropdown);

	    // Click on the dropdown input field
	    incomeAccountDropdown.click();
	    
	    // Type the product unit into the input field
	    incomeAccountDropdown.sendKeys(incomeAccount);

	    // Wait for the dropdown options to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'option')]")));
	    // Capture all the options in the dropdown
	    List<WebElement> incomeAccountOptions = driver.findElements(By.xpath("//div[contains(@class, 'option')]"));

	    WebElement bestMatch = null;
	    
	    for (WebElement option : incomeAccountOptions) {
	        String optionText = option.getText().trim();
	        
	        // Check if the option contains the desired text
	        if (optionText.toLowerCase().contains(incomeAccount.toLowerCase())) {
	            bestMatch = option; // Store the best match
	            break;
	        }
	    }

	    // Click the best match if found
	    if (bestMatch != null) {
	        bestMatch.click();
	     
	    }
	    
    }
    
    public void SalePrice(String salePrice) {
    	WebElement eleSalePrice = driver.findElement(inpnum_SalePrice);
    	scrollToElement(eleSalePrice);
    	eleSalePrice.sendKeys(salePrice);
		}
    
    public void ProductExpenseAccount (String expenseAccoun) throws InterruptedException {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement expenseAccounDropdown = driver.findElement(dd_ProductExpenseAccount);
	    scrollToElement(expenseAccounDropdown);

	    // Click on the dropdown input field
	    expenseAccounDropdown.click();
	    
	    // Type the product unit into the input field
	    expenseAccounDropdown.sendKeys(expenseAccoun);

	    // Wait for the dropdown options to be visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'option')]")));
	    // Capture all the options in the dropdown
	    List<WebElement> expenseAccounOptions = driver.findElements(By.xpath("//div[contains(@class, 'option')]"));

	    WebElement bestMatch = null;
	    
	    for (WebElement option : expenseAccounOptions) {
	        String optionText = option.getText().trim();
	        
	        // Check if the option contains the desired text
	        if (optionText.toLowerCase().contains(expenseAccoun.toLowerCase())) {
	            bestMatch = option; // Store the best match
	            break;
	        }
	    }

	    // Click the best match if found
	    if (bestMatch != null) {
	        bestMatch.click();
	     
	    }
	    
    }    
    public void CostPrice(String costPrice) {
    	WebElement eleCostPrice = driver.findElement(inpnum_CostPrice);
    	scrollToElement(eleCostPrice);
    	eleCostPrice.sendKeys(costPrice);
		}
    
    public void ProductDescription(String description) {
    	WebElement eleProductDescription= driver.findElement(inptext_ProductDescription);
    	scrollToElement(eleProductDescription);
    	eleProductDescription.sendKeys(description);
		}
    
    public void ProductAttachments (String attachments) {
    	WebElement uploadElement = driver.findElement(attachment_ProductAttachments);
    	scrollToElement(uploadElement);
    	String filePath =  attachments; // Use the full absolute path to the file
    	uploadElement.sendKeys(filePath);
    	
		}
    
    public void ProductCancel() {
    	WebElement eleProductCancel = driver.findElement(btn_ProductCancel);
    	scrollToElement(eleProductCancel);
    	eleProductCancel.click();
		}
    
    public void ProductClear() {
    	WebElement eleProductClear = driver.findElement(btn_ProductClear);
    	scrollToElement(eleProductClear);
    	eleProductClear.click();
		}
    
    public void ProductSaveandClose() {
    	WebElement eleProductSaveandClose = driver.findElement(btn_ProductSaveandClose);
    	scrollToElement(eleProductSaveandClose);
    	eleProductSaveandClose.click();
		}
    public void ProductSaveandNew() {
    	WebElement eleProductSaveandNew = driver.findElement(btn_ProductSaveandNew);
    	eleProductSaveandNew.click();
		}
    
    
}
	
	
	


