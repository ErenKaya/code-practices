package kim.eren.oca_8_certificate.oca_study_guide.chapter5.contructorcall;

public class Rose extends Plant {

    // if you use super in one of constructor then you point it to call super
    // you can use this and point to that class, that way solve compile error
    public Rose(){
        this(2);
    }

    public Rose(int age){
         super(age);
    }
}