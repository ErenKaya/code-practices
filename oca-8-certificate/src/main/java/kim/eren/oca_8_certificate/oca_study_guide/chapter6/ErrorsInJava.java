package kim.eren.oca_8_certificate.oca_study_guide.chapter6;

public class ErrorsInJava{

    
    static {
        int[] countsOfMoose = new int[3];
        int num = countsOfMoose[-1];
        }
        public static void main(String[] args) {int num = 2;  }
        
        
        //stack over flow error
        public static void doNotCodeThis(int num) {
            doNotCodeThis(1);
            }
}