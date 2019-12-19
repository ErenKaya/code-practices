package kim.eren.oca_8_certificate.mala_gupta_guide.chapterV.topicIV;

public class TopicIVTester {
    public static void main(String[] args) {
        Employee e = new HRPersonal();
        HRPersonal hr = (HRPersonal) e;
        Interviewer i = ((Interviewer) hr);
        System.out.println(e.a);
        // that was a compile error because this reference has not a variable which name
        // is a 
        // System.out.println(i.a);
    }
}