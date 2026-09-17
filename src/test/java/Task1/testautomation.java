package Task1;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testautomation {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void searchAppleIphone16Plus() {

        // Open Flipkart
    	driver.get("https://www.flipkart.com/");

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	try {
    	    WebElement close = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//span[@role='button' and text()='✕']")));

    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);

    	    System.out.println("Popup closed");
    	} catch (Exception e) {
    	    System.out.println("Popup not displayed");
    	}

        // Search for the product
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("q")));

        searchBox.sendKeys("Apple iPhone 16 Plus (Black, 128 GB)");

        // Wait for suggestion and click it
        WebElement suggestion = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'apple iphone 16 plus')]")));

        suggestion.click();

        // Verify search page
        wait.until(ExpectedConditions.urlContains("search"));
        Assert.assertTrue(driver.getCurrentUrl().contains("search"));

        // Store current window
        String parentWindow = driver.getWindowHandle();

        // Open product
//        WebElement product = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("//div[contains(text(),'Apple iPhone 16 Plus')]/ancestor::a")));
//
//        product.click();
//
//        // Switch to new tab
//        Set<String> windows = driver.getWindowHandles();
//
//        for (String window : windows) {
//            if (!window.equals(parentWindow)) {
//                driver.switchTo().window(window);
//                break;
//            }
//        }
        WebElement product = driver.findElement(
        	    By.xpath("//div[contains(text(),'Apple iPhone 16 Plus')]")
        	);

        	((JavascriptExecutor)driver).executeScript(
        	    "arguments[0].removeAttribute('target');",
        	    product);

        	product.click();
        	WebElement compare = wait.until(
        		    ExpectedConditions.elementToBeClickable(
        		        By.xpath("//div[contains(text(),'Apple iPhone 16 Plus (Black, 128 GB)')]"
        		                + "/ancestor::div[@data-id]"
        		                + "//label[@class='BMOCJ3']")
        		    )
        		);

        		compare.click();
//        wait.until(ExpectedConditions.titleContains("Apple iPhone 16 Plus"));
//        Assert.assertTrue(driver.getTitle().contains("Apple iPhone 16 Plus"));
//
//        System.out.println("Product Page Title:");
//        System.out.println(driver.getTitle());

//        // Verify Add to Compare label
//        WebElement compare = wait.until(ExpectedConditions.elementToBeClickable(
//        	    By.xpath("(//input[@type='checkbox'])[2]")
//        	));
//
//        	compare.click();

        System.out.println("Add to Compare found.");
        System.out.println("Successfully clicked Add to Compare.");
        System.out.println("TEST SUCCESSFULLY COMPLETED");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}