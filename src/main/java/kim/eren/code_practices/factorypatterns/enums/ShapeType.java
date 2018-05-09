package kim.eren.code_practices.factorypatterns.enums;

public enum ShapeType {
	SQUARE {
		public String toString() {
			return "square";
		}
	},
	RECTANGLE {
		public String toString() {
			return "rectangle";
		}
	},
	CIRCLE {
		public String toString() {
			return "circle";
		}
	};

}
