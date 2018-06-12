package kim.eren.code_practices.proxydp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.proxydp.entity.Image;
import kim.eren.code_practices.proxydp.entity.ProxyResult;

public class ProxyPatternTest {

	Image image;
	public static final String LOAD_IMAGE_FILE = "test_load_10_mb.jpg";
	public static final String DISPLAY_IMAGE_FILE = "test_display_10_mb.jpg";

	@Before
	public void init() {
		image = new ProxyImage(LOAD_IMAGE_FILE);
	}

	@Test
	public void test_is_image_display() {
		ProxyResult proxyResult = image.display();
		System.out.println(" ");
		ProxyResult proxyResult2 = image.display();
		System.out.println(proxyResult2.getResultText());
		assertEquals("Display", proxyResult2.getResultId());

	}

	@Test
	public void test_is_image_load() {
		image = new ProxyImage(LOAD_IMAGE_FILE);
		ProxyResult proxyResult = image.display();
		System.out.println(proxyResult.getResultText());
		assertEquals("Load", proxyResult.getResultId());
	}
}
