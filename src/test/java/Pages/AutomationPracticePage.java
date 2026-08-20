package Pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticePage {

    private WebDriver driver;
    

    // =========================
    // Locators
    // =========================

    // Radio Buttons
    private By radio1 = By.xpath("//input[@value='radio1']");
    private By radio2 = By.xpath("//input[@value='radio2']");
    private By radio3 = By.xpath("//input[@value='radio3']");

    // Dropdown
    private By dropdown = By.id("dropdown-class-example");

    // Checkboxes
    private By checkbox1 = By.id("checkBoxOption1");
    private By checkbox2 = By.id("checkBoxOption2");
    private By checkbox3 = By.id("checkBoxOption3");

    // Windows / Tabs
    private By openWindowButton = By.id("openwindow");
    private By openTabButton = By.id("opentab");

    // Alerts
    private By alertName = By.xpath("//input[@name='enter-name']");
    private By alertButton = By.id("alertbtn");
    private By confirmName = By.xpath("//input[@id='name']");
    private By confirmButton = By.id("confirmbtn");

    // Mouse Hover
    private By mouseHover = By.id("mousehover");
    private By topOption = By.xpath("//a[text()='Top']");
    private By reloadOption = By.xpath("//a[text()='Reload']");

    // iFrame
    private By practiceButton =
            By.xpath("//a[normalize-space()='Practice']");

    private By practiceHeading =
            By.xpath("//h2[normalize-space()='Join now to Practice']");


    // =========================
    // Constructor
    // =========================

    public AutomationPracticePage(WebDriver driver) {
        this.driver = driver;
    }


    // =========================
    // Radio Button Methods
    // =========================

    public void selectRadio1() {
        driver.findElement(radio1).click();
    }

    public boolean isRadio1Selected() {
        return driver.findElement(radio1).isSelected();
    }

    public boolean isRadio2Selected() {
        return driver.findElement(radio2).isSelected();
    }

    public boolean isRadio3Selected() {
        return driver.findElement(radio3).isSelected();
    }


    // =========================
    // Dropdown Methods
    // =========================

    public void selectDropdownOption(String option) {

        WebElement dropdownElement =
                driver.findElement(dropdown);

        Select select = new Select(dropdownElement);

        select.selectByVisibleText(option);
    }

    public String getSelectedDropdownOption() {

        WebElement dropdownElement =
                driver.findElement(dropdown);

        Select select = new Select(dropdownElement);

        return select.getFirstSelectedOption().getText();
    }


    // =========================
    // Checkbox Methods
    // =========================

    public void selectCheckbox1() {
        driver.findElement(checkbox1).click();
    }

    public void selectCheckbox2() {
        driver.findElement(checkbox2).click();
    }

    public void selectCheckbox3() {
        driver.findElement(checkbox3).click();
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }

    public boolean isCheckbox3Selected() {
        return driver.findElement(checkbox3).isSelected();
    }


    // =========================
    // Switch Window
    // =========================

    public void switchToNewWindowAndClose() throws InterruptedException {

        String parentWindow = driver.getWindowHandle();

        driver.findElement(openWindowButton).click();

        Thread.sleep(3000);

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {

            if (!windowHandle.equals(parentWindow)) {

                driver.switchTo().window(windowHandle);

                Thread.sleep(3000);

                driver.close();

                driver.switchTo().window(parentWindow);

                break;
            }
        }
    }


    // =========================
    // Switch Tab
    // =========================

    public String switchToNewTabAndGetTitle() throws InterruptedException {

        String parentWindow = driver.getWindowHandle();

        driver.findElement(openTabButton).click();

        Thread.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();

        String tabTitle = "";

        for (String windowHandle : allWindows) {

            if (!windowHandle.equals(parentWindow)) {

                driver.switchTo().window(windowHandle);

                System.out.println("Switched to new tab");

                tabTitle = driver.getTitle();

                System.out.println("Title: " + tabTitle);
                System.out.println("URL: " + driver.getCurrentUrl());

                driver.switchTo().window(parentWindow);

                break;
            }
        }

        return tabTitle;
    }


    // =========================
    // Alert Handling
    // =========================

    public void enterAlertName(String name) {

        driver.findElement(alertName).sendKeys(name);
    }

    public void clickAlertButton() {

        driver.findElement(alertButton).click();
    }

    public void acceptAlert() {

        Alert alert = driver.switchTo().alert();

        alert.accept();
    }

    public void enterConfirmName(String name) {

        driver.findElement(confirmName).sendKeys(name);
    }

    public void clickConfirmButton() {

        driver.findElement(confirmButton).click();
    }

    public void acceptConfirmAlert() {

        Alert alert = driver.switchTo().alert();

        alert.accept();
    }


    // =========================
    // Mouse Hover
    // =========================

    public void hoverOverMouseHover() throws InterruptedException {

        WebElement mouseHoverElement =
                driver.findElement(mouseHover);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                mouseHoverElement
        );

        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        actions.moveToElement(mouseHoverElement).perform();

        Thread.sleep(2000);
    }

    public boolean isTopDisplayed() {

        return driver.findElement(topOption).isDisplayed();
    }

    public void clickTop() {

        driver.findElement(topOption).click();
    }

    public void hoverAgain() throws InterruptedException {

        WebElement mouseHoverElement =
                driver.findElement(mouseHover);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                mouseHoverElement
        );

        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        actions.moveToElement(mouseHoverElement).perform();

        Thread.sleep(2000);
    }

    public boolean isReloadDisplayed() {

        return driver.findElement(reloadOption).isDisplayed();
    }

    public void clickReload() {

        driver.findElement(reloadOption).click();
    }


    // =========================
    // iFrame
    // =========================

    public void switchToCoursesIframe() throws InterruptedException {

        driver.switchTo().frame("courses-iframe");

        Thread.sleep(3000);
    }

    public void clickPractice() throws InterruptedException {

        driver.findElement(practiceButton).click();

        Thread.sleep(5000);
    }

    public String getPracticeHeading() {

        return driver.findElement(practiceHeading).getText();
    }

    public void switchToMainPage() {

        driver.switchTo().defaultContent();
    }
}