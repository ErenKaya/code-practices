package kim.eren.code_practices.tpoint.observerdp;

import java.util.List;

public class OctalObserver extends Observer {

	public OctalObserver(List<String> messageList, Subject subject) {
		super();
		super.subject = subject;
		super.subject.attach(this);
		super.messageList = messageList;
	}

	@Override
	public void update() {
		messageList.add(Integer.toOctalString(subject.getState()));
	}

}
