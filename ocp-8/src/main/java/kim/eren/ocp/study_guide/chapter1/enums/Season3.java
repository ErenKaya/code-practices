package kim.eren.ocp.study_guide.chapter1.enums;

public enum Season3 {
	WINTER {
		@Override
		public void printHours() {
			System.out.println("Season3.WINTER.{...}.printHours()");
		};
	},
	SPRING {
		@Override
		public void printHours() {
			System.out.println("Season3.SPRING.{...}.printHours()");
		};
	},
	SUMMER, FALL;

	// printHours method if overriden from an item that overriden method invoked
	// otherwise
	// default method invoked
	public void printHours() {
		System.out.println("Season3.printHours()");
	};
}
