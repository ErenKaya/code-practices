package kim.eren.oca_8_certificate.mala_gupta_guide.chapterVII;

interface CExceptionMethod{
    void ceTest() throws Exception;
    void unCeTest() throws NullPointerException;
}

public class CheckedExceptionTest implements CExceptionMethod{
    @Override
    public void ceTest() throws Exception{
        return;
    }

    @Override
    public void unCeTest() throws NullPointerException{
        return;
    }

    public static void main(String[] args) {
        CheckedExceptionTest cTest = new CheckedExceptionTest();
        // there is a compile error because of checked exception
        // cTest.ceTest();
        cTest.unCeTest();
    }
}