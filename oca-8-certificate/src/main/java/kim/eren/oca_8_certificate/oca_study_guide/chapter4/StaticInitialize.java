package kim.eren.oca_8_certificate.oca_study_guide.chapter4;
 
public class StaticInitialize{
    static{
        System.out.println("static initialize executed1");
        ASSIGN_AFTER = 3;
    }
    public static final String TEST_VARIABLE = "SELAM";
    public static final int ASSIGN_AFTER;
   
    
}