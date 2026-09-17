package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By addToCartButtons = By.cssSelector("button.btn.w-10.rounded");
    By cartButton = By.cssSelector("button[routerlink='/dashboard/cart']");
    By spinner = By.cssSelector(".ngx-spinner-overlay");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Add product
    public void addProduct(int index) {

        // Wait for loading spinner to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));

        // Get all Add to Cart buttons
        List<WebElement> buttons =
                driver.findElements(addToCartButtons);

        // Click required product
        buttons.get(index).click();

        // Wait for spinner after clicking
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
    }

    // Open cart
    public void openCart() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));

        wait.until(ExpectedConditions.elementToBeClickable(cartButton))
            .click();
    }
}