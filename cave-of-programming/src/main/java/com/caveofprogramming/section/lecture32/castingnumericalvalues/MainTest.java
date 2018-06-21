
package com.caveofprogramming.section.lecture32.castingnumericalvalues;


public class MainTest {
    public static void main(String[] args) {
        byte byteValue=33;
        short shortValue=55;
        int intValue=2323;
        long longValue=88822;
        
        float floatValue=8834.3f;
        float floatValue2=(float)99.3;
        double doubleValue=32.4;
        
        System.out.println(Byte.MAX_VALUE);
        
        intValue=(int) longValue;
        System.out.println(intValue);
        
        doubleValue=intValue;
        System.out.println(doubleValue);
        
        intValue=(int) floatValue;
        System.out.println(intValue);
        
        //beklediğimiz gibi çalışmaz çünkü 128 çok byte değerine göre büyük ve geriye doğru gider..
        byteValue=(byte)136;
        System.out.println(byteValue);
    }
}
