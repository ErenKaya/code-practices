package kim.eren.ocp.study_guide.chapter3;

import java.util.ArrayList;
import java.util.List;

public class Bound {
	private interface Flyers {
		void fly();
	}

	public class UpperBound {
		class Goose implements Flyers {
			@Override
			public void fly() {

			}

			// that method is allowed only one type of flyers which means you can push here
			// List<Goose> gooseList or
			// List<HangGlider> hGList;
			// you can not push here List<Flyers> flyers; because of flyers gets more than 2
			// types.
			// but we want to a group which bird types are must be same.
			public void groupOfFlyers(List<? extends Flyers> flyerGroup) {

			}
		}

		class HangGlider implements Flyers {
			@Override
			public void fly() {

			}

		}
	}

	public class LowerBound {

		void addSound(List<?> list) {
//			list.add("asd"); method does not compile
		}

		void addSound(List<? extends Object> list, boolean b1) {
//			list.add("selam"); method does not compile
		}

		void addSound(List<Object> list, boolean b1, boolean b2) {
			list.add("selam"); // method compiles but you have to send exact types
		}

		void add_sound_list_object_checker() {
			addSound(new ArrayList<Object>(), false, false);
//			addSound(new ArrayList<String>(),false,false); compile error because of method wants to exact type of list.
		}

		/**
		 * that method means that it can get a list which super type of String means
		 * that what is String super type ? = Object it can be get List<Object> list
		 * also can be get List<String> list.
		 * 
		 * @param list
		 * @param b1
		 * @param b2
		 * @param b3
		 */
		void addSound(List<? super String> list, boolean b1, boolean b2, boolean b3) {
			list.add("selam");
		}

		void add_sound_list_upper_bound_checker() {
			addSound(new ArrayList<Object>(), false, false, false);
			addSound(new ArrayList<String>(), false, false, false);
		}

	}

}
