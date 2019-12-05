package kim.eren.oca_8_certificate.oca_study_guide.chapter3.lambda;

import java.util.function.Predicate;

public class PredicateTests {

    public static void main(String[] args) {
        Predicate<String> s =  i -> i.startsWith("s");
    }
}