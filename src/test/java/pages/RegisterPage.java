package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

public class RegisterPage {

    private WaitUtils wait;

    private By registerLink =
            By.linkText("Register");

    private By firstName =
            By.id("firstName");

    private By lastName =
            By.id("lastName");

    private By email =
            By.id("userEmail");

    private By mobile =
            By.id("userMobile");

    private By occupation =
            By.cssSelector(
                    "select[formcontrolname='occupation']"
            );

    private By male =
            By.cssSelector("input[value='Male']");

    private By password =
            By.id("userPassword");

    private By confirmPassword =
            By.id("confirmPassword");

    private By ageCheckbox =
            By.cssSelector("input[type='checkbox']");

    private By registerButton =
            By.cssSelector("input[value='Register']");


    public RegisterPage(WebDriver driver) {

        wait = new WaitUtils(driver);
    }


    public void clickRegisterLink() {

        wait.waitForClickable(registerLink).click();
    }


    public void enterFirstName(String value) {

        wait.waitForElement(firstName)
                .sendKeys(value);
    }


    public void enterLastName(String value) {

        wait.waitForElement(lastName)
                .sendKeys(value);
    }


    public void enterEmail(String value) {

        wait.waitForElement(email)
                .sendKeys(value);
    }


    public void enterMobile(String value) {

        wait.waitForElement(mobile)
                .sendKeys(value);
    }


    public void selectOccupation(String value) {

        Select select =
                new Select(
                        wait.waitForElement(occupation)
                );

        select.selectByVisibleText(value);
    }


    public void selectGender() {

        wait.waitForClickable(male).click();
    }


    public void enterPassword(String value) {

        wait.waitForElement(password)
                .sendKeys(value);
    }


    public void enterConfirmPassword(String value) {

        wait.waitForElement(confirmPassword)
                .sendKeys(value);
    }


    public void selectAgeCheckbox() {

        wait.waitForClickable(ageCheckbox).click();
    }


    public void clickRegisterButton() {

        wait.waitForClickable(registerButton).click();
    }


    public void registerUser(
            String firstNameValue,
            String lastNameValue,
            String emailValue,
            String mobileValue,
            String occupationValue,
            String passwordValue,
            String confirmPasswordValue) {

        enterFirstName(firstNameValue);

        enterLastName(lastNameValue);

        enterEmail(emailValue);

        enterMobile(mobileValue);

        selectOccupation(occupationValue);

        selectGender();

        enterPassword(passwordValue);

        enterConfirmPassword(confirmPasswordValue);

        selectAgeCheckbox();

        clickRegisterButton();
    }
}