package kim.eren.ocp.study_guide.chapter3;

import java.util.ArrayDeque;

public class ArrayDequeTest {
	/**
	 * array deque cannot get a null value because of null is special return type on
	 * some deque methods.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test_push_to_deck();
		System.out.println();
		test_offer_to_deck();
	}

	/**
	 * offer method adds element to back of the array. |||| 10 | 4 |||
	 */
	private static void test_offer_to_deck() {
		ArrayDeque<Integer> deck = new ArrayDeque<>();
		deck.offer(10);
		deck.offer(4);
		printArray(deck);

	}

	/**
	 * peek method gets element from top of array. poll method gets and removes
	 * element from top of array
	 * 
	 * @param deck
	 */
	private static void printArray(ArrayDeque<Integer> deck) {
		System.out.println("1. peek method: " + deck.peek());
		System.out.println("2. poll method: " + deck.poll());
		System.out.println("3. poll method: " + deck.poll());
		System.out.println("4. peek method: " + deck.peek());
	}

	/**
	 * push method adds element to front of the array |||| 4 | 10 |||
	 */
	private static void test_push_to_deck() {
		ArrayDeque<Integer> deck = new ArrayDeque<>();
		deck.push(10);
		deck.push(4);
		printArray(deck);
	}

}
