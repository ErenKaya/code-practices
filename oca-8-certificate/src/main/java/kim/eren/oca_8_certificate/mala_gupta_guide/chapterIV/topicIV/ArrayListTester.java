package kim.eren.oca_8_certificate.mala_gupta_guide.chapterIV.topicIV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTester{
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        strList.add("eren");
        strList.add("kaya");
        strList.add("hello");

        Iterator<String> strIterator = strList.iterator();
        for(int i = 0; strIterator.hasNext();i++){
            System.out.println(strIterator.next());
            if(i>0){
                strIterator.remove();
            }
        }
        for(String s : strList){
            System.out.println("Modified List Element: "+s);
        }
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
  
}