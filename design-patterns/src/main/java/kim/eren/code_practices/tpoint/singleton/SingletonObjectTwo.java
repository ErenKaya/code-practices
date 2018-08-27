package kim.eren.code_practices.tpoint.singleton;

public class SingletonObjectTwo {

	private static SingletonObjectTwo objectTwo;

	public SingletonObjectTwo() {

	}

	public static SingletonObjectTwo getInstance() {
		if (objectTwo == null) {
			objectTwo = new SingletonObjectTwo();
		}
		return objectTwo;
	}

}
