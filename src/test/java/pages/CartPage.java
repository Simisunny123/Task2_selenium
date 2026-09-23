package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By products = By.cssSelector(".cartSection h3");

    By cartItems = By.cssSelector("ul.cartWrap li.items");

    By removeButton = By.cssSelector("button.btn-danger");

    public CartPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isProductPresent(String name) {

        List<WebElement> productsList =
                driver.findElements(products);

        for (WebElement product : productsList) {

            if (product.getText().trim()
                    .equalsIgnoreCase(name.trim())) {

                return true;
            }
        }

        return false;
    }

    public void waitForCartPage() {

        // Make sure we are on the cart page
        wait.until(ExpectedConditions.urlContains("/dashboard/cart"));

        // Wait for cart items
        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(cartItems)
        );
    }

    public String getFirstProductName() {

        waitForCartPage();

        List<WebElement> items =
                driver.findElements(cartItems);

        if (items.isEmpty()) {
            throw new RuntimeException("No products found in cart");
        }

        return items.get(0)
                .findElement(By.cssSelector("h3"))
                .getText()
                .trim();
    }

    public void removeFirstProduct() {

        waitForCartPage();

        List<WebElement> items =
                driver.findElements(cartItems);

        if (items.isEmpty()) {
            throw new RuntimeException("No products found in cart");
        }

        WebElement firstItem = items.get(0);

        WebElement remove =
                firstItem.findElement(removeButton);

        wait.until(
                ExpectedConditions.elementToBeClickable(remove)
        );

        remove.click();

        // Wait until first item is removed
        wait.until(ExpectedConditions.stalenessOf(firstItem));
    }
}