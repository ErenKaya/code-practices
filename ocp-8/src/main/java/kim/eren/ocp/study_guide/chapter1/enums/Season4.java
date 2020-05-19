package kim.eren.ocp.study_guide.chapter1.enums;

public enum Season4 {
	WINTER(true);

	// That constructor executed only once if you have only one element
	// if elements constructed before that method not executed
	private Season4(boolean isInitializationComplete) {
		System.out.println("Season4.Season4()");
	}
}
