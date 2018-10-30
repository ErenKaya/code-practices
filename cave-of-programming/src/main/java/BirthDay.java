
import java.util.HashMap;
import java.util.Map;

public class BirthDay {

    public static void main(String[] args) {
    	Friend f1 = new Friend("Draumur");
    	Friend f2 = new Friend("Draumur");
        Map<Friend, String> hm = new HashMap<Friend, String>();
        hm.put(new Friend("Charis"), "Summer 2009");
        hm.put(f1, "Spring 2002");
        hm.put(f2 , "asd");
        Friend f = new Friend("Draumur");
        if(f1.equals(f2)) {
        	System.out.println("return true");
        }
        System.out.println(hm.get(f));
    }
}

