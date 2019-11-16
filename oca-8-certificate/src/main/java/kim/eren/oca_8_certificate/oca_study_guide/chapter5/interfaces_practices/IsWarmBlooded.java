package kim.eren.oca_8_certificate.oca_study_guide.chapter5.interfaces_practices;


public interface IsWarmBlooded{ 
    public default void aMethodWithBodyInInterface(){
        System.out.println("method have a body");
    }
    public default void aMethodWithBodyInInterface2(){
        System.out.println("method have a bod2y");
    }
    static void callStatic(){
        System.out.println("static method called");
    };

    abstract void getWarmLevel();
}

interface WarmBlooded2 extends IsWarmBlooded{

}

class Person implements WarmBlooded2{

    @Override
    public void getWarmLevel() {

    }

}

class Test{
    public static void main(String[] args) {
        IsWarmBlooded instance = new Person();
        instance.aMethodWithBodyInInterface();
        instance.aMethodWithBodyInInterface2();    
    }
}