package tr.com.eren.scjp.part1.chapter4;

public class QuestionOperator {

    public static void main(String args[]) {
        int i, k;
        i = 10;
        k = i < 0 ? -i : i; // get absolute value of i 
        System.out.print("Absolute value of ");
        System.out.println(i + " is " + k);
        i = -10;
        k = i < 0 ? -i 
                : i; // get absolute value of i 
        System.out.print("Absolute value of ");
        System.out.println(i + " is " + k);
        boolean questionMark=false;
        int result=5;
        int variable=4;
        
        System.out.println(questionMark?result:variable);
        
    }

}
