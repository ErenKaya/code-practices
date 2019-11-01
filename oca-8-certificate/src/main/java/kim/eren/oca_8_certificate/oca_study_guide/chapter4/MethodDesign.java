package kim.eren.oca_8_certificate.oca_study_guide.chapter4;
public class MethodDesign{
    public static void walk(int a, int... aList){
        System.out.println("aList length: "+aList.length);
    }
    public static void main(String[] args){
        walk(1);
        walk(1,2);
        walk(1,2,3);
        walk(1,new int[]{1,2});
    }
}