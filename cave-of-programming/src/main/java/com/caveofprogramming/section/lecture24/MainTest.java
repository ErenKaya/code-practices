package com.caveofprogramming.section.lecture24;

public class MainTest {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Cave Of Programming").append(" ").append("with John Purcell");
        System.out.println(stringBuilder.toString());
        for (int i = 0; i <= 20; i++) {
            System.out.printf("My literaly number is: %-2d\n", i);

        }

    }

}
