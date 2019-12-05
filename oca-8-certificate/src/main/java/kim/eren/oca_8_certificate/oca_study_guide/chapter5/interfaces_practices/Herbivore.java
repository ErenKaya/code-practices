package kim.eren.oca_8_certificate.oca_study_guide.chapter5.interfaces_practices;

public interface Herbivore{
    public int eatPlants();
    // if default values exist in two classes the code doesn not compile
    default void walk1(){
        System.out.println("omnivore walking");
    }

}