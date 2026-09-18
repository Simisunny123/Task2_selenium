package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithInvalidEmail() {

        LoginPage login = new LoginPage(driver);

        login.enterEmail("wrongemail@gmail.com");
        login.enterPassword("Simi@12345");
        login.clickLogin();

        Assert.assertFalse(
                driver.getCurrentUrl().contains("/dashboard"),
                "Login should fail with invalid email"
        );
    }

    @Test
    public void loginWithValidCredentials() {

        LoginPage login = new LoginPage(driver);

        login.login(
                "simisunny97@gmail.com",
                "Simi@12345"
        );

        WaitUtils wait = new WaitUtils(driver);

        wait.waitForUrl("/dashboard");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/dashboard"),
                "Login should succeed with valid credentials"
        );
    }
}