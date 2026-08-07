package Task1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class task2automation {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.Chrome.driver", "/C:\\Users\\xminds\\-win64.zip/chromedriver/");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// 2. Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();

		alert.accept();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

		alert = driver.switchTo().alert();

		System.out.println("Confirm message: " + alert.getText());

		alert.accept();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

		alert = driver.switchTo().alert();

		System.out.println("Prompt message: " + alert.getText());

		alert.sendKeys("Hello Selenium");

		alert.accept();
		Thread.sleep(3000);

		String result = driver.findElement(By.id("result")).getText();

		System.out.println("Result: " + result);

		driver.quit();

	}

}
