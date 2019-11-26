package kim.eren.oca_8_certificate.mala_gupta_guide.java_data_types.chapterII_IV;

public class AssignmenOperator{
    
    public static void main(String[] args) {
        int a = 25,b=2,c=2;
        // there was a another number to operate before the assignment operator
        // java will operate this process before the assignment then rely on assignment
        // b(a+6); 2(25+6);
        b*=a+6;
        c = c * a + 5;
        System.out.println(b);
        System.out.println(c);
    }
}