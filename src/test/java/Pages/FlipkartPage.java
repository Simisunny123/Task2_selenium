package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================
    // Constructor
    // =========================

    public FlipkartPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // =========================
    // Locators
    // =========================

    // Login popup close button
    private By closePopup = By.xpath(
            "//span[@role='button' and text()='✕']"
    );

    // Search box
    private By searchBox = By.name("q");

    // Product suggestion
    private By productSuggestion = By.xpath(
            "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')," +
            "'apple iphone 16 plus')]"
    );

    // Product
    private By product = By.xpath(
            "//div[contains(text(),'Apple iPhone 16 Plus')]"
    );

    // Compare checkbox
    private By compareCheckbox = By.xpath(
            "//div[contains(text(),'Apple iPhone 16 Plus (Black, 128 GB)')]" +
            "/ancestor::div[@data-id]" +
            "//label[@class='BMOCJ3']"
    );

    // =========================
    // Popup Handling
    // =========================

    public void closeLoginPopup() {

        try {

            WebElement close = wait.until(
                    ExpectedConditions.elementToBeClickable(closePopup)
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", close);

            System.out.println("Popup closed");

        } catch (Exception e) {

            System.out.println("Popup not displayed");
        }
    }

    // =========================
    // Search Product
    // =========================

    public void searchProduct(String productName) {

        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        search.clear();
        search.sendKeys(productName);
    }

    // =========================
    // Select Search Suggestion
    // =========================

    public void selectProductSuggestion() {

        WebElement suggestion = wait.until(
                ExpectedConditions.elementToBeClickable(productSuggestion)
        );

        suggestion.click();
    }

    // =========================
    // Verify Search Page
    // =========================

    public boolean isSearchPageDisplayed() {

        return wait.until(
                ExpectedConditions.urlContains("search")
        );
    }

    // =========================
    // Open Product
    // =========================

    public void openProduct() {

        WebElement productElement = wait.until(
                ExpectedConditions.elementToBeClickable(product)
        );

        // Remove target attribute if Flipkart opens product in new tab
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('target');",
                productElement
        );

        productElement.click();
    }

    // =========================
    // Add Product to Compare
    // =========================

    public void clickCompare() {

        WebElement compare = wait.until(
                ExpectedConditions.elementToBeClickable(
                        compareCheckbox
                )
        );

        compare.click();
    }
}