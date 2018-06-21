
import java.util.Scanner;

public class MaxMinApp {

    static int i, number, maxValue, minValue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Sayıyı giriniz");
        number = scanner.nextInt();
        maxValue=number;
	minValue=number;
        calculateMaxMin(number);
        for (i = 2; i < 4; i++) {
            System.out.printf("%d .Sayıyı giriniz", i);
            number = scanner.nextInt();
            calculateMaxMin(number);
        }
         System.out.printf("Büyük sayı=%d ve Küçük sayı=%d ' dir",maxValue,minValue);
    }

    static void calculateMaxMin(int number) {
        if (maxValue < number) {
            maxValue = number;
        }
        if (minValue > number) {
            minValue = number;
        }
    }
}
