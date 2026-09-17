package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class OrderConfirmationPage {

    private WaitUtils wait;

    private By downloadButton =
            By.xpath("//button[contains(.,'Download Order Details in CSV')]");

    private By homeButton =
            By.xpath("//button[@class='btn btn-custom']");

    public OrderConfirmationPage(WebDriver driver) {
        wait = new WaitUtils(driver);
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
        return wait.waitForElement(downloadButton)
                .isDisplayed();
    }

    public void downloadOrderDetails() {
        wait.waitForClickable(downloadButton)
                .click();
    }

    public void goToHome() {
        wait.waitForClickable(homeButton)
                .click();

        wait.waitForUrl("/dashboard");
    }
}