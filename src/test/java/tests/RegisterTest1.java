package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegisterPage;

public class RegisterTest1 extends BaseTest {

    @Test
    public void registerNewUser() {

        RegisterPage register = new RegisterPage(driver);

        register.clickRegisterLink();

        register.enterFirstName("Simi");
        register.enterLastName("Sunny");

        register.enterEmail("simi" + System.currentTimeMillis() + "@gmail.com");

        register.enterMobile("9876543210");

        register.selectOccupation("Engineer");
        register.selectGender();

        register.enterPassword("Simi@12345");
        register.enterConfirmPassword("Simi@12345");

        register.selectAgeCheckbox();

        register.clickRegisterButton();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("auth"),
                "Registration may not have completed"
        );
    }

    @Test
    public void registerWithInvalidEmail() {

        RegisterPage register = new RegisterPage(driver);

        register.clickRegisterLink();

        register.enterFirstName("Simi");
        register.enterLastName("Sunny");

        register.enterEmail("simisunny97gmail.com");

        register.enterMobile("9876543210");

        register.selectOccupation("Engineer");
        register.selectGender();

        register.enterPassword("Simi@12345");
        register.enterConfirmPassword("Simi@12345");

        register.selectAgeCheckbox();

        register.clickRegisterButton();

        Assert.assertFalse(
                driver.getCurrentUrl().contains("/dashboard"),
                "Registration should not succeed with invalid email"
        );
    }

    @Test
    public void registerWithPasswordMismatch() {

        RegisterPage register = new RegisterPage(driver);

        register.clickRegisterLink();

        register.enterFirstName("Simi");
        register.enterLastName("Sunny");

        register.enterEmail(
                "simi" + System.currentTimeMillis() + "@gmail.com"
        );

        register.enterMobile("9876543210");

        register.selectOccupation("Engineer");
        register.selectGender();

        register.enterPassword("Simi@12345");
        register.enterConfirmPassword("Wrong@123");

        register.selectAgeCheckbox();

        register.clickRegisterButton();

        Assert.assertFalse(
                driver.getCurrentUrl().contains("/dashboard"),
                "Registration should not succeed when passwords don't match"
        );
    }
}