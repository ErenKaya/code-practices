package kim.eren.oca_8_certificate.core.selenium;

import java.io.File;

public class Constants {
	public static final String XPATH_FROM_INPUT = "/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div/div/input";
	public static final String XPATH_FROM_FIRST_ELEMENT_OF_FOUND = "/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div/ul/li[2]/a";
	public static final String XPATH_TO_INPUT = "/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div/input";
	public static final String XPATH_TO_FIRST_ELEMENT_OF_FOUND = "/html/body/div[2]/div[2]/section/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/ul/li[2]/a";
	public static final String ECONOMY_CLASS = "Economy Class";
	public static final String DRIVER_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "resources" + File.separator + "geckodriver-v0.24.0-win64.exe";

}
