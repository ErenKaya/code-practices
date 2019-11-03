package kim.eren.oca_8_certificate.oca_study_guide.chapter4.lambda;
public class CheckIfHopper implements Checker{

    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }

}