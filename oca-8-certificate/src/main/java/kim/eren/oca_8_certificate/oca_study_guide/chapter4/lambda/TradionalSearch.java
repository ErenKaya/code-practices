package kim.eren.oca_8_certificate.oca_study_guide.chapter4.lambda;

import java.util.ArrayList;
import java.util.List;import java.util.List;
import java.util.Random;

public class TradionalSearch{
    public static void main(String[] args) {
   
        List<Animal> animals = new ArrayList<Animal>(); // list of animals
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        print(animals, new CheckIfHopper());
        //i declare a method which type of Checker 
        //Checker interface must have a only one method
        //c1 means test method which is declared in Checker Interface behaviour
        // that method behaviours strange now 
        // that aproach can be count as a closure because of your method used in target method
        Checker c1 =  a->{
               if(new Random().nextBoolean()){
                return a.canSwim();
               }else{ 
                return a.canHop();}};
        print(animals,c1);
        print(animals, a->a.canSwim());
                // pass class that does check
        }
        
        private static void print(List<Animal> animals, Checker checker) {
        for (Animal animal : animals) {
        if (checker.test(animal))
        // the general check
        System.out.print(animal + " ");
   
        }
        System.out.println();
     
        }
}