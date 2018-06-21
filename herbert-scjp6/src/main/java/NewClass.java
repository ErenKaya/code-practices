
import java.util.LinkedList;
import java.util.List;



public class NewClass {
    static String string1= "I am unique";
    public static void main(String[] args) {
       String string2="I am unique";
       String string3= new String(string1);
        System.out.println(string1==string2);
        System.out.println(string1.equals(string2));
        System.out.println(string3==string1);
        System.out.println(string3.equals(string1));
        Integer integer=new Integer("1");
        Integer integer1=new Integer("2");
        Integer integer2=new Integer("3");
        int i4=integer+integer1+integer2;
        List<Integer> l = new <Integer>LinkedList();
        System.out.println(i4);
    }

}
