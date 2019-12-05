package kim.eren.oca_8_certificate.oca_study_guide.chapter6;

public class CheckedException {

    public static void checkedExpTest() throws Exception{
        try {
            String s[]  = new String[3];
            System.out.println(s[3]);
            throw new Exception();
        } catch (RuntimeException e) {
            System.out.println("awake!");
        }finally{
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        checkedExpTest();
    }
}