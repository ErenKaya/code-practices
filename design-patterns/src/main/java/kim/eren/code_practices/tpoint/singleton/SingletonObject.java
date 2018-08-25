package kim.eren.code_practices.tpoint.singleton;

public class SingletonObject {
	
	private static SingletonObject singletonObject = new SingletonObject();



	public static SingletonObject getInstance() {
		return singletonObject;
	}


}
