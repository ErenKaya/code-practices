package kim.eren.ocp.study_guide.chapter1.enums;

public enum Season {
	WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
	
	private String expectedVisitors;
	
	// enum compile with private constructor
	private Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}
	
	public void printExpectedVisitors() {
		System.out.println(expectedVisitors);
	}
}
