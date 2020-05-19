package kim.eren.ocp.study_guide.chapter1.enums;

public enum Season2 {
	WINTER {
		@Override
		public void printHours() {
			// TODO Auto-generated method stub
			
		}
	}, SPRING {
		@Override
		public void printHours() {
			// TODO Auto-generated method stub
			
		}
	}, SUMMER {
		@Override
		public void printHours() {
			// TODO Auto-generated method stub
			
		}
	}, FALL {
		@Override
		public void printHours() {
			// TODO Auto-generated method stub
			
		}
	};
	// enums has containable abstract methods 
	// that abstract method must be implements every item of enum.
	public abstract void printHours();
}
