package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    // Checkout button
    By checkoutButton = By.xpath("//button[contains(normalize-space(),'Checkout')]");

    // Payment fields
    By cardNumber = By.cssSelector("input[type='text']");
    By expiryMonth = By.xpath("//select[1]");
    By expiryYear = By.xpath("//select[2]");
    By cvv = By.xpath("//div[contains(normalize-space(),'CVV Code')]/following::input[1]");
    By nameOnCard = By.xpath(
            "//div[contains(@class,'field')][.//div[normalize-space()='Name on Card']]//input"
    );
 // Shipping Email
    By shippingEmail = By.xpath(
            "//div[contains(@class,'details__user')]//input[@type='text'][1]"
    );

    // Country
    By countryInput = By.xpath(
            "//input[@placeholder='Select Country']"
    );

    // Place Order
 // Place Order
    By placeOrderButton = By.cssSelector("a.action__submit");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCheckout() {

        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(checkoutButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                button
        );

        try {
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        } catch (Exception e) {

            // JavaScript click if normal Selenium click is blocked
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    button
            );
        }
    }
    public void enterCardNumber(String card) {
        wait.until(ExpectedConditions.elementToBeClickable(cardNumber))
                .sendKeys(card);
    }

    public void selectExpiryMonth(String month) {
        wait.until(ExpectedConditions.elementToBeClickable(expiryMonth))
                .sendKeys(month);
    }

    public void selectExpiryYear(String year) {
        wait.until(ExpectedConditions.elementToBeClickable(expiryYear))
                .sendKeys(year);
    }

    public void enterCVV(String cvvNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(cvv))
                .sendKeys(cvvNumber);
    }

    public void enterNameOnCard(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameOnCard))
                .sendKeys(name);
    }

    public void enterShippingEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(shippingEmail))
                .sendKeys(email);
    }

    public void selectCountry(String country) {
        WebElement countryField = wait.until(
                ExpectedConditions.elementToBeClickable(countryInput)
        );

        countryField.sendKeys(country);

        By countryOption = By.xpath(
                "//span[normalize-space()='" + country + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(countryOption))
                .click();
    }

    public void clickPlaceOrder() {

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(placeOrderButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                button
        );

        try {
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();

        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    button
            );
    }
        
}
}