package pages;

import java.time.Duration;
//import java.util.List;

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

        // Wait for spinner to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));

        // Wait until buttons are present
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addToCartButtons));

        // Get buttons
        java.util.List<WebElement> buttons =
                driver.findElements(addToCartButtons);

        if (index >= buttons.size()) {
            throw new RuntimeException(
                    "Invalid product index: " + index +
                    ". Available buttons: " + buttons.size()
            );
        }

        WebElement button = buttons.get(index);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        button
                );

        // Wait for spinner again
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));

        // Wait until the exact button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(button));

        // Click
        button.click();

        // Wait for post-click loading to finish
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
    
    }

    public void openCart() {

        // Wait for spinner to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));

        // Wait until Cart button is clickable
        WebElement cart = wait.until(
                ExpectedConditions.elementToBeClickable(cartButton)
        );

        // Scroll Cart button into view
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        cart
                );

        // Wait for spinner again
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));

        // Click Cart
        cart.click();

        // Wait until Cart page is loaded
        wait.until(ExpectedConditions.urlContains("/dashboard/cart"));
    }
		
	}
