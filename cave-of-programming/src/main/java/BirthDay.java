
import java.util.HashMap;
import java.util.Map;

public class BirthDay {

    public static void main(String[] args) {
        Map<Friend, String> hm = new HashMap<Friend, String>();
        hm.put(new Friend("Charis"), "Summer 2009");
        hm.put(new Friend("Draumur"), "Spring 2002");
        Friend f = new Friend(args[0]);
        System.out.println(hm.get(f));
    }
}

