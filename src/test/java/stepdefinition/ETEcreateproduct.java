package stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import hooks.hookstepfile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.createProductPage;

public class ETEcreateproduct {
    private hookstepfile hooks;
    private createProductPage createProductPage;

 
    public ETEcreateproduct(hookstepfile hooks) {
        this.hooks = hooks;
        this.createProductPage = hooks.getCreateProductPage();
    }
    
    @Given("I am on create product and service page")
    public void i_am_on_create_product_and_service_page() throws InterruptedException {
        createProductPage.submodSales();
        createProductPage.submodProductService();
        Thread.sleep(6000);
        createProductPage.newProductService();
        Thread.sleep(3000);
    }

    @Then("I have entered all details of product")
    public void i_have_entered_all_details_of_product() throws InterruptedException {
        List<Map<String, String>> testData = hooks.getTestData(); // Access test data
        Map<String, String> productData = testData.get(0); // Use the first row of test data
        
        
        createProductPage.PrdudctServiceName(productData.get("PrdudctServiceName"));
        Thread.sleep(2000);
        createProductPage.ProductUnit(productData.get("ProductUnit"));
        Thread.sleep(2000);
        createProductPage.ProductType(productData.get("ProductType"));
        Thread.sleep(2000);
        createProductPage.InventoryAccount(productData.get("InventoryAccount"));
        Thread.sleep(2000);
        createProductPage.Quantityonhand(productData.get("Quantityonhand"));
        Thread.sleep(2000);
        createProductPage.AsofDate(productData.get("AsofDate"));
        Thread.sleep(2000);
        createProductPage.SKU(productData.get("SKU"));
        Thread.sleep(2000);
        createProductPage.HSNcode(productData.get("HSNcode"));
        Thread.sleep(2000);
//        createProductPage.ProductCategory(productData.get("ProductCategory"));
//        Thread.sleep(2000);
        createProductPage.ProducIncomeAccount(productData.get("ProducIncomeAccount"));
        Thread.sleep(2000);
        createProductPage.SalePrice(productData.get("SalePrice"));
        Thread.sleep(2000);
        createProductPage.ProductExpenseAccount(productData.get("ProductExpenseAccount"));
        Thread.sleep(2000);
        createProductPage.CostPrice(productData.get("CostPrice"));
        Thread.sleep(2000);
        createProductPage.ProductDescription(productData.get("ProductDescription"));
        Thread.sleep(2000);
//        createProductPage.ProductAttachments(productData.get("ProductAttachments"));
//        Thread.sleep(2000);
    }

    @And("I click on Save and Close")
    public void i_click_on_save_and_close() {
        createProductPage.ProductSaveandClose();
    }
}