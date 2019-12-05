package kim.eren.oca_8_certificate.mala_gupta_guide.chapterVII;

public class ShouldWeCatchErrors{
    public static void main(String[] args) {
        try {
            myMethod();
        } catch (StackOverflowError e) {
            // StackOverFlow error must be handle by jvm
            // because that code may executes may not
            // you can get an error which virtualmachineerror
            for(int i = 0 ; i<2;i++)
                System.out.println(i);
        }
    }

    public static void myMethod(){
        myMethod();
    }
}