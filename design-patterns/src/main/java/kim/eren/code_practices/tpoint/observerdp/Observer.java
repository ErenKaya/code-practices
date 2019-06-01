package kim.eren.code_practices.tpoint.observerdp;

import java.util.Map;

public abstract class Observer {
	protected Subject subject;
	protected Map<ObserverType, String> messageList;

	public abstract void update();
}
