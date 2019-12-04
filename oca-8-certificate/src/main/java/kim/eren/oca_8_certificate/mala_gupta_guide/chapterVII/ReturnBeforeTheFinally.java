package kim.eren.oca_8_certificate.mala_gupta_guide.chapterVII;

public class ReturnBeforeTheFinally{
    // in object you can modify object before the return in finally
    static StringBuilder getStringBuilder(){
        StringBuilder s = new StringBuilder();
        try {
            s.append("10");
            String[] nameArray = {"Eren"};
            System.out.println("array"+nameArray[2]);
        } catch (Exception e) {
            System.out.println("returning value"+s);
            return s;
        }finally{
            s.append("10");
            System.out.println("FinallyExecuted"+s);
        }
        return null;
    }
    // finally block can assign value but if return in catch assigned value cannot modify the value
    static String getString(){
        String s = new String();
        try {
            s = "10";
            String[] nameArray = {"Eren"};
            System.out.println("array"+nameArray[2]);
        } catch (Exception e) {
            System.out.println("returning value"+s);
            return s;
        }finally{
            s = s.replace("1","2");
            System.out.println("FinallyExecuted"+s);
        }
        return null;
    }
    public static void main(String[] args) {
            System.out.println("gettingstring"+getString());
    }
}