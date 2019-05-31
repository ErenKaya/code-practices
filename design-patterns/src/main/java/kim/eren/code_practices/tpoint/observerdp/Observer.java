package kim.eren.code_practices.tpoint.observerdp;

import java.util.List;

public abstract class Observer {
	protected Subject subject;
	protected List<String> messageList;

	public abstract void update();
}
