package kim.eren.oca_8_certificate.mala_gupta_guide.chapterV.topicII.default_interfaces;

public interface B{
    default void testThisKeyword(){
        System.out.println(this);
        this.print();
    }
    abstract void print();
}