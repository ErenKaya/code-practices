package kim.eren.oca_8_certificate.core.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAnyLoginPage {

	FirefoxDriver driver;
	private static final String USERNAME_INPUT = "//*[@id=\"username\"]";
	private static final String PASSWORD_INPUT = "//*[@id=\"password\"]";
	List<FirefoxDriver> driverList = new ArrayList<FirefoxDriver>();
	private String username = null;
	private String url = null;
	private String password = null;

	@Before
	public void init() throws IOException {
		System.setProperty("webdriver.gecko.driver", Constants.DRIVER_PATH);
		File configFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "resources" + File.separator + "selenium.config");
		FileInputStream fis = new FileInputStream(configFile);
		String contextFile = "";
		int content;
		while ((content = fis.read()) != -1) {
			contextFile += (char) content;
		}
		fis.close();
		JSONObject contextJO = new JSONObject(contextFile);
		username = (String) contextJO.get("username");
		url = (String) contextJO.get("url");
		password = (String) contextJO.get("password");
		for (int i = 0; i < 1; i++) {
			driverList.add(new FirefoxDriver());
		}
	}

	@Test
	public void testIasLogin() {
		for (FirefoxDriver driver : driverList) {
			driver.get(url);
			driver.findElement(By.xpath(USERNAME_INPUT)).sendKeys(username);
			driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(password);
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[3]/button")).click();
			System.err.println();
		}
	}

}
