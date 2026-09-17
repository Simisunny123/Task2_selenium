package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import Pages.AutomationPracticePage;
import utils.ConfigReader;

public class AutomationPracticeTest extends BaseTest {

    private AutomationPracticePage automationPage;

    @BeforeMethod
    public void initializePage() {
    	 automationPage = new AutomationPracticePage(driver);
        driver.get(
            ConfigReader.getProperty("automation.url")
        );
    }

    // =========================
    // Test 1 - Radio Button
    // =========================

    @Test(priority = 1)
    public void radioButtonTest() {

        automationPage.selectRadio1();

        Assert.assertTrue(
                automationPage.isRadio1Selected()
        );

        Assert.assertFalse(
                automationPage.isRadio2Selected()
        );

        Assert.assertFalse(
                automationPage.isRadio3Selected()
        );
    }


    // =========================
    // Test 2 - Dropdown
    // =========================

    @Test(priority = 2)
    public void selectOption1() {

        String option =
                ConfigReader.getProperty("dropdown.option");

        automationPage.selectDropdownOption(option);

        String selectedOption =
                automationPage.getSelectedDropdownOption();

        Assert.assertEquals(
                selectedOption,
                option
        );

        System.out.println(
                "PASS: " + option + " is selected"
        );
    }


    // =========================
    // Test 3 - Checkbox
    // =========================

    @Test(priority = 3)
    public void checkboxSelection() {

        automationPage.selectCheckbox1();
        automationPage.selectCheckbox2();

        Assert.assertTrue(
                automationPage.isCheckbox1Selected()
        );

        Assert.assertTrue(
                automationPage.isCheckbox2Selected()
        );

        Assert.assertFalse(
                automationPage.isCheckbox3Selected()
        );

        System.out.println(
                "Option 1 selected: "
                + automationPage.isCheckbox1Selected()
        );

        System.out.println(
                "Option 2 selected: "
                + automationPage.isCheckbox2Selected()
        );

        System.out.println(
                "Option 3 selected: "
                + automationPage.isCheckbox3Selected()
        );
    }


    // =========================
    // Test 4 - Switch Window
    // =========================

    @Test(priority = 4)
    public void switchWindow() throws InterruptedException {

        automationPage.switchToNewWindowAndClose();

        System.out.println(
                "Successfully switched to new window"
        );
    }


    // =========================
    // Test 5 - Switch Tab
    // =========================

    @Test(priority = 5)
    public void switchTab() throws InterruptedException {

        String title =
                automationPage.switchToNewTabAndGetTitle();

        Assert.assertFalse(
                title.isEmpty(),
                "New tab title should not be empty"
        );
    }


    // =========================
    // Test 6 - Alert Handling
    // =========================

    @Test(priority = 6)
    public void alertHandling() {

        String name = "SimiSunny";

        // Alert
        automationPage.enterAlertName(name);

        automationPage.clickAlertButton();

        automationPage.acceptAlert();


        // Confirmation Alert
        automationPage.enterConfirmName(name);

        automationPage.clickConfirmButton();

        automationPage.acceptConfirmAlert();
    }


    // =========================
    // Test 7 - Mouse Hover
    // =========================

    @Test(priority = 7)
    public void mouseHoverTest() throws InterruptedException {

        automationPage.hoverOverMouseHover();

        Assert.assertTrue(
                automationPage.isTopDisplayed()
        );

        System.out.println(
                "Top displayed: "
                + automationPage.isTopDisplayed()
        );

        automationPage.clickTop();

        Thread.sleep(3000);

        automationPage.hoverAgain();

        Assert.assertTrue(
                automationPage.isReloadDisplayed()
        );

        System.out.println(
                "Reload displayed: "
                + automationPage.isReloadDisplayed()
        );

        automationPage.clickReload();

        Thread.sleep(3000);
    }


    // =========================
    // Test 8 - iFrame
    // =========================

    @Test(priority = 8)
    public void iframeTest() throws InterruptedException {

        automationPage.switchToCoursesIframe();

        automationPage.clickPractice();

        String heading =
                automationPage.getPracticeHeading();

        System.out.println(
                "Practice Page Heading: "
                + heading
        );

        Assert.assertEquals(
                heading,
                "Join now to Practice"
        );

        automationPage.switchToMainPage();

        System.out.println(
                "Returned to main page"
        );
    }
}