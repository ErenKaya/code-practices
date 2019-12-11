package kim.eren.oca_8_certificate.enthuware_test;

import java.util.ArrayList;
import java.util.List;

public class TestI{
    // we can use this on the declaration part
    private String s = this.toString();
    
    {s = new String("s");
    print(s);
}


    
    void print(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        // if your exception object have a message then to string method show it
        System.out.println(3+5*9-7);
        int i1 = 1;
        int i2 = 1;
        if(i1 == i2){
            System.out.println("equal");
        }
        List<String> stringList = new ArrayList<String>();
    }
}