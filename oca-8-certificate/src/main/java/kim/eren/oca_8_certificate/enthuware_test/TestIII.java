package kim.eren.oca_8_certificate.enthuware_test;

public class TestIII {

    // test done i have failed this testIII 
    public static void main(String[] args) throws Exception {
        int i = 0;
            String String = new String("asd");
            System.out.println("args null"+args.length);
        
        if(i++<1){
            System.out.println("execute to right and checks control");
            System.out.println(i);
        }else{
            System.out.println("checks first then other statement value increments");
        }
        nullExceptionTest();
    }
    // you can throw exception instance as a null 
    // but e couldn't throw then null pointer exception occured
    public static void nullExceptionTest() throws Exception{
        Exception e = null;
        throw e;
    }
}