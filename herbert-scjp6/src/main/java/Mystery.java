

public class Mystery {
    String s;
    public static void main(String[] args) {
        Mystery m = new Mystery();
        m.go();
    }
    void Mystery(){
        this.s="Constructor";
    }
    void go(){
        System.out.println(s);
    }

}
