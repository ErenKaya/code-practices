package kim.eren.oca_8_certificate.mala_gupta_guide.chapterII.topicV;

public class WrapperClass{

    public static void main(String[] args) {
        // that was expected true because of wrapper class cash mechanism
        Long var1 = Long.valueOf(123);
        Long var2  = Long.valueOf("123");
        System.out.println(var1 == var2);
    }
}