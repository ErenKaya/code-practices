package kim.eren.code_practices.tpoint.observerdp;

import java.util.List;

public class HexaObserver extends Observer {

	public HexaObserver(List<String> messageList, Subject subject) {
		super();
		super.subject = subject;
		super.subject.attach(this);
		super.messageList = messageList;
	}

	@Override
	public void update() {
		messageList.add(Integer.toHexString(subject.getState()));
	}

}
