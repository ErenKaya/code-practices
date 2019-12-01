package kim.eren.oca_8_certificate.mala_gupta_guide.chapterIV.topicIV;

import java.time.LocalDate;
import java.time.LocalTime;

public class Java8DateTester {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        d.plusDays(1);
        LocalDate interviewDate = LocalDate.of(2016,02,28);
        System.out.println(interviewDate.atTime(16, 30));
        System.out.println(interviewDate.atTime(16, 30, 20));
        System.out.println(interviewDate.atTime(16, 30, 20, 300));
        System.out.println(interviewDate.atTime(LocalTime.of(16, 30)));
    }

}