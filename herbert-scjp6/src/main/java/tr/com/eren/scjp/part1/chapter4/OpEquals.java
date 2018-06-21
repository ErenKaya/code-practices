package tr.com.eren.scjp.part1.chapter4;

public class OpEquals {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        a += 5;
        b *= 4;
        c += a * b;
        c %= 6;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
