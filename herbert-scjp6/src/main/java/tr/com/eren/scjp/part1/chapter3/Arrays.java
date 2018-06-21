
package tr.com.eren.scjp.part1.chapter3;


public class Arrays {
    public static void main(String[] args) {
        double nums[] ={10.1,11.2,12.3,13.4,14.5};
        double result=0;
        int i;
        for(i=0;i<nums.length;i++){
            result=result+nums[i];
        }
        System.out.println("Average "
                + result/5);
    }

}
