package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }


    public WebElement waitForElement(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }


    public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }


    public void waitForUrl(String url) {

        wait.until(
                ExpectedConditions.urlContains(url)
        );
    }


    public void waitForInvisibility(By locator) {

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }


	public WebElement until(ExpectedCondition<WebElement> elementToBeClickable) {
		// TODO Auto-generated method stub
		return null;
	}
}