
public class AssertTest {

    int LOCAL_RATE = 12;
    private void computeAmount(int rate){
//        assert rate=LOCAL_RATE : "Invalid Rate";
    }

    public static void main(String[] args) {
        AssertTest test = new AssertTest();
        test.computeAmount(12);
    }

}
