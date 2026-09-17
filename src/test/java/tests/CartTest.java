package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addThreeProductsToCart() {

        // Login
        LoginPage login = new LoginPage(driver);

        login.login(
                "simisunny97@gmail.com",
                "Simi@12345"
        );

        // Dashboard
        DashboardPage dashboard = new DashboardPage(driver);

        dashboard.addProduct(0);
        dashboard.addProduct(1);
        dashboard.addProduct(2);

        dashboard.openCart();

        // Cart
        CartPage cart = new CartPage(driver);

        Assert.assertTrue(
                cart.isProductPresent("ADIDAS ORIGINAL"),
                "Adidas Original is not present"
        );

        Assert.assertTrue(
                cart.isProductPresent("ZARA COAT 3"),
                "Zara Coat 3 is not present"
        );

        Assert.assertTrue(
                cart.isProductPresent("IPHONE 13 PRO"),
                "iPhone 13 Pro is not present"
        );
    }


    @Test
    public void removeProductFromCart() {

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

        // Remove first product
        CartPage cart = new CartPage(driver);

        String productName = cart.getFirstProductName();

        cart.removeFirstProduct();

        Assert.assertFalse(
                cart.isProductPresent(productName),
                productName + " was not removed"
        );
    }
}