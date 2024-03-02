package entrata;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCasesTwo {
	public WebDriver driver;

	@BeforeMethod
	public void SetUpOne() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hello\\Downloads\\chromedriverA\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.entrata.com/");
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void SheduleDemo() {
//		String ParentWindow=driver.getWindowHandle();
//		System.out.println(ParentWindow);
		driver.findElement(By.cssSelector(
				"#gatsby-focus-wrapper > div > div.main-header > div > div > div.header-desktop-nav.hide-on-mobile > div:nth-child(4) > a"))
				.click();
		// Set<String> multipleWindow = driver.getWindowHandles();
//		System.out.println(multipleWindow);

		Set<String> multipleWindow = driver.getWindowHandles();
		System.out.println(multipleWindow);
		Iterator<String> iterator = multipleWindow.iterator();

		String parentIterator = iterator.next();
		String childIterator = iterator.next();
		driver.switchTo().window(childIterator);
		WebElement Click = driver
				.findElement(By.cssSelector("body > section.event-content-cap > a > div.text-block-4"));
		Click.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"56aeaca6-a0ad-4548-8afc-94d8d4361ba1\"]")).sendKeys("Kalyani");
		driver.findElement(By.xpath("//*[@id=\"cfc98829-80b7-41b6-82b5-b968d43ef1c1\"]")).sendKeys("Hadole");
		driver.findElement(By.xpath("//*[@id=\"227f50d0-f65b-4a72-9a4f-5060ea05f6ab\"]")).sendKeys("web Crypt");
		driver.findElement(By.xpath("//*[@id=\"228cc308-a4d9-4212-8454-8407dd578c3d\"]"))
				.sendKeys("Automatioon Tester");
		driver.findElement(By.xpath("//*[@id=\"ff919d05-4281-4d9c-aa0d-82e3722d580d\"]"))
				.sendKeys("kalyanihadole@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"032e80c1-f29f-44e6-af13-a89e53906422\"]")).sendKeys("9999999999");
		WebElement checkbox = driver.findElement(By.cssSelector("#adminRegSelected_0"));

		// Check if the checkbox is not selected before clicking
		if (!checkbox.isSelected()) {
			// Click the checkbox
			checkbox.click();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Kalyani");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Hadole");
		driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("kalyanihadole@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"forward\"]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement exampleElement = driver
				.findElement(By.xpath("//*[@id=\"focusTrap\"]/div/div[2]/div/div/div/div[2]/p"));
		String actualMessage = exampleElement.getText();

		// Assert the text using TestNG's Assert class
		// Admins and Registrants can't have the same email address.
		Assert.assertEquals(actualMessage, "Admins and Registrants can't have the same email address.");

	}

	@Test
	public void Ribin() {
		Actions action = new Actions(driver);
		WebElement hover = driver.findElement(By.cssSelector(
				"#gatsby-focus-wrapper > div > div.main-header > div > div > div.header-desktop-nav.hide-on-mobile > div:nth-child(1) > div.main-nav-link"));
		action.moveToElement(hover).build().perform();
		WebElement hoverElemnet = driver.findElement(By.xpath(
				"//*[@id=\"gatsby-focus-wrapper\"]/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a[1]"));
		boolean visible = hoverElemnet.isDisplayed();
		Assert.assertTrue(visible);

	}

	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}

}
