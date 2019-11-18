package kim.eren.oca_8_certificate.oca_study_guide.chapter5.polymorphism;

class GrandPa{
    public final double secret=2;
}

class Father extends GrandPa{
    public final double secret=4;
}

public class ParentChildVariableRelativity extends Father{
    public final double secret=8;

    public static void main(String[] args) {
        GrandPa relativity = new ParentChildVariableRelativity();
        System.out.println(relativity.secret);
    }
}