package kim.eren.oca_8_certificate.oca_study_guide.exams.book;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class TestIV {
    /**
     * 40C 10W
     * not enough paying attention
     * 3 question: binary search
     * 4 question: missing information
     */
    public static void main(String[] args) {
        String[][] sArray = new String[1][];
        String[][] sArray2 = new String[1][];
        LocalDate.of(2014,Calendar.JUNE,21);
        LocalDate d = LocalDate.of(2014,Month.JUNE,21);
        if(sArray.equals(sArray2))
            System.out.println("selam");
        else System.out.println("selam yazmadı");
        String [] withoutNew = {"",",",""};
        String [] withoutNew2 = new String[]{"Mac","Linux","Windows"};
        Arrays.sort(withoutNew2);
        System.out.println(Arrays.toString(withoutNew2));
        System.out.println(Arrays.binarySearch(withoutNew2, "RedHat"));
        // String[] withNew = new String[3];

        // withNew[3] = "sd";

    ArrayList s = new ArrayList<>();
    s.add(0, 1);
    s.add(1, "element");
    for (Object sE : s) {
        System.out.print(sE);
    }
    }
}