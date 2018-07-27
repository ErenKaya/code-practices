package kim.eren.oca_8_certificate.lambda.tutorialspoint.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamFunction {

	public void printRandomNumbers(Integer limit) {
		Random random = new Random();
		random.ints().limit(limit).forEach(System.out::println);
		// Print with sort
		random.ints().limit(10).sorted().forEach(System.out::println);
	}

	public int filterEmptyString(List<String> strList) {
		return (int) strList.stream().filter(s -> s.isEmpty()).count();
	}

	public List<Integer> getSquareList(List<Integer> intList) {
		/**
		 * Collect square numbers from list with distinct calculation. so numbers are unique
		 */
		return intList.stream().map(i -> i * i).distinct().collect(Collectors.toList());
	}

	public IntSummaryStatistics getIntegerListStatics(List<Integer> intList) {
		return intList.stream().mapToInt((x) -> x).summaryStatistics();
	}

	public String mergeLists(List<String> strList) {
		return strList.stream().filter((str) -> !str.isEmpty()).collect(Collectors.joining(", "));
	}

}
