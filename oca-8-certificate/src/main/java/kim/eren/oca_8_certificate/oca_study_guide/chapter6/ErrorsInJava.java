package kim.eren.oca_8_certificate.oca_study_guide.chapter6;

import java.io.IOException;

public class ErrorsInJava{
int x1 = 3, x2=4;
boolean b = x1>=x2;
    
    // static {
    //     int[] countsOfMoose = new int[3];
    //     int num = countsOfMoose[-1];
    //     }
        public static void main(String[] args) {int num = 2;
        System.out.println(2/5);
        String s = (String) new Object();
        try {
            doNotCodeThis(1);
        } catch (StackOverflowError e) {
            System.out.println("catched");
        }
        try {
            // you have to catch exact exception if it throws checked exception
            // new ErrorsInJava().returnTypeException();
        } catch (NullPointerException e) {
            //TODO: handle exception
        }
        }
        
        
        //stack over flow error
        public static void doNotCodeThis(int num) throws StackOverflowError{
            doNotCodeThis(1);
        }

        public static void notThrowAnException() throws IOException {
            System.out.println("sd");
        }

        public Exception returnTypeException() throws Exception{ 
            return null;
        }
}