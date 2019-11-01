package kim.eren.oca_8_certificate.oca_study_guide.chapter4;
public class StaticInstance{
    public static int count;

    public void increaseCount(){
        count++;
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        System.out.println(Counter.count);
        
    }
}
class Counter {
    public static int count;
    public Counter(){
        count++;
    }
}