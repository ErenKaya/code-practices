package kim.eren.ocp.study_guide.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	/**
	 * tree map keys cannot be null because of these are sorting. hashtable keys
	 * also cannot get a null value.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test_hash_map();
		System.out.println();
		test_tree_map();
	}

	/**
	 * tree map is sorted.
	 */
	private static void test_tree_map() {
		Map<String, String> hashMap = new TreeMap<>();
		addItems(hashMap);
		for (String key : hashMap.keySet()) {
			System.out.println(key + ", ");
		}

	}

	/**
	 * hashmap have no order
	 */
	private static void test_hash_map() {
		Map<String, String> hashMap = new HashMap<>();
		addItems(hashMap);
		for (String key : hashMap.keySet()) {
			System.out.println(key + ", ");
		}
		check_map_methods(hashMap);

	}

	private static void check_map_methods(Map<String, String> hashMap) {
		System.out.println("***check_map_methods***");
		System.out.println(hashMap.containsKey("koola"));
		System.out.println(hashMap.containsKey("lion1"));
		System.out.println(hashMap.containsValue("bamboo"));
		System.out.println(hashMap.containsValue("grass1"));

	}

	private static void addItems(Map<String, String> hashMap) {
		hashMap.put("koola", "bamboo");
		hashMap.put("lion", "meat");
		hashMap.put("cow", "grass");
	}

}
