package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class OrderConfirmationPage {

    private WebDriver driver;
    private WaitUtils wait;
    private WebDriverWait webDriverWait;

    private By downloadButton =
            By.xpath("//button[contains(.,'Download Order Details in CSV')]");

    public OrderConfirmationPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitForOrderConfirmation() {
        wait.waitForUrl("/dashboard/thanks");
    }

    public boolean isOrderConfirmed() {

        try {
            wait.waitForUrl("/dashboard/thanks");
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDownloadButtonDisplayed() {

        return webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(downloadButton))
                .isDisplayed();
    }

    public void downloadOrderDetails() {

        // Wait until the download button is present
        WebElement downloadButtonElement = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(downloadButton)
        );

        // Scroll to the button
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                downloadButtonElement
        );

        try {

            // Wait until clickable and perform normal click
            webDriverWait.until(
                    ExpectedConditions.elementToBeClickable(downloadButtonElement)
            ).click();

        } catch (ElementClickInterceptedException e) {

            // Fallback JavaScript click
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    downloadButtonElement
            );
        }
    }

    public void goToHome() {
        // Add home functionality here if required
    }
}