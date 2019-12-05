package kim.eren.oca_8_certificate.oca_study_guide.chapter5.interfaces_practices;

// There is a compile error because of same method have each other but
// return type is diffrent compiler doesn't look that its only compare parameters
// if default values exist in two classes the code doesn not compile
public interface SuperVore extends Omnivore,Herbivore{ 

}