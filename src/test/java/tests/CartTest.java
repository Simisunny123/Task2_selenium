package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CartTest extends BaseTest {


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

	    // Cart
	    CartPage cart = new CartPage(driver);

	    String productName = cart.getFirstProductName();

	    System.out.println("Product before removal: " + productName);

	    cart.removeFirstProduct();

	    System.out.println("Product after removal: "
	            + cart.isProductPresent(productName));

	    Assert.assertFalse(
	            cart.isProductPresent(productName),
	            productName + " was not removed"
	    );
	}}