package kim.eren.code_practices.tpoint.mediatordp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.CodePracticeResult;
import kim.eren.code_practices.tpoint.mediatordp.ApplicationMediator;
import kim.eren.code_practices.tpoint.mediatordp.entity.Colleague;
import kim.eren.code_practices.tpoint.mediatordp.entity.ConcreteColleague;
import kim.eren.code_practices.tpoint.mediatordp.entity.MobileColleague;

public class MediatorDesignPatternTest {
	private ApplicationMediator mediator;
	private Colleague desktop, mobile;

	@Before
	public void init() {
		mediator = new ApplicationMediator();
		desktop = new ConcreteColleague(mediator);
		mobile = new MobileColleague(mediator);
		mediator.addColleague(desktop);
		mediator.addColleague(mobile);
	}

	@Test
	public void test_desktop_send_message() {
		CodePracticeResult result = desktop.sendMessage("Desktop");
		System.out.println(result.getResultText());
		assertEquals("1", result.getResultId());
	}

	@Test
	public void test_mobile_send_message() {
		CodePracticeResult result = mobile.sendMessage("Mobile");
		System.out.println(result.getResultText());
		assertEquals("1", result.getResultId());
	}

	@Test
	public void test_colleague_get_method() {
		assertNotNull(mobile.getMediator());
	}

}
