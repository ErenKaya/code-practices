package kim.eren.code_practices.singleton;

public class SingletonObject {
	
	private static SingletonObject singletonObject = new SingletonObject();

	private SingletonObject() {

	}

	public static SingletonObject getInstance() {
		return singletonObject;
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}
