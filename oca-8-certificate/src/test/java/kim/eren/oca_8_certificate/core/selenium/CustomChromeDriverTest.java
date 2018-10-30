package kim.eren.oca_8_certificate.core.selenium;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomChromeDriverTest {

	FirefoxDriver driver;
	String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources"
			+ File.separator + "geckodriver";

	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
	}

	@Test
	public void ping_thy() {
		driver.get("https://www.turkishairlines.com/tr-tr/");
		WebElement fromButtonElement = driver.findElement(By.cssSelector("button[data-id='from_select']"));
		fromButtonElement.click();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div/div/input"))
				.sendKeys("ATATURK");
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div/ul/li[2]/a"))
				.click();

		try {
			WebElement toButtonElement = driver.findElement(By.cssSelector("button[data-id='to_select']"));
			toButtonElement.click();
		} catch (Exception e) {
			System.out.println("To Button didn't find");
		}
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div/input"))
				.sendKeys("LONDRA");
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/ul/li[2]/a"))
				.click();
		LocalDate date = LocalDate.now();
		driver.findElement(By.xpath("//*[@id='calendarTriggerGeneral']")).click();
		driver.findElement(By.cssSelector("a[data-timestamp='" + new Date(date.toEpochDay()) + "']")).click();

		System.out.println(driver.getTitle());
	}

}
