package tr.com.eren.scjp.part1.chapter4;

public class BoolLogic {

    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;
        boolean c = a & b;
        boolean d = a | b;
        boolean e = a ^ b;
        boolean f = (!a & b) | (a & !b);
        boolean g = !a;
        System.out.println("a  " + a);
        System.out.println("b \t" + b);
        System.out.println("c = a & b " + c);
        System.out.println("d = a | b " + d);
        System.out.println("e = a ^ b  " + e);
        System.out.println("f = (~a & b) | (a & ~b); " + f);
        System.out.println("g = ~a & 0x0f " + g);

    }

}
