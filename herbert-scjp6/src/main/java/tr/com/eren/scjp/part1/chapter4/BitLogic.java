package tr.com.eren.scjp.part1.chapter4;

public class BitLogic {

    public static void main(String[] args) {
        String binary[] = {"0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001","1010","1011","1100"};
        int a = 3;
        int b = 6;
        int c = a & b;
        int d = a | b;
        int e = a ^ b;
        int f = (~a & b) | (a & ~b);
        int g = ~a & 0x0f;
        System.out.println("a  " + binary[a]);
        System.out.println("b \t" + binary[b]);
        System.out.println("c = a & b " + binary[c]);
        System.out.println("d = a | b " + binary[d]);
        System.out.println("e = a ^ b  " + binary[e]);
        System.out.println("f = (~a & b) | (a & ~b); " + binary[f]);
        System.out.println("g = ~a & 0x0f " + binary[g]);

    }

}
