package kim.eren.oca_8_certificate.oca_study_guide.chapter5.interfaces_practices;


public interface IsWarmBlooded{ 
    public default void aMethodWithBodyInInterface(){
        System.out.println("method have a body");
    }
    public default void aMethodWithBodyInInterface2(){
        System.out.println("method have a bod2y");
    }
}

class Person implements IsWarmBlooded{

}

class Test{
    public static void main(String[] args) {
        IsWarmBlooded instance = new Person();
        instance.aMethodWithBodyInInterface();
        instance.aMethodWithBodyInInterface2();    
    }
}