package entrata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseOne {

	public static WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hello\\Downloads\\chromedriverA\\chromedriver.exe");
		driver = new ChromeDriver();
		//visit the url
		driver.get("https://www.entrata.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void testHomePageFunction() {
		// verify the logo
		WebElement logo = driver.findElement(By.xpath("//a[@title=\"Entrata Home Page\"]"));
		//Assertions
		boolean visible = logo.isDisplayed();
		Assert.assertTrue(visible);
	}

	@Test
	public void DemoForm() {
		// click on WatchDemo
		WebElement WatchDemo = driver
				.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[1]/div/div/div[3]/a[1]"));
		WatchDemo.click();
		// fill the All filled
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Kalyani");
		driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Hadole");
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("kalyanihadole2001@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"Company\"]")).sendKeys("Web Crypt");
		// 503-555-1212
		driver.findElement(By.cssSelector("#Phone")).sendKeys("503-555-1212");

		WebElement selectUnitCount = driver.findElement(By.cssSelector("#Unit_Count__c"));
		Select s = new Select(selectUnitCount);
		s.selectByValue("11 - 100");

		driver.findElement(By.cssSelector("input[id=\"Title\"]")).sendKeys("Automation Testing");

		WebElement iAm = driver.findElement(By.cssSelector("#demoRequest"));
		Select ss = new Select(iAm);
		ss.selectByValue("a Resident");
//		driver.findElement(By.cssSelector("button[type=\"submit\"]")).submit();

		// assertion for validate the url
		boolean url = driver.getCurrentUrl().contains("watch-demo.html");
		Assert.assertTrue(url);
		System.out.println(url);

	}

	@Test
	public void SignIn() {
		WebElement signIn = driver.findElement(By.xpath("//div//a[@class=\"button-default outline-dark-button\"]"));
		signIn.click();

		WebElement managerLogin = driver.findElement(
				By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/div/div/div[1]/div/div[3]/a[1]"));
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click", managerLogin);
		managerLogin.click();
		
		driver.findElement(By.cssSelector("[id=\"entrata-username\"]")).sendKeys("KalyaniHadole29");
		driver.findElement(By.cssSelector("[id=\"entrata-password\"]")).sendKeys("@Kalyani29");
		//driver.findElement(By.cssSelector("button[type=\"submit\"]")).submit();
		
		//Assertions
		//entrata/login
		boolean currentUrl=driver.getCurrentUrl().contains("entrata/login");
		System.out.println(currentUrl);
		Assert.assertEquals(currentUrl, true);	

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
