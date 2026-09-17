package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By email = By.id("userEmail");

    By password = By.id("userPassword");

    By loginButton = By.id("login");


    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }


    public void login(String emailValue, String passwordValue) {

        driver.findElement(email)
                .sendKeys(emailValue);

        driver.findElement(password)
                .sendKeys(passwordValue);

        driver.findElement(loginButton)
                .click();
    }


	public void enterEmail(String string) {
		// TODO Auto-generated method stub
		
	}


	public void enterPassword(String string) {
		// TODO Auto-generated method stub
		
	}


	public void clickLogin() {
		// TODO Auto-generated method stub
		
	}
}