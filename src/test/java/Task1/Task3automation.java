package Task1;
import base.BaseTest;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.BaseTest;
public class Task3automation extends BaseTest {


	
	@Test(priority = 1)
	public void Radiobuttontest() {
		WebElement Radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		WebElement Radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));
		WebElement Radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		Radio1.click();
		Assert.assertTrue(Radio1.isSelected());
		Assert.assertFalse(Radio2.isSelected());
		Assert.assertFalse(Radio3.isSelected());
	}

	@Test(priority = 2)
	public void selectOption1() {
		WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
		// Create Select object
		Select dropdown = new Select(dropdownElement);

		// Select Option1
		dropdown.selectByVisibleText("Option1");

		String selectedOption = dropdown.getFirstSelectedOption().getText();

		Assert.assertEquals(selectedOption, "Option1");

		System.out.println("PASS: Option1 is selected");
	}

	@Test(priority = 3)
	public void checkboxselection() {
		WebElement option1 = driver.findElement(By.id("checkBoxOption1"));
		WebElement option2 = driver.findElement(By.id("checkBoxOption2"));
		WebElement option3 = driver.findElement(By.id("checkBoxOption3"));

		option1.click();
		option2.click();

		Assert.assertTrue(option1.isSelected());
		Assert.assertTrue(option2.isSelected());
		Assert.assertFalse(option3.isSelected());

		System.out.println("Option 1 selected: " + option1.isSelected());
		System.out.println("Option 2 selected: " + option2.isSelected());
		System.out.println("Option 3 selected: " + option3.isSelected());
	}

	@Test(priority = 4)
	public void SwitchWindow() throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		driver.findElement(By.id("openwindow")).click();

		for (String windowHandle : driver.getWindowHandles()) {

			if (!windowHandle.equals(parentwindow)) {

				driver.switchTo().window(windowHandle);

				Thread.sleep(3000);

				driver.close();

				// Switch back to parent window
				driver.switchTo().window(parentwindow);
				break;
			}
		}
	}

	@Test(priority = 5)
	public void SwitchTab() throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		driver.findElement(By.id("opentab")).click();

		Thread.sleep(2000);

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {

			if (!windowHandle.equals(parentwindow)) {

				driver.switchTo().window(windowHandle);

				System.out.println("Switched to new tab");
				System.out.println("Title: " + driver.getTitle());
				System.out.println("URL: " + driver.getCurrentUrl());

				driver.switchTo().window(parentwindow);
				break;
			}
		}
	}

	@Test(priority = 6)
	public void alert_Handling() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("SimiSunny");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert alert = driver.switchTo().alert();

		alert.accept();

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("SimiSunny");
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		alert.accept();

	}

	@Test(priority = 7)
	public void MouseHoverTest() throws InterruptedException {

		// Locate Mouse Hover button
		WebElement mouseHover = driver.findElement(By.id("mousehover"));

		Actions actions = new Actions(driver);

		// Scroll to Mouse Hover
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mouseHover);

		Thread.sleep(3000);

		// Hover over Mouse Hover
		actions.moveToElement(mouseHover).perform();

		Thread.sleep(5000);

		// Verify Top
		WebElement top = driver.findElement(By.xpath("//a[text()='Top']"));

		Assert.assertTrue(top.isDisplayed());

		System.out.println("Top displayed: " + top.isDisplayed());

		top.click();

		// Wait so you can see page move to top
		Thread.sleep(5000);

		// Find Mouse Hover again
		// mouseHover = driver.findElement(By.id("mousehover"));

		// Scroll back to Mouse Hover
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mouseHover);

		Thread.sleep(3000);

		actions.moveToElement(mouseHover).perform();

		Thread.sleep(5000);

		// Verify Reload
		WebElement reload = driver.findElement(By.xpath("//a[text()='Reload']"));

		Assert.assertTrue(reload.isDisplayed());

		System.out.println("Reload displayed: " + reload.isDisplayed());
		reload.click();

		Thread.sleep(5000);
	}

	@Test(priority = 8)
	public void IframeTest() throws InterruptedException {

		// Switch to iframe
		driver.switchTo().frame("courses-iframe");

		Thread.sleep(3000);

		
		WebElement practice = driver.findElement(By.xpath("//a[normalize-space()='Practice']"));

		practice.click();

		Thread.sleep(5000);

		// Print the heading on Practice page
		WebElement heading = driver.findElement(By.xpath("//h2[normalize-space()='Join now to Practice']"));

		System.out.println("Practice Page Heading: " + heading.getText());
		Assert.assertEquals(heading.getText(), "Join now to Practice");

		// Return to main page
		driver.switchTo().defaultContent();

		Thread.sleep(3000);

		System.out.println("Returned to main page");
	}

	
}
