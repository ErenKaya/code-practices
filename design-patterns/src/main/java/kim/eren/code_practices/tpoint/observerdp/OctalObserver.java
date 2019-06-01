package kim.eren.code_practices.tpoint.observerdp;

import java.util.Map;

public class OctalObserver extends Observer {

	public OctalObserver(Map<ObserverType, String> messageList, Subject subject) {
		super();
		super.subject = subject;
		super.subject.attach(this);
		super.messageList = messageList;
	}

	@Override
	public void update() {
		messageList.put(ObserverType.OCTAL, Integer.toOctalString(subject.getState()));
	}

}
