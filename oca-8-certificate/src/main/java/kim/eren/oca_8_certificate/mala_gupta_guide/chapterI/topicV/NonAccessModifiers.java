package kim.eren.oca_8_certificate.mala_gupta_guide.java_basics.topicI_V;

public class NonAccessModifiers{
    final static StringBuilder b = new StringBuilder().append("java");

    public static void main(String[] args) {
        reAssignSb(b);
    }
//thats method scope and variable couldn't declared as a final so you can reassign 
    public static void reAssignSb(StringBuilder sb){
        sb = new StringBuilder();
        System.out.println("avaj");
    }

}

abstract interface Eren{
     abstract public void selam();
}