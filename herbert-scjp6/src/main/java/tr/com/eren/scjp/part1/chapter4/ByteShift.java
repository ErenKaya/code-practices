package tr.com.eren.scjp.part1.chapter4;

public class ByteShift {
    public static void main(String[] args) {
        byte a=64,b;
        int i;
        i=a<<2;
        b=(byte)(a<<2);
        System.out.println("Original A "
                + a);
        System.out.println("i: "+i+" b: "+b);
    }
}
