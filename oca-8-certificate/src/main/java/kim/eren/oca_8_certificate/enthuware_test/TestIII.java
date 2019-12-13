package kim.eren.oca_8_certificate.enthuware_test;

public class TestIII {
    public static void main(String[] args) {
        int i = 0;
        
            System.out.println("args null"+args.length);
        
        if(i++<1){
            System.out.println("execute to right and checks control");
            System.out.println(i);
        }else{
            System.out.println("checks first then other statement value increments");
        }
        
    }
}