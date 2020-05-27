package kim.eren.ocp.study_guide.chapter3;

public class GenericClasses {
	public class Crate<T> {
		private T content;

		public T getEmptyCrate() {
			return content;
		}

	}

	// If you want to create a static method without relativity with enclosing class
	// you have to type <T> before the returning formal type. if you does not
	// declare
	// you will get compile error. <T> means that there is a generic method!
	// you can declare more than one in one diamond 	
	public static <T,U,C,S> Crate<U> test_generic_method(T t) {
		return null;
	}
	
	// if your have no return type but you have to get a argument in the method you have to
	// declare <T> that t means your argument or return type is T!
	public static <T> void test_void(T t) {

	}

}
