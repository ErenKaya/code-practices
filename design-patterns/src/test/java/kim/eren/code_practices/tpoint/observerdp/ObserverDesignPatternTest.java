package kim.eren.code_practices.tpoint.observerdp;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class ObserverDesignPatternTest {

	private Subject subject;
	private HashMap<ObserverType, String> messageList;

	@Before
	public void init() {
		this.subject = new Subject();
		this.messageList = new HashMap<ObserverType, String>();
		this.subject.attach(new HexaObserver(messageList, subject));
		this.subject.attach(new OctalObserver(messageList, subject));
		this.subject.setState(10);
		this.subject.notifyAllObservers();
	}

	@Test
	public void test_hexa_decimal_result_from_subject() {
		assertEquals("a", messageList.get(ObserverType.HEXA));
	}

	@Test
	public void test_octal_decimal_result_from_subject() {
		assertEquals("12", messageList.get(ObserverType.OCTAL));
	}

}
