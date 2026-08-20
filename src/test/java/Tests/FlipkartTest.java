package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import Pages.FlipkartPage;
import utils.ConfigReader;

public class FlipkartTest extends BaseTest {

    private FlipkartPage flipkartPage;

    // =========================
    // Initialize Page Object
    // =========================

    @BeforeMethod
    public void initializePage() {

        // BaseTest already creates the browser
        // Navigate to Flipkart URL from config file

        driver.get(
                ConfigReader.getProperty("flipkart.url")
        );

        flipkartPage = new FlipkartPage(driver);
    }

    // =========================
    // Flipkart Test
    // =========================

    @Test
    public void searchAppleIphone16Plus() {

        String productName =
                ConfigReader.getProperty("flipkart.product");

        // Close popup if displayed
        flipkartPage.closeLoginPopup();

        // Search product
        flipkartPage.searchProduct(productName);

        // Select suggestion
        flipkartPage.selectProductSuggestion();

        // Verify search page
        Assert.assertTrue(
                flipkartPage.isSearchPageDisplayed(),
                "Search page was not displayed"
        );

        System.out.println("Search page displayed successfully");

        // Open product
        flipkartPage.openProduct();

        // Click Add to Compare
        flipkartPage.clickCompare();

        System.out.println("Add to Compare found.");
        System.out.println("Successfully clicked Add to Compare.");
        System.out.println("TEST SUCCESSFULLY COMPLETED");
    }
}
