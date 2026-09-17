package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;

public class CheckoutTest extends BaseTest {

    CheckoutPage checkoutPage;
    OrderConfirmationPage orderConfirmationPage;

    @BeforeMethod
    public void setupTest() {

        checkoutPage = new CheckoutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @Test
    public void checkout() {

        // Login
        LoginPage login = new LoginPage(driver);

        login.login(
                "simisunny97@gmail.com",
                "Simi@12345"
        );

        // Add products
        DashboardPage dashboard = new DashboardPage(driver);

        dashboard.addProduct(0);
        dashboard.addProduct(1);
        dashboard.addProduct(2);

        dashboard.openCart();

        // Verify cart
        CartPage cart = new CartPage(driver);

        Assert.assertTrue(
                cart.isProductPresent("ADIDAS ORIGINAL"),
                "ADIDAS ORIGINAL is not present in cart"
        );

        Assert.assertTrue(
                cart.isProductPresent("ZARA COAT 3"),
                "ZARA COAT 3 is not present in cart"
        );

        Assert.assertTrue(
                cart.isProductPresent("IPHONE 13 PRO"),
                "IPHONE 13 PRO is not present in cart"
        );

        // Checkout
        checkoutPage.clickCheckout();

        checkoutPage.enterCardNumber("4542 9931 9292 2293");
        checkoutPage.selectExpiryMonth("01");
        checkoutPage.selectExpiryYear("16");
        checkoutPage.enterCVV("123");
        checkoutPage.enterNameOnCard("Simi Sunny");

        checkoutPage.enterShippingEmail("simisunny97@gmail.com");

        checkoutPage.selectCountry("India");

     // Place order
        checkoutPage.clickPlaceOrder();

     // Wait for Thank You page
     orderConfirmationPage.waitForOrderConfirmation();

     System.out.println("Thank You page URL loaded successfully.");

     Assert.assertTrue(
             orderConfirmationPage.isDownloadButtonDisplayed(),
             "Download Order Details button is not displayed"
     );

     System.out.println("Order confirmation page loaded successfully.");

     // Download CSV
     orderConfirmationPage.downloadOrderDetails();

     // Go back to Home
     orderConfirmationPage.goToHome();

     System.out.println("Current URL: " + driver.getCurrentUrl());
    }
}