package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    By products =
            By.cssSelector(".cartSection h3");

    By cartItems =
            By.cssSelector("ul.cartWrap li.items");

    By removeButton =
            By.cssSelector("button.btn-danger");


    public CartPage(WebDriver driver) {

        this.driver = driver;
    }


    public boolean isProductPresent(String name) {

        List<WebElement> productsList =
                driver.findElements(products);

        for (WebElement product : productsList) {

            if (product.getText()
                    .equalsIgnoreCase(name)) {

                return true;
            }
        }

        return false;
    }


    public void removeFirstProduct() {

        driver.findElements(cartItems)
                .get(0)
                .findElement(removeButton)
                .click();
    }


	public void waitForCartPage() {
		// TODO Auto-generated method stub
		
	}


	public String getFirstProductName() {
		// TODO Auto-generated method stub
		return null;
	}
}