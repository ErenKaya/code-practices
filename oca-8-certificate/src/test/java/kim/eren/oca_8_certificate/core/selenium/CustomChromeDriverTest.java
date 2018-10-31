package kim.eren.oca_8_certificate.core.selenium;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomChromeDriverTest {

	FirefoxDriver driver;
	String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources"
			+ File.separator + "geckodriver";
	private static final String DEPARTURE_PLACE = "IST";
	private static final String LANDING_PLACE = "LON";
	private static final LocalDate DEPARTURE_DATE = LocalDate.now().plusDays(2);
	private static final LocalDate RETURN_DATE = LocalDate.now().plusDays(4);

	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
	}

	@Test
	/**
	 * I have no idea how to handle that element on load or isNotNull 
	 * TODO= Search how to handle page on load that github repo has been reference for me
	 * https://github.com/lalit-k/selenium-java-tests 
	 * @throws InterruptedException
	 */
	public void find_pre_declared_specific_flight_search() throws InterruptedException {
		driver.get("https://www.turkishairlines.com/tr-tr/");
		WebElement fromButtonElement = driver.findElement(By.cssSelector("button[data-id='from_select']"));
		Thread.sleep(2000);
		fromButtonElement.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Constants.XPATH_FROM_INPUT)).sendKeys(Keys.CONTROL, Keys.BACK_SPACE,
				DEPARTURE_PLACE);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Constants.XPATH_FROM_FIRST_ELEMENT_OF_FOUND)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Constants.XPATH_TO_INPUT)).sendKeys(LANDING_PLACE);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Constants.XPATH_TO_FIRST_ELEMENT_OF_FOUND)).click();
		Thread.sleep(2000);
		driver.findElement(By
				.cssSelector("a[data-timestamp='" + Timestamp.valueOf(DEPARTURE_DATE.atStartOfDay()).getTime() + "']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector("a[data-timestamp='" + Timestamp.valueOf(RETURN_DATE.atStartOfDay()).getTime() + "']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[aria-label='Tamam']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[aria-label='" + Constants.ECONOMY_CLASS + "']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[aria-label='Ara']")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}

}
