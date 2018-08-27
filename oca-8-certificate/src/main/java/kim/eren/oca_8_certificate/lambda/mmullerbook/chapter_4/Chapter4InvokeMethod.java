package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_4;

import java.util.function.Supplier;

public class Chapter4InvokeMethod {
	
	
	public static <T> T invokeMethod(Supplier<T> method) {
		long start = System.nanoTime();
		T result = method.get();
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Elapsed time: " + elapsedTime / 1000000);
		return result;
	}

}
