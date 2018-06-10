package kim.eren.code_practices.singleton;

public class SingletonObject {
	
	private static SingletonObject singletonObject = new SingletonObject();



	public static SingletonObject getInstance() {
		return singletonObject;
	}


}
