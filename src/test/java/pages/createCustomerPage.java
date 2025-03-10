package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createCustomerPage {
	WebDriver driver;
	By btn_submodSales = By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]/div[2]/div/div/div/li[3]/a");
	By btn_submodCustomer =By.xpath("//a[normalize-space()='Customers']");
	By btn_newCustomer = By.xpath("//a[normalize-space()='Create Customer']");
	By inptxt_Title = By.xpath("//input[@name='contact_infos.title']");
	By inptxt_FirstName = By.xpath("//input[@name='contact_infos.first_name']");
	By inptxt_MiddleName = By.xpath("//input[@name='contact_infos.middle_name']");
	By inptxt_LastName = By.xpath("//input[@name='contact_infos.last_name']");
	By inptxt_CompanyName = By.xpath("//input[@name='additional_infos.company_name']");
	By inptxt_DisplayName = By.xpath("//input[@name='contact_infos.display_name']");
	By inptxt_Email = By.xpath("//input[@label='Email']");
	By dd_PhoneNumCountry = By.xpath("//select[@name='phone_numberCountry']");
	By inpnum_PhoneNumber = By.xpath("//input[@placeholder='Enter phone number']");
	By inpnum_MobileNumber = By.xpath("//input[@label='Mobile Number']");
	By inpnum_Fax = By.xpath("//input[@label='Fax']");
	By inp_Other = By.xpath("//input[@label='Other']");
	By inp_Website = By.xpath("//input[@label='Website']");
	By inptxt_NameToPrintOnChecks = By.xpath("//input[@name='contact_infos.name_on_checks']");
	By dd_GSTTreatment = By.xpath("//select[@label='GST treatment']");
	//Billing Address
	By btn_Billing_EnterManually = By.xpath("//body//div[@id='root']//div[contains(@class,'body flex-grow-1 px-3 mb-5')]//div[contains(@class,'row')]//div[contains(@class,'row')]//div[contains(@class,'row')]//div[1]//div[1]//div[1]//div[1]//button[1]");
	By inp_Billing = By.xpath("//body/div[@id='root']/div/div[contains(@class,'wrapper d-flex flex-column min-vh-100')]/div[contains(@class,'body flex-grow-1 px-3 mb-5')]/div[contains(@class,'container-fluid')]/form[contains(@class,'pb-5')]/div[contains(@class,'row')]/div[contains(@class,'row')]/div[contains(@class,'col-md-12 pb-5')]/div[contains(@class,'card sc-iGgWBj djagpQ shadow-none mb-3')]/div[contains(@class,'card-body')]/div[contains(@class,'row')]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	By dd_BillingCountry = By.xpath("//body//div[@id='root']//div[contains(@class,'body flex-grow-1 px-3 mb-5')]//div[contains(@class,'row')]//div[contains(@class,'row')]//div[contains(@class,'row')]//div[1]//div[1]//div[2]//div[1]//div[1]//select[1]");
	By dd_BillingState = By.xpath("//body/div[@id='root']/div/div[contains(@class,'wrapper d-flex flex-column min-vh-100')]/div[contains(@class,'body flex-grow-1 px-3 mb-5')]/div[contains(@class,'container-fluid')]/form[contains(@class,'pb-5')]/div[contains(@class,'row')]/div[contains(@class,'row')]/div[contains(@class,'col-md-12 pb-5')]/div[contains(@class,'card sc-iGgWBj djagpQ shadow-none mb-3')]/div[contains(@class,'card-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-6')]/div[contains(@class,'row')]/div[1]/div[1]/div[1]/select[1]");
	By inp_BillingCity = By.xpath("//body/div[@id='root']/div/div[contains(@class,'wrapper d-flex flex-column min-vh-100')]/div[contains(@class,'body flex-grow-1 px-3 mb-5')]/div[contains(@class,'container-fluid')]/form[contains(@class,'pb-5')]/div[contains(@class,'row')]/div[contains(@class,'row')]/div[contains(@class,'col-md-12 pb-5')]/div[contains(@class,'card sc-iGgWBj djagpQ shadow-none mb-3')]/div[contains(@class,'card-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-6')]/div[contains(@class,'row')]/div[2]/div[1]/div[1]/input[1]");
	By inp_BillingZip = By.xpath("//body/div[@id='root']/div/div[contains(@class,'wrapper d-flex flex-column min-vh-100')]/div[contains(@class,'body flex-grow-1 px-3 mb-5')]/div[contains(@class,'container-fluid')]/form[contains(@class,'pb-5')]/div[contains(@class,'row')]/div[contains(@class,'row')]/div[contains(@class,'col-md-12 pb-5')]/div[contains(@class,'card sc-iGgWBj djagpQ shadow-none mb-3')]/div[contains(@class,'card-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-6')]/div[contains(@class,'row')]/div[3]/div[1]/div[1]/input[1]");
	//Shipping Address
	By checkbx_SameasBilling = By.xpath("//input[@id='bil_checkBox']");
	By btn_Shipping_EnterManually = By.xpath("//div[@class='card-body']//div[2]//div[1]//div[1]//div[1]//button[1]");
	By inp_Shipping = By.xpath("//body/div[@id='root']/div/div[contains(@class,'wrapper d-flex flex-column min-vh-100')]/div[contains(@class,'body flex-grow-1 px-3 mb-5')]/div[contains(@class,'container-fluid')]/form[contains(@class,'pb-5')]/div[contains(@class,'row')]/div[contains(@class,'row')]/div[contains(@class,'col-md-12 pb-5')]/div[contains(@class,'card sc-iGgWBj djagpQ shadow-none mb-3')]/div[contains(@class,'card-body')]/div[contains(@class,'row')]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
	By dd_ShippingCountry = By.xpath("//div[@class='card-body']//div[2]//div[1]//div[2]//div[1]//div[1]//select[1]");
	By dd_ShippingState = By.xpath("//div[contains(@class,'col-md-6')]//div//div[contains(@class,'row')]//select[contains(@aria-label,'Large select example')]");
	By inp_ShippingCity = By.xpath("//body//div[@id='root']//div[contains(@class,'col-md-6')]//div//div[contains(@class,'row')]//div[2]//div[1]//div[1]//input[1]");
	By inp_ShippingZip = By.xpath("//body//div[@id='root']//div[contains(@class,'col-md-6')]//div//div[contains(@class,'row')]//div[3]//div[1]//div[1]//input[1]");
	//Note
	By inp_Note = By.xpath("//textarea[contains(@aria-label,'With textarea')]");
	//Additional Information
	By dd_CustomerType = By.xpath("//div[@class=' css-cofman-control']//div[@class=' css-19bb58m']");
	By dd_Preferreddeliverymethod = By.xpath("//div[contains(@class,'css-cofman-control')]//div[contains(@class,'css-19bb58m')]"); 
	By dd_PreferredPaymentMethod = By.xpath("//div[contains(@class,'css-cofman-control')]//div[contains(@class,'css-19bb58m')]");
	By dd_CreditTerms = By.xpath("//div[contains(@class,'css-cofman-control')]//div[contains(@class,'css-19bb58m')]");
	By btn_Cancel = By.xpath("//a[contains(@class,'sc-eeDRCY eMmKiS text-white')]");
	By btn_Clear = By.xpath("//div[@class='expense-footer-btns']//div[1]//button[2]");
	By btn_SaveandClose = By.xpath("//button[@id='zoom-primary-cancel-btn']");
	By btn_SaveandNew = By.xpath("//button[@id='zoom-primary-btn']");
	
	public createCustomerPage(WebDriver driver) {
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
		WebElement elesubmodCustomer = driver.findElement(btn_submodCustomer);
		scrollToElement(elesubmodCustomer);
		elesubmodCustomer.click();
		}
	
	public void newProductService() {
		WebElement elenewCustomer = driver.findElement(btn_newCustomer);
		scrollToElement(elenewCustomer);
		elenewCustomer.click();
		}
	
	public void Title (String title) {
		WebElement eleTitle = driver.findElement(inptxt_Title);
		scrollToElement(eleTitle);
		eleTitle.sendKeys(title);
		}
	
	public void FirstName (String firstname) {
		WebElement eleFirstName = driver.findElement(inptxt_FirstName);
		scrollToElement(eleFirstName);
		eleFirstName.sendKeys(firstname);
		}
	
	public void MiddleName (String middlename) {
		WebElement eleMiddleName = driver.findElement(inptxt_MiddleName);
		scrollToElement(eleMiddleName);
		eleMiddleName.sendKeys(middlename);
		}
	
	public void LastName (String lastname) {
		WebElement eleLastName = driver.findElement(inptxt_LastName);
		scrollToElement(eleLastName);
		eleLastName.sendKeys(lastname);
		}
	
	public void CompanyName (String companyname) {
		WebElement eleCompanyName = driver.findElement(inptxt_CompanyName);
		scrollToElement(eleCompanyName);
		eleCompanyName.sendKeys(companyname);
		}
	
	public void DisplayName (String displayname) {
		WebElement eleDisplayName = driver.findElement(inptxt_DisplayName);
		scrollToElement(eleDisplayName);
		eleDisplayName.sendKeys(displayname);
		}
	
	public void Email (String email) {
		WebElement eleEmail = driver.findElement(inptxt_Email);
		scrollToElement(eleEmail);
		eleEmail.sendKeys(email);
		}
	
	public void PhoneNumCountry(String phonenumcountry) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement phonenumcountrydropdown = driver.findElement(dd_PhoneNumCountry);
		phonenumcountrydropdown.click();
		phonenumcountrydropdown.sendKeys(phonenumcountry);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div/div[2]/div[8]/div/div/select")));
	    List<WebElement> phonenumbercountryOptions = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div/div[2]/div[8]/div/div/select"));

	    for (WebElement option :phonenumbercountryOptions) {
//	    	String optionText = option.getText().trim();
	    	 if (option.getText().toLowerCase().contains(phonenumcountry.toLowerCase())) {
	    		 //Thread.sleep(5000);
	    		 wait.until(ExpectedConditions.elementToBeClickable(option));
	    		 option.click();
	        }
	    }
	}
	
	public void PhoneNumber (String phonenumber) {
		WebElement elePhoneNumber = driver.findElement(inpnum_PhoneNumber);
		scrollToElement(elePhoneNumber);
		elePhoneNumber.sendKeys(phonenumber);
	}
	
	public void MobileNumber (String mobilenumber) {
		WebElement eleMobileNumber = driver.findElement(inpnum_MobileNumber);
		scrollToElement(eleMobileNumber);
		eleMobileNumber.sendKeys(mobilenumber);
	}
	
	public void Fax (String fax) {
		WebElement eleFax = driver.findElement(inpnum_Fax);
		scrollToElement(eleFax);
		eleFax.sendKeys(fax);
	}
	
	public void Other (String other) {
		WebElement eleOther = driver.findElement(inp_Other);
		scrollToElement(eleOther);
		eleOther.sendKeys(other);
	}
	
	public void Website (String website) {
		WebElement eleWebsite = driver.findElement(inp_Website);
		scrollToElement(eleWebsite);
		eleWebsite.sendKeys(website);
	}
	
	public void NameToPrintOnChecks (String nametoprintonchecks) {
		WebElement eleNameToPrintOnChecks = driver.findElement(inptxt_NameToPrintOnChecks);
		scrollToElement(eleNameToPrintOnChecks);
		eleNameToPrintOnChecks.sendKeys(nametoprintonchecks);
	}
	
	public void GSTTreatment(String gsttreatment) throws InterruptedException {
		WebElement eleGSTTreatment = driver.findElement(dd_GSTTreatment);
		scrollToElement(eleGSTTreatment);
		eleGSTTreatment.click();
//		eleGSTTreatment.
	     
	}
	
	public void BillingEnterManually() {
		WebElement eleBillingEnterManually = driver.findElement(btn_Billing_EnterManually);
		scrollToElement(eleBillingEnterManually);
		eleBillingEnterManually.click();
		}
	
	public void Billing (String billing) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement billingDropdown = driver.findElement(inp_Billing);
	    scrollToElement(billingDropdown);
	    billingDropdown.click();
	    billingDropdown.sendKeys(billing);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]")));
	    List<WebElement> billingOptions = driver.findElements(By.xpath("/html/body/div[2]"));
	    WebElement bestMatch = null;

	    for (WebElement option : billingOptions) {
	        String optionText = option.getText().trim();
	        
	        // Check if the option contains the desired text
	        if (optionText.toLowerCase().contains(billing.toLowerCase())) {
	            bestMatch = option; // Store the best match
	            break;
	        }
	    }

	    // Click the best match if found
	    if (bestMatch != null) {
	        bestMatch.click();
	     
	    }
	    
	}
	
	public void BillingCountry (String billingcountry) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement billingcountryDropdown = driver.findElement(dd_BillingCountry);
	    scrollToElement(billingcountryDropdown);
	    billingcountryDropdown.click();
	    billingcountryDropdown.sendKeys(billingcountry);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]")));
	    List<WebElement> billingcountryOptions = driver.findElements(By.xpath("/html/body/div[2]"));
	    WebElement bestMatch = null;

	}
}
