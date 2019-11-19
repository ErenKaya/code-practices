package kim.eren.oca_8_certificate.oca_study_guide.chapter6;

public class ExceptionTest{
    public static void main(String[] args) {
       System.out.println( exceptions());;
    }

    public static  String exceptions() {
    String result = "";
    String v = null;
    // before catch finally done
        try {
            try {
                result += "before";
                v.length();
                result += "after";
                } catch (NullPointerException e) {
                result += "catch";
                throw new RuntimeException();
                } finally {
                result += "finally";
                throw new Exception();
                }
        } catch (RuntimeException e) {
        result += "done";
        }catch (Exception e) {
            result += "done1";
            }
   return result;
   }
} 