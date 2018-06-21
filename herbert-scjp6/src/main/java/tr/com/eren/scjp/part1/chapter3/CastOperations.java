
package tr.com.eren.scjp.part1.chapter3;


public class CastOperations {
    public static void main(String[] args) {
        byte b;
        int i=257;
        double d=323.23;
        byte byt=50;
        byt=(byte)(byt*2);
        System.out.println("Integer'den Dönüştürülmüş byte "+byt);
        System.out.println("Integer'den Dönüştürülmüş byte "+(byte)i);
        System.out.println("Double'den dönüştürülmüş integer "+(int)d);
        System.out.println("Integer'den dönüştürülmüş double "+(double)i);
        System.out.println("Double'den dönüştürülmüş byte "+(byte)d);
        
    }


}
