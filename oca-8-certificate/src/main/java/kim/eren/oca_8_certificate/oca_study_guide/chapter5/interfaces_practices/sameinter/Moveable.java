package kim.eren.oca_8_certificate.oca_study_guide.chapter5.interfaces_practices.sameinter;

public interface Moveable {
	int moveSpeed=2;
	void canRun();

	default void testMethod(){
		System.out.println("test method");
	}
}
